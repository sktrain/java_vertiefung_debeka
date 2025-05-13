package sk.train;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import sk.train.observer.weather.sol2.CurrentConditionsDisplay;
import sk.train.observer.weather.sol2.ForecastDisplay;
import sk.train.observer.weather.sol2.HeatIndexDisplay;
import sk.train.observer.weather.sol2.WeatherData;
import sk.train.observer.weather.sol2.WeatherStation;


class WeatherSol2_IntegrationTest {
	
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
		assertEquals(3, station.countObservers());
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
