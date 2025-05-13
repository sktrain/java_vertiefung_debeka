package sk.train;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import sk.train.observer.weather.sol1.CurrentConditionsDisplay;
import sk.train.observer.weather.sol1.ForecastDisplay;
import sk.train.observer.weather.sol1.HeatIndexDisplay;
import sk.train.observer.weather.sol1.WeatherData;
import sk.train.observer.weather.sol1.WeatherStation;

class WeatherSol1_IntegrationTest {
	
	private static WeatherStation station;
	private static CurrentConditionsDisplay currentDisplay;
	private static HeatIndexDisplay heatDisplay;
	private static ForecastDisplay forecastDisplay;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		station = new WeatherStation();
		// Observer instantiieren und Ihnen die Referenz auf das Observable übergeben
		currentDisplay = new CurrentConditionsDisplay(station);
		heatDisplay = new HeatIndexDisplay(station);
		forecastDisplay = new ForecastDisplay(station);
	}
	
	
	void TestRegistered() {
		assertTrue(station.isRegistered(forecastDisplay));
		assertTrue(station.isRegistered(heatDisplay));
		assertTrue(station.isRegistered(currentDisplay));
	}
	
	
	@Test
	void testWeatherDataUpdate() {		
		
		WeatherData weatherData = new WeatherData();

		// Wetteränderungen durchführen: sollte zu Benachrichtigung der Observer führen
		// und die erzeugen entsprechende Ausgaben

		weatherData.setMeasurements(80, 65, 30.4f);
		station.changeWeather(weatherData);
		assertEquals(80, currentDisplay.getTemperature());
		assertEquals(65, currentDisplay.getHumidity());

	}

}
