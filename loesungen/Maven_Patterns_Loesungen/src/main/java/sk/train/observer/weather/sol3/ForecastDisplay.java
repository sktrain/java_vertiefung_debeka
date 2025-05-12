package sk.train.observer.weather.sol3;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ForecastDisplay implements PropertyChangeListener, DisplayElement {
	
	private float currentPressure ;  
	private float lastPressure ;
	

	public ForecastDisplay(WeatherStation weatherStation) {
		super();
		weatherStation.addPropertyChangeListener(this);
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
	public void propertyChange(PropertyChangeEvent evt) {
		WeatherData newdata = (WeatherData) evt.getNewValue();
		WeatherData olddata = (WeatherData) evt.getOldValue();
		this.currentPressure = newdata.getPressure();
		this.lastPressure = olddata.getPressure();
		display();
	}

}
