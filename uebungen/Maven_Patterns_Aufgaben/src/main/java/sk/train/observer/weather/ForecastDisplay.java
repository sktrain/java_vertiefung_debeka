package sk.train.observer.weather;

import java.util.*;

//ein weiterer Observer
public class ForecastDisplay implements DisplayElement {
	private float currentPressure = 29.92f;  
	private float lastPressure;
	private Observable weatherStation;

	public ForecastDisplay(Observable weatherStation) {
		super();
		this.weatherStation = weatherStation;
	}

	//todo

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
}
