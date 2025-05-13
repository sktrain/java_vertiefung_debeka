package sk.train.observer.weather.sol_Reactive;

import java.util.concurrent.SubmissionPublisher;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		
		//Publisher mit default-Einstellungen
		SubmissionPublisher<WeatherData> publisher = new SubmissionPublisher<WeatherData>();
		
		WeatherStation station = new WeatherStation(publisher);
		
		WeatherData weatherData = new WeatherData();
		
		//Observer instantiieren  und Ihnen die Referenz auf das Observable übergeben
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(station);
		HeatIndexDisplay heatDisplay = new HeatIndexDisplay(station);
		ForecastDisplay forecastDisplay = new ForecastDisplay(station);

		
		//Wetteränderungen durchführen: sollte zu Benachrichtigung der Observer führen und die erzeugen entsprechende Ausgaben
			
		weatherData.setMeasurements(80, 65, 30.4f);	
		station.changeWeather(weatherData);
		
		Thread.sleep(5000); //5 Sekunden warten
		
		//todo mit weiteren Wetterdaten
		
		weatherData.setMeasurements(82, 70, 29.2f);
		station.changeWeather(weatherData);
		
		Thread.sleep(5000); //5 Sekunden warten
		
		weatherData.setMeasurements(78, 90, 29.2f);
		station.changeWeather(weatherData);
		
		Thread.sleep(1000);
		//Beenden der Sendeseite (Herunterfahren dews Thread-Pools)
		station.finish();
		
		
	}
}
