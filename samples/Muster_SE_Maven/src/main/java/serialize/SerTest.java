package serialize;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class SerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		{
			     try {
			       //FileOutputStream fs = new FileOutputStream();
			       ObjectOutputStream os = new ObjectOutputStream(System.out);
			       os.writeInt(123);
			       os.writeObject("Hallo");
			       os.writeObject(new Time(10, 30));
			       os.writeObject(new Time(11, 25));
			       os.close();
			     } catch (IOException e) {
			       System.err.println(e.toString());
			     }
			   }

	}

}

class Time
 implements Serializable
 {
   private int hour;
   private int minute;
 
   public Time(int hour, int minute)
   {
     this.hour = hour;
     this.minute = minute;
   }
 
   public String toString()
   {
   return hour + ":" + minute;
   }
 }
