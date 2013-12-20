import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Lab2_5 extends Applet implements ActionListener {
	public void init() {
		button1 = new Button("Draw A Line");
		button1.setForeground(Color.blue);
		add(button1);
		button1.addActionListener(this);

		button2 = new Button("Draw A Circle");
		button2.setForeground(Color.red);
		add(button2);
		button2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1){
			System.out.println("Button 1 was pressed");
			drawLine=true;
			drawCircle=false;
			repaint();
		}
		else{
			System.out.println("Button 2 was pressed");
			drawCircle=true;
			drawLine=false;
			repaint();
		}
	}

	public void paint(Graphics g) {
		if(drawLine==true){
			g.setColor(Color.green);
			g.drawLine(50, 50, 100, 100);
		}
		else if(drawCircle==true){
			g.setColor(Color.green);
			g.fillOval(100, 100, 15, 30);
		}

	}
	Button button1, button2;
	boolean drawLine=false, drawCircle=false;
}