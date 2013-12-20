import java.applet.*;
import java.awt.*;

public class Lab2_3 extends Applet {
	public void init() {
		String parmString =  getParameter("number");
		System.err.println("The single parameter: " + parmString);
		n = Integer.parseInt(parmString);
		if(n==1)
			setBackground(Color.blue);
		else if(n==2)
			setBackground(Color.red);
		else
			setBackground(Color.cyan);
	}

	public void paint(Graphics g) {
		System.out.println("In paint: n = " + n);
		n++;
	}

	int n;
}