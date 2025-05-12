package sk.train.observer.weather;

//die Application-Klasse schraubt das ganze zusammen
public class Application {

	public static void main(String[] args) throws InterruptedException {
		
		WeatherStation station = new WeatherStation();
		
		WeatherData weatherData = new WeatherData();
	
		//Observer instantiieren  und Ihnen die Referenz auf das Observable übergeben
		
		//Wetteränderungen durchführen: sollte zu Benachrichtigung der Observer führen und die erzeugen entsprechende Ausgaben
			
		weatherData.setMeasurements(80, 65, 30.4f);	
		station.changeWeather(weatherData);
		
		Thread.sleep(5000); //5 Sekunden warten
		
		//todo mit weiteren Wetterdaten
		
		//weatherData.setMeasurements(82, 70, 29.2f);
		
		//weatherData.setMeasurements(78, 90, 29.2f);
	}

}
