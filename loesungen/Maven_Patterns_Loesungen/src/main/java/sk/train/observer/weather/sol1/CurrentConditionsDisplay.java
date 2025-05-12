package sk.train.observer.weather.sol1;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	
	private float temperature;
	private float humidity;	
	private Observable weatherStation;
	
	public CurrentConditionsDisplay(Observable weatherStation) {
		super();
		this.weatherStation = weatherStation;
		weatherStation.registerObserver(this);
	}
	
	public void update(WeatherData data) {
		this.temperature = data.getTemperature();
		this.humidity = data.getHumidity();
		display();
	}
	
	public void display() {
		System.out.println("Current conditions: " + temperature 
			+ "F degrees and " + humidity + "% humidity");
	}

	
	//for testing purpose
	public float getTemperature() {
		return temperature;
	}

	//for testing purpose
	public float getHumidity() {
		return humidity;
	}

		
}
