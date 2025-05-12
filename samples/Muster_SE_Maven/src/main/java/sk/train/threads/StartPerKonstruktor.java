package sk.train.threads;

import java.util.Date;

public class StartPerKonstruktor {

	public static void main(String[] args) {
		//Nutzen von Autostart
		Autostart auto = new Autostart();

	}

}

class Autostart implements Runnable {
	
	Autostart(){
		new Thread(this).start();
	}

	@Override
	public void run() {
		for(int i = 0; i<20; ++i){
			System.out.println(new Date());
		}
		
	}
	
}
