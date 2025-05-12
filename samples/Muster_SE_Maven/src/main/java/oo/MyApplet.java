package oo;


import java.applet.Applet;
import java.awt.*;

public class MyApplet extends Applet {
	
	@Override
	public void paint(Graphics g)    {
       g.drawString("Java ist heiss!",  25, 50);
    }

}
