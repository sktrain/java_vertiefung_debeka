package sk.train.parking;

class Parkhaus {
	
	private int places;

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

class Car1 extends Thread
{
    private Parkhaus garage;

    public Car1(String name, Parkhaus garage)
    {
        super(name);
        this.garage = garage;
        start();
    }

    public void run()
    {
        while(true)
        {
            try
            {
                sleep((int) (Math.random() * 10000));
            }
            catch(InterruptedException e)
            {
            }
            garage.enter();
            System.out.println(getName() + ": eingefahren");
            try
            {
                sleep((int) (Math.random() * 20000));
            }
            catch(InterruptedException e)
            {
            }
            System.out.println(getName() + ": ausgefahren");
            garage.leave();
        }
    }
}

public class Parking
{
    public static void main(String[] args)
    {
        Parkhaus garage = new Parkhaus(20);
        for(int i = 1; i <= 40; i++)
        {
            new Car1("Auto " + i, garage);
        }
    }
}