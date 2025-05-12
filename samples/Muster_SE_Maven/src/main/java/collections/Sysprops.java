package collections;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;


public class Sysprops {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Map p  = System.getProperties(); 
		
		/*Enumeration e = p.keys();
		
		String key = null;
		while (e.hasMoreElements()){
			key = (String)e.nextElement();
			System.out.println("key: "+ key+ " = "+ p.getProperty(key));
		}*/
		
		try {
			((Properties)p).storeToXML(System.out, "Meine Ausgabe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
