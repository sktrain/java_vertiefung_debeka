package sk.train.observer.weather.sol_Reactive;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;

//dies soll das Observable sein
public class WeatherStation {

	private WeatherData weatherData;
	
	private SubmissionPublisher<WeatherData> publisher;
	
	//so kann der Publisher von auﬂen mit unterschiedlichen Parametrisierungen	gesetzt werden
	public WeatherStation (SubmissionPublisher<WeatherData> publisher) { 
		this.publisher = publisher;
	}
	
	public void changeWeather(WeatherData weatherData) {
		this.weatherData = weatherData;
		System.err.println("submit durch Thread: " + Thread.currentThread());
		//senden der Nachricht an die Subscriber 
		publisher.submit(weatherData);		
	}
	
	
	//delegiert die Registrierung der Subscriber an den Publisher
	public void subscribe(Subscriber<WeatherData> subscriber)
	{
		publisher.subscribe(subscriber);
	}
	
	
	//delegiert an die close-Methode des Publishers
	public void finish() {
		publisher.close();
	}
	
}
