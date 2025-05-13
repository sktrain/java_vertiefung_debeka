package sk.train.parking;

import java.util.concurrent.Semaphore;

class ParkingGarage
{
    private int places;
    private Semaphore s;
    

    public ParkingGarage(int places)
    {
        if(places < 0)
            places = 0;
        this.places = places;
        this.s = new Semaphore(places, true);
    }

    public  void enter()
    {
        try {
			s.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        places--;
    }

    public  void leave()
    {
    	places++; 
    	s.release();
    }
}

class Car extends Thread
{
    private ParkingGarage garage;

    public Car(String name, ParkingGarage garage)
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

public class Parking_Semaphor
{
    public static void main(String[] args)
    {
        ParkingGarage garage = new ParkingGarage(20);
        for(int i = 1; i <= 40; i++)
        {
            new Car("Auto " + i, garage);
        }
    }
}