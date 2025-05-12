package sk.train.threads;

import javax.swing.JOptionPane;

public class WorkerThread_Fakultaet {

	//Dies ist der Haupt-Thread
	public static void main(String[] args) {
		
		int n = 1; //Für den Basiswert
		
		/* Basiswert wird über GUI-Dialog eingelesen */
		String eingabe = "";
		while (true){  //Benutzer wird solange zur Eingabe aufgefordert, bis Ganzzahl eingeben wird
			eingabe = JOptionPane.showInputDialog("Bitte positive Ganzzahl eingeben");
			try {
				n = Integer.parseInt(eingabe);
				break;
			} catch (Exception e) {
			  System.err.println("Das war nix");
			}
		}
		
		//Erzeugen des Runnable und Übergabe des Basiswerts
		Fakultaet fak = new Fakultaet(n);
		
		//Erzeugen des Threads
		Thread t = new Thread(fak);
		t.start();
		
		//Warten bis Arbeit erledigt
		try {
			t.join();
		} catch (InterruptedException e) {
			System.err.println("HauptThread wurde unerwarteterweise abgebrochen");
			e.printStackTrace();
		}
		
		//Holen und Ausgeben des Ergebnisses
		int result = fak.getResult();
		System.out.println(result); //auf Kommandozeile
		//Ausgabe per DialogBox
		JOptionPane.showMessageDialog(null, result, "Ergebnis", JOptionPane.INFORMATION_MESSAGE);
		
	}

}


//Für die Fakultaetsberechnung
class Fakultaet implements Runnable{
	
	private int n;		//Eingangswert
	private int result;		//Ergebniswert
	
	//Konstruktor für das Setzen des Basiswerts
	public Fakultaet(int n) {
		super();
		this.n = n;
	}

	//Getter für die Abfrage des Ergebniswerts
	public int getResult() {
		return result;
	}



	@Override
	public void run() {
		result = fak(n);
		/*result = 1;
		for(int i = 1; i <= n; ++i){
			result = result * i;
		}*/
	}
	
	public int fak(int n){
		if (n == 1){
			return(1);
		}
		else{
			return( n * fak(--n));
		}
		
	}
	
	
}
