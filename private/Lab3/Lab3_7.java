import java.applet.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Lab3_7 extends Applet implements MouseListener {
    public void init() {
		random = new Random();
		color = new Color((random.nextInt(225)+1), (random.nextInt(225)+1), (random.nextInt(225)+1) );
        addMouseListener(this);
	}
	
	public void paint(Graphics g){
		g.fillRect(10,10,100,100);
	}

	public boolean check(int getXCor, int getYCor){
		x = getXCor;
		y = getYCor;
		boolean c1, c2;
		if((x>10)&&(x<110))
			c1 = true;
		else
			c1 = false;
			
		if((y>10)&&(y<110))
			c2 = true;
		else 
			c2 = false;
		
		if( (c1==true) && (c2=true))
			return false;
		else
			return true;
	}
    public void mouseClicked(MouseEvent e) {
        String clickDesc;
		boolean testWithin = check(e.getX(), e.getY());
		if(testWithin == true){
			color = new Color((random.nextInt(225)+1), (random.nextInt(225)+1), (random.nextInt(225)+1) );
			setBackground(color);
			repaint();
		}
		else if (testWithin == false){
			color = new Color((random.nextInt(225)+1), (random.nextInt(225)+1), (random.nextInt(225)+1) );
			setForeground(color);
			repaint();
		}

        if (e.getClickCount() == 2)
            clickDesc = "double";
        else
            clickDesc = "single";

        System.out.println("Mouse was " + clickDesc + "-clicked at location (" +
            e.getX() + ", " + e.getY() + ")");
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
	int x, y;
	Color color;
	Random random;
}
