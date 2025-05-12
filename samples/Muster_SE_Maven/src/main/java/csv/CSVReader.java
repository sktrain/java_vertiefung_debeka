package csv;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Vector;

/* Bespiel zum Einlesen einer CSV-Datei, die durch Excel generiert wird.
 * Die Datei enthält für dieses Bsp. folgende 4 Spalten:
 * Name;Nummer;Datum1;Datum2	
 * Liegt im Projekt unter Ordner "resources"
 * */

public class CSVReader {

	public static void main(String[] args) {

		Scanner filescanner;  //zum zeilenweise Einlesen der Datei
		Scanner linescanner;  //zum spaltenweisen Lesen der jeweiligen Zeile
		File f = null;		//für die Datei
		Vector vline = null; Vector vtab = null;  //zum Aufbau einer Matrix, die die Zeilen und Spalten der Tabelle verkörpert
		
		//Man könnte den Dateinamen hier hart codieren
		//f = new File(".../Muster_SE/resources/Mappe1.csv");
		
		//besser: Dateiname wird beim Aufruf der Datei übergeben
		/*if (args.length == 0){
			System.err.println("Pfadname der Datei muss beim Aufruf des Programms übergeben werden");
			System.exit(1);
		}
		//da der Pfadname in Windows Leerzeichen enthalten und somit auf mehrere Übergabeargument verteilt sein kann:
		String pathname = "";
		for (int i=0; i<args.length; i=i+1){
			pathname = pathname + args[i] + " ";  //fügt manuell je Argument wieder ein Leerzeichen ein (funktioniert nicht allgemein)
		}  //Alternative statt manueller Rekonstruktion: Argument muß bei Übergabe in Hochkommata eingeschlossen werden
		//System.out.println(pathname);  //nur zum Test: Ausgabe des zusammengebauten Pfadnamens
		f = new File(pathname);
		if (!f.exists()){
			System.err.println("Datei existiert nicht");
			System.exit(1);
		}*/
		
		//noch besser: Datei wird über Dateiauswahl-Dialog (GUI) bestimmt
		//dazu dient die Klasse JFileChooser aus dem Paket javax.swing (analog JoptionPane) 
		JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "csv-Dateien", "csv");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {  //falls Auswahl getroffen wurde
	       f = chooser.getSelectedFile();  //liefert das File-Object für die ausgewählte Datei
	    } else {
	    	System.out.println("Es wurde keine Datei ausgew�hlt");
	    	System.exit(0);
	    }
		
	    //jetzt zur eigentlichen Arbeit:
	    try {
			filescanner = new Scanner(f); //Scanner zum zeilenweisen Einlesen
			vtab = new Vector(); //Vector für die Zeilen, entspricht der Tabelle
			while (filescanner.hasNextLine()){
				String line = filescanner.nextLine();
				//System.out.println(line);  //Ausgabe nur zum Test
				//innere Schleife zum spaltenweisen Lesen einer jeden Zeile
				linescanner = new Scanner(line);
				linescanner.useDelimiter(",");  //; als Trenner in der CSV-Datei
				vline = new Vector(); //ein Vector je Zeile
				for (int i = 0; linescanner.hasNext(); ++i){
					String row = linescanner.next();
					//System.out.println(row);  //Ausgabe nur zum Test
					//als Bsp: Calendar.Objekt erzeugen für das eingelesene Datum der 3.Spalte
					if (i == 2){
						Scanner datescanner = new Scanner(row); //zum Zerlegen des Datums-Strings
						datescanner.useDelimiter("\\.");
						int k = 0, day =0, month=0, year=0;
						while (datescanner.hasNextInt()){
							int x = datescanner.nextInt();
							if (k == 0){
								day =x;
							}if (k == 1){
								month =x;
							}if (k == 2){
								year =x;
							}
							
						}
						GregorianCalendar date = new GregorianCalendar(year, month, day); //Erzeugen des Calendar-Objekts
					//Ende des Bsp. mit Calendar-Objekt
					}
					vline.add(row); //Füllen des Zeilenvectors
				}
				vtab.add(vline); //Füllen der Tabelle
				
			}
		} catch (IOException e) {
			System.err.println("I/O-Fehler");
		}
		
		
		//Zum Test: Ausgabe der Matrix im CSV-Format aber mit ':' als Trenner
		for (Object line : vtab){  //äussere Schleife
			Vector v = (Vector)line;
			for (Object row: v){  //Ausgabe der einzelnen Spalten mit ':' als Trenner
				System.out.print(row + ":");
			}
			System.out.println(); //Zeilenumbruch je Zeile
		}

	}
   
}
