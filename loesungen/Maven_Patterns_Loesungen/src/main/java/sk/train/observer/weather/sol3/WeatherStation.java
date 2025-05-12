package sk.train.observer.weather.sol3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

//dies soll das Observable sein
public class WeatherStation {

	private WeatherData weatherData;
	private PropertyChangeSupport sup;

	public WeatherStation() {
		sup = new PropertyChangeSupport(this);
		//da beim Start noch keine alten Werte vorliegen, setzen auf Defaults
		weatherData = new WeatherData();
		weatherData.setMeasurements(0, 0, 0);
	}

//	public WeatherData getWeatherData() {
//		return weatherData;
//	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		sup.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		sup.removePropertyChangeListener(l);
	}

	//bei diesem Ansatz müssen alt und neu verschiedene Objekte sein!!
	public void changeWeather(WeatherData weatherData) {
		WeatherData olddata = new WeatherData();
		olddata.setMeasurements(this.weatherData.getTemperature(), this.weatherData.getHumidity(), this.weatherData.getPressure());
		this.weatherData = weatherData;
		sup.firePropertyChange("weatherData", olddata, weatherData);
	}

	
	//for Testing purpose
	public PropertyChangeSupport getSup() {
		return sup;
	}
	

}
