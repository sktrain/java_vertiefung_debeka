package sk.train.observer.weather.sol_Reactive;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class HeatIndexDisplay implements Subscriber<WeatherData>, DisplayElement {
	
	private float heatIndex = 0.0f;
	
	public HeatIndexDisplay(WeatherStation weatherStation) {
		super();
		weatherStation.subscribe(this);
	}

	private float computeHeatIndex(float t, float rh) {
		float index = (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) 
			+ (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) 
			+ (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
			(0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 * 
			(rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) + 
			(0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
			0.000000000843296 * (t * t * rh * rh * rh)) -
			(0.0000000000481975 * (t * t * t * rh * rh * rh)));
		return index;
	}

	public void display() {
		System.out.println("Heat index is " + heatIndex);
	}

	
	@Override
	public void onSubscribe(Subscription subscription) {
		System.err.println("HeatIndexdisplay:onSubscribe durch Thread: " + Thread.currentThread());
		subscription.request(Long.MAX_VALUE);
		
	}

	@Override
	public void onNext(WeatherData item) {
		System.err.println("HeatIndexdisplay:onNext durch Thread: " + Thread.currentThread());
		heatIndex = computeHeatIndex(item.getTemperature(), item.getHumidity());
		display();
		
	}

	@Override
	public void onError(Throwable throwable) {
		// nur zur besseren Nachverfolgung
		System.err.println(throwable);
		
	}

	@Override
	public void onComplete() {
		System.err.println("HeatIndexdisplay:onCompletee durch Thread: " + Thread.currentThread());
		// nur zur besseren Nachverfolgung
		System.out.println("HeatIndex: es wird nichts mehr gesendet");
		
	}
}
