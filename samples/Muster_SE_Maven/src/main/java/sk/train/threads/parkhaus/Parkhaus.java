package sk.train.threads.parkhaus;

public class Parkhaus {
	
	private int places = 10;

	public Parkhaus(int places) {
		super();
		this.places = places;
	}
	
	public synchronized void enter(){
		while (places == 0);
		--places;
	}
	
	public synchronized void leave(){
		++places;
	}

}
