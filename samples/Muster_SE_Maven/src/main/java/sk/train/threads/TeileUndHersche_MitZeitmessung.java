package sk.train.threads;

class MyService implements Runnable
{
    private boolean[] array;
    private int start;
    private int end;
    private int result;

    public MyService(boolean[] array, int start, int end)
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
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
            }
        }
    }
}


class MyDispatcher
{
    private int ARRAY_SIZE;
    private int NUMBER_OF_SERVERS;

    public MyDispatcher(int dimension, int anzahl)
    {
        //Setzen der Feldgröße und der Anzahl Threads
    	ARRAY_SIZE = dimension;
    	NUMBER_OF_SERVERS = anzahl;
    	
    	// Startzeit messen
        long startTime = System.currentTimeMillis();
        
        /*
         * Feld erzeugen mit zufälliger Mischung aus true und false
         * (jeder 10. Wert ist true)
         */
        boolean[] array = new boolean[ARRAY_SIZE];
        for(int i = 0; i < ARRAY_SIZE; i++)
        {
            if(Math.random() < 0.1)
                array[i] = true;
            else
                array[i] = false;
        }

        // Feld für Services und Threads erzeugen
        MyService[] service = new MyService[NUMBER_OF_SERVERS];
        Thread[] serverThread = new Thread[NUMBER_OF_SERVERS];
        // Threads erzeugen
        int start = 0;
        int end;
        int howMany = ARRAY_SIZE / NUMBER_OF_SERVERS;
        for(int i = 0; i < NUMBER_OF_SERVERS; i++)
        {
            if(i < NUMBER_OF_SERVERS - 1)
            {
                end = start + howMany - 1;
            }
            else
            {
                end = ARRAY_SIZE - 1;
            }
            service[i] = new MyService(array, start, end);
            serverThread[i] = new Thread(service[i]);
            serverThread[i].start();
            start = end + 1;
        }

        // Synchronisation mit Servern (auf Serverende warten)
        try
        {
            for(int i = 0; i < NUMBER_OF_SERVERS; i++)
                serverThread[i].join();
        }
        catch(InterruptedException e)
        {
        }

        // Gesamtergebnis aus Teilergebnissen berechnen
        int result = 0;
        for(int i = 0; i < NUMBER_OF_SERVERS; i++)
        {
            result += service[i].getResult();
        }

        // Endzeit messen
        long endTime = System.currentTimeMillis();
        float time = (endTime - startTime) / 1000.0f;
        
        // Ergebnis ausgeben
        System.out.println("\n");
        System.out.println("Dimension: " + ARRAY_SIZE + "\t" + "Anzahl Threads: " + NUMBER_OF_SERVERS);
        System.out.println("Rechenzeit: " + time);
        System.out.println("Ergebnis: " + result);
    }
}

public class TeileUndHersche_MitZeitmessung{
	
	public static void main(String[] args){
		int dimension = 100000;
		for (int i = 1; i<=dimension; i=i*10){
			MyDispatcher d = new MyDispatcher(dimension, i);
		}
	}
	
}
