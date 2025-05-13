package sk.train.observer.weather.sol_Reactive;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class CurrentConditionsDisplay implements Subscriber<WeatherData>, DisplayElement {

	private float temperature;
	private float humidity;
	private Subscription subscription;
	
	
	public CurrentConditionsDisplay(WeatherStation weatherStation) {
		//Registrierung beim Sender/Publisher
		weatherStation.subscribe(this);
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;		//wird in diesem einfachen Fall nicht wirklich benötigt	
		this.subscription.request(Long.MAX_VALUE);  //kann uns beliebig viele senden
	}

	@Override
	public void onNext(WeatherData item) {
		System.err.println("Conditiondisplay:onNext durch Thread: " + Thread.currentThread());
		temperature = item.getTemperature();
		humidity = item.getHumidity();
		display();
	}

	@Override
	public void onError(Throwable throwable) {
		// nur zur besseren Nachverfolgung
		System.err.println(throwable);
		
	}

	@Override
	public void onComplete() {
		System.err.println("Conditiondisplay:onComplete durch Thread: " + Thread.currentThread());
		// nur zur besseren Nachverfolgung
		System.out.println("Condition: es wird nichts mehr gesendet");
		
	}


	public void display() {
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
	}

	
	// for testing purpose
	public float getTemperature() {
		return temperature;
	}

	// for testing purpose
	public float getHumidity() {
		return humidity;
	}

	
}
