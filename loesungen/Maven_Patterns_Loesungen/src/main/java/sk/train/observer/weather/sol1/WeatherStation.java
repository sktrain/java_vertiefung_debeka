package sk.train.observer.weather.sol1;

import java.util.*;

import sk.train.observer.weather.sol1.Observer;


//dies soll das Observable sein
public class WeatherStation implements Observable{

	private WeatherData weatherData;
	private ArrayList observers;
	
	
	public WeatherStation() {
		observers = new ArrayList();
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}	
	
	//for testing purpose
	public boolean isRegistered(Observer o) {
		return observers.contains(o);
	}
	
	public void changeWeather(WeatherData weatherData) {
		this.weatherData = weatherData;
		notifyObservers();
	}
	
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update(weatherData);
		}
	}	
	
}
