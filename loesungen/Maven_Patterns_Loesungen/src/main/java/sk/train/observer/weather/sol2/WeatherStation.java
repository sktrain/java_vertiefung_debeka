package sk.train.observer.weather.sol2;

import java.util.Observable;

//dies soll das Observable sein
public class WeatherStation extends Observable{

	private WeatherData weatherData;
		
	public WeatherStation() {		
	}
	
	public void changeWeather(WeatherData weatherData) {
		this.weatherData = weatherData;
		setChanged();
		notifyObservers(weatherData);
	}
	
	
}
