package sk.train.observer.weather;

public interface Observable {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
}
