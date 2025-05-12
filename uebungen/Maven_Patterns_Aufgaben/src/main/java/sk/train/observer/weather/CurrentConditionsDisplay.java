package sk.train.observer.weather;

//todo: Dies soll ein potentieller Observer sein
public class CurrentConditionsDisplay implements DisplayElement {
	
	private float temperature;
	private float humidity;
	private Observable weatherStation;
	
	public CurrentConditionsDisplay(Observable weatherStation) {
		super();
		this.weatherStation = weatherStation;
	}

	
	public void display() {
		System.out.println("Current conditions: " + temperature 
			+ "F degrees and " + humidity + "% humidity");
	}
}
