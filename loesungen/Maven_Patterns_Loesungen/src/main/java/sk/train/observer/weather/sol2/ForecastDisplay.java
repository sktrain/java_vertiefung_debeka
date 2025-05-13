package sk.train.observer.weather.sol2;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
	
	private float currentPressure = 29.92f;  
	private float lastPressure;
	private Observable weatherStation;

	public ForecastDisplay(Observable weatherStation) {
		super();
		this.weatherStation = weatherStation;
		weatherStation.addObserver(this);
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
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherStation) {
			WeatherData weatherData = (WeatherData) arg;
			lastPressure = currentPressure;
			currentPressure = weatherData.getPressure();
			display();
		}
		
	}
}
