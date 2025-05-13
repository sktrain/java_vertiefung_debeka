package sk.train.observer.weather.sol2;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	private Observable weatherStation;

	public CurrentConditionsDisplay(Observable weatherStation) {
		super();
		this.weatherStation = weatherStation;
		weatherStation.addObserver(this);
	}

	public void display() {
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherStation) {
			WeatherData weatherData = (WeatherData) arg;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}

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
