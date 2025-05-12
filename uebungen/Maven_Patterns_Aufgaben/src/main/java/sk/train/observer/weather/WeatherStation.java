package sk.train.observer.weather;

import java.util.*;


//dies soll das Observable sein
public class WeatherStation {

	private WeatherData weatherData;
	
	public void changeWeather(WeatherData weatherData) {
		this.weatherData = weatherData;
	}
	
	
}
