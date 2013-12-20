import java.applet.*;
import java.awt.*;

public class Lab2_4 extends Applet {
	public void init() {
		String parmString =  getParameter("number");
		n = Integer.parseInt(parmString);
	}

	public void paint(Graphics g) {
		if( n==1 || n==2){
			if(n==2)
				setBackground(Color.cyan);
			g.setColor(Color.green);
			g.drawRect(10, 10, 100, 100);
			g.fillRect(45, 110, 35, 125);
			
			g.setColor(new Color(100, 50, 210));
			g.fillOval(30, 20, 15, 30);
			g.fillOval(80, 20, 15, 30);
			
			g.setColor(Color.red);
			g.drawPolygon(xPoints, yPoints, 9);
		}
	}

	int n;
	int xPoints[] = {20, 30, 40, 50, 60, 70, 80, 90, 100};
    int yPoints[] = {90, 100, 90, 100, 90, 100, 90, 100, 90};
}