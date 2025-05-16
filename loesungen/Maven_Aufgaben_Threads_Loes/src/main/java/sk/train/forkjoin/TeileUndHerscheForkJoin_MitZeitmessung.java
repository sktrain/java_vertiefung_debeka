package sk.train.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

@SuppressWarnings("serial")
class MyService extends RecursiveTask<Integer> {
	
	private boolean[] array;
	private int result;
	private int start;
	private int end;
	private int limit; // Schwellwert für die Zerlegung

	public MyService(boolean[] array, int start, int end, int limit) {
		super();
		this.array = array;
		this.start = start;
		this.end = end;
		this.limit = limit;
	}

	@Override
	protected Integer compute() {
		
//		log();

		if (end - start < limit) { // mach es selbst
			for (int i = start; i <= end; i++) {
				if (array[i]) {
					result++;
					
//					  try { Thread.sleep(1); } catch (InterruptedException e) { // TODO	  Auto-generated catch block 
//						  e.printStackTrace(); }
					 
				}
			}
			return result;
		}

		else { // fork + join

			// teile die Aufgabe (fork)
			int middle = (start+end) / 2;
			MyService lefttask = new MyService(array, start, middle, limit);
			MyService righttask = new MyService(array, middle + 1, end, limit);

			//int rightresult = righttask.compute(); // eine Teilaufgabe selbst (rekursiv)
			
			lefttask.fork(); // (Teilaufgabe abgespalten)
			
			int rightresult = righttask.compute(); // eine Teilaufgabe selbst (rekursiv)
			
			// join
			int leftresult = lefttask.join();

			return leftresult + rightresult;
		}

	}

	private void log() {
		System.out.println("Aktueller Startindex: " + start + "\tAktueller Endindex: " + end);
		System.out.println("Aktueller Thread: " + Thread.currentThread());
	}
}

class MyDispatcher {

	public MyDispatcher(int array_size, int parallelism, int limit) {
		super();
		

	// Startzeit messen
	long startTime = System.currentTimeMillis();

	/*
	 * Feld erzeugen mit zufälliger Mischung aus true und false (jeder 10. Wert ist
	 * true)
	 */
	boolean[] array = new boolean[array_size];
	for(	int i = 0; i<array.length; i++)
	{
		if (Math.random() < 0.1)
			array[i] = true;
		else
			array[i] = false;
	}

	// ForkJoinPool erzeugen	
	ForkJoinPool fjp = new ForkJoinPool(parallelism);
	
	//Aufgabe übergeben
	int result = fjp.invoke(new MyService(array, 0, array.length-1, limit));
	

	// Endzeit messen
	long endTime = System.currentTimeMillis();
	float time = (endTime - startTime) / 1000.0f;

	// Ergebnis ausgeben
	System.out.println("\n");
	System.out.println("Dimension: " + array_size +  "\tParallelität: "+parallelism + "\tZerlegungslimit: " + limit);
	System.out.println("Rechenzeit: "+time);
	System.out.println("Ergebnis: "+result);
}}

public class TeileUndHerscheForkJoin_MitZeitmessung {

	public static void main(String[] args) {
		int dimension = 100000;
		int parallelism = Runtime.getRuntime().availableProcessors();
		//int limit = 10;
		//MyDispatcher d = new MyDispatcher(dimension, parallelism, limit);
		for (int i = 10; i <= dimension; i = i * 10) {
			MyDispatcher d = new MyDispatcher(dimension, 8, i);
		}
	}

}
