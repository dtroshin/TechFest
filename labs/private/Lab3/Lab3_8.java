import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Lab3_8 extends Applet implements MouseListener, MouseMotionListener {
    public void init() {
		addMouseListener(this);
        addMouseMotionListener(this);
		}

	public void mouseClicked(MouseEvent e) {
        String clickDesc;
        if (e.getClickCount() == 2)
            clickDesc = "double";
        else
            clickDesc = "single";
        System.out.println("Mouse was " + clickDesc + "-clicked at location (" +
            e.getX() + ", " + e.getY() + ")");
    }
    public void mouseDragged(MouseEvent e) {
        System.out.println("mouse is being dragged at location (" + e.getX() + ", " + e.getY() + ")");
    }
    public void mouseMoved(MouseEvent e) {
        System.out.println("mouse is being moved at location (" + e.getX() + ", " + e.getY() + ")");
	}
	public void mouseEntered(MouseEvent e) {
	System.out.println("mouse entered at location (" + e.getX() + ", " + e.getY() + ")");
	}
    public void mouseExited(MouseEvent e) {
	System.out.println("mouse exited at location (" + e.getX() + ", " + e.getY() + ")");
	}
    public void mousePressed(MouseEvent e) {
	System.out.println("mouse was pressed at location (" + e.getX() + ", " + e.getY() + ")");
	}
    public void mouseReleased(MouseEvent e) {
	System.out.println("mouse was released at location (" + e.getX() + ", " + e.getY() + ")");
	}
}
