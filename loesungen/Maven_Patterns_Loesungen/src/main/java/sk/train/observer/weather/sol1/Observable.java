package sk.train.observer.weather.sol1;

public interface Observable {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
}

