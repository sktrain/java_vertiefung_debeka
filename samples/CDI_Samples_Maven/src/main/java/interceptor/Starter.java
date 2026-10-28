package interceptor;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import musiker.beans.Musiker;

public class Starter {
	
	public static void main(String[] args) {
		
	try(SeContainer secontainer = SeContainerInitializer.newInstance().initialize()) {
			// start the container, retrieve a bean and do work with it
			
			Mathematiker m = secontainer.select(Mathematiker.class).get();
			m.add(2, 2);
			m.diff(4, 2);
			
		}
			// shuts down automatically after the try with resources block.
	}
}
