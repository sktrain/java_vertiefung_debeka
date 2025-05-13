package sk.train.observer.weather.sol_Reactive;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class ForecastDisplay implements Subscriber<WeatherData>, DisplayElement {
	
	private float currentPressure = 29.92f;  
	private float lastPressure;
	

	public ForecastDisplay(WeatherStation weatherStation) {
		weatherStation.subscribe(this);
	}

	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		System.err.println("Forecastdisplay:onSubscribe durch Thread: " + Thread.currentThread());
		subscription.request(Long.MAX_VALUE);
		
	}

	@Override
	public void onNext(WeatherData item) {
		System.err.println("Forecastdisplay:onNext durch Thread: " + Thread.currentThread());
		lastPressure = currentPressure;
		currentPressure = item.getPressure();
		display();
		
	}

	@Override
	public void onError(Throwable throwable) {
		// nur zur besseren Nachverfolgung
		System.err.println(throwable);
		
	}

	@Override
	public void onComplete() {
		System.err.println("Forecastdisplay:onComplete durch Thread: " + Thread.currentThread());
		// nur zur besseren Nachverfolgung
		System.out.println("Forecast: es wird nichts mehr gesendet");
		
	}
}
