package musiker;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import musiker.beans.Musiker;

public class Starter {
	
	public static void main(String[] args) {
		
	try(SeContainer secontainer = SeContainerInitializer.newInstance().initialize()) {
			// start the container, retrieve a bean and do work with it
			
			Musiker m = secontainer.select(Musiker.class).get();
			m.perform();
			
		}
			// shuts down automatically after the try with resources block.
	}
}
