package sk.train.threads;

public class ThreadJoinWithResult extends Thread {

	private int input;

	public void setInput(int input) {
		this.input = input;
	}

	private int ergebnis;

	public void run() {
		int i = input;
		for (; i <= input+10; i++) {
			System.out.println(this.getName() + " : " + i);
		}
		ergebnis = i;
	}

	public int getErgebnis() {
		return ergebnis;
	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		ThreadJoinWithResult t = new ThreadJoinWithResult();
		t.setInput(5000);
		t.start();
		if (t.isAlive()) {
			System.out.println("Erzeugter Thread läuft noch");
			try {
				t.join();
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName());
			System.out.println("Erzeugter Thread ist terminiert");
		}
		System.out.println(t.getErgebnis());
	}
}
