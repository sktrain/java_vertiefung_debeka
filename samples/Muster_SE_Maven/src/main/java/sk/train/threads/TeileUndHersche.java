package sk.train.threads;

class Service implements Runnable
{
    private boolean[] array;
    private int start;
    private int end;
    private int result;

    public Service(boolean[] array, int start, int end)
    {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public int getResult()
    {
        return result;
    }

    public void run()
    {
        for(int i = start; i <= end; i++)
        {
            if(array[i])
            {
                result++;
                /*try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
            }
        }
    }
}


class Dispatcher
{
	private boolean[] array;
	private int arraySize;
    private int numberServices;
    private MyService[] service;
    private Thread[] serverThread;

    public Dispatcher(int dimension, int anzahl)
    {
        //Setzen der Feldgr��e und der Anzahl Threads
    	arraySize = dimension;
    	numberServices = anzahl;
    	
    	/*
         * Feld erzeugen mit zuf�lliger Mischung aus true und false
         * (jeder 10. Wert ist true)
         */
        array = new boolean[arraySize];
        for(int i = 0; i < arraySize; i++)
        {
            if(Math.random() < 0.1)
                array[i] = true;
            else
                array[i] = false;
        }
        
        // Feld f�r Services und Threads erzeugen
        service = new MyService[numberServices];
        serverThread = new Thread[numberServices];
        System.out.println(arraySize+" : "+numberServices);
        
    }
    
    public void work(){
    	// Startzeit messen
        long startTime = System.currentTimeMillis();

        
        // Threads erzeugen
        int start = 0;
        int end;
        int howMany = arraySize / numberServices;
        for(int i = 0; i < numberServices; i++)
        {
            if(i < numberServices - 1)
            {
                end = start + howMany - 1;
            }
            else
            {
                end = arraySize - 1;
            }
            service[i] = new MyService(array, start, end);
            serverThread[i] = new Thread(service[i]);
            serverThread[i].start();
            start = end + 1;
        }

        // Synchronisation mit Servern (auf Serverende warten)
        try
        {
            for(int i = 0; i < numberServices; i++)
                serverThread[i].join();
        }
        catch(InterruptedException e)
        {
        }

        // Gesamtergebnis aus Teilergebnissen berechnen
        int result = 0;
        for(int i = 0; i < numberServices; i++)
        {
            result += service[i].getResult();
        }

        // Endzeit messen
        long endTime = System.currentTimeMillis();
        float time = (endTime - startTime) / 1000.0f;
        
        // Ergebnis ausgeben
        System.out.println("\n");
        System.out.println("Dimension: " + arraySize + "\t" + "Anzahl Threads: " + numberServices);
        System.out.println("Rechenzeit: " + time);
        System.out.println("Ergebnis: " + result);
    }
}

public class TeileUndHersche{
	
	public static void main(String[] args){
		int dimension = 100000;  //Dimension des Felds
		int i =100;				//Anzahl Threads
		Dispatcher d = new Dispatcher(dimension, i);
		d.work();
		
	}
	
}
