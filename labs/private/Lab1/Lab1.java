import java.applet.*;
import java.awt.*;

public class Lab1 extends Applet {
	public void paint(Graphics g) {
		g.drawString("Hello world from a PC-developed and compiled Java app", 20, 20);
		g.setColor(Color.red);
		g.fillOval(20, 20, 50, 50);
	}
}
