package sk.train;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.SubmissionPublisher;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import sk.train.observer.weather.sol_Reactive.CurrentConditionsDisplay;
import sk.train.observer.weather.sol_Reactive.ForecastDisplay;
import sk.train.observer.weather.sol_Reactive.HeatIndexDisplay;
import sk.train.observer.weather.sol_Reactive.WeatherData;
import sk.train.observer.weather.sol_Reactive.WeatherStation;




class WeatherSolReactive_IntegrationTest {
	
	private static WeatherStation station;
	private static CurrentConditionsDisplay currentDisplay;
	private static HeatIndexDisplay heatDisplay;
	private static ForecastDisplay forecastDisplay;
	private static SubmissionPublisher<WeatherData> publisher;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		publisher = new SubmissionPublisher<WeatherData>();
		station = new WeatherStation(publisher);
		// Observer instantiieren und Ihnen die Referenz auf das Observable übergeben
		currentDisplay = new CurrentConditionsDisplay(station);
		heatDisplay = new HeatIndexDisplay(station);
		forecastDisplay = new ForecastDisplay(station);
	}
	
	@Test
	void TestRegistered() {
		assertEquals(3, publisher.getNumberOfSubscribers());
	}
	
	
	@Test
	void testWeatherDataUpdate() {		
		
		WeatherData weatherData = new WeatherData();
		

		// Wetteränderungen durchführen: sollte zu Benachrichtigung der Observer führen
		// und die erzeugen entsprechende Ausgaben
		// hier nur für CurrentConditionsDisplay getestet
		
		

		weatherData.setMeasurements(80, 65, 30.4f);
		station.changeWeather(weatherData);
		//einen Augenblick warten! (Thread-technisch entkoppelt)
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		assertEquals(80, currentDisplay.getTemperature());
		assertEquals(65, currentDisplay.getHumidity());

	}

}
