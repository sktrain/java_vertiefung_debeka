package sk.train.observer.weather.sol3;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CurrentConditionsDisplay implements PropertyChangeListener, DisplayElement {
	
	private float temperature;
	private float humidity;	
	
	public CurrentConditionsDisplay(WeatherStation weatherStation) {
		super();
		weatherStation.addPropertyChangeListener(this);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		WeatherData newdata = (WeatherData) evt.getNewValue();
		this.temperature = newdata.getTemperature();
		this.humidity = newdata.getHumidity();
		display();
	}
	
	public void display() {
		System.out.println("Current conditions: " + temperature 
			+ "F degrees and " + humidity + "% humidity");
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
