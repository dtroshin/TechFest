import java.awt.*;
import java.awt.event.*;

public class CircleCanvas extends Canvas implements ActionListener {
	CircleCanvas(Button larger, Button smaller, Button left, Button right,Button up,Button down) {

		this.larger = larger;//assigns instance variable to value that constructor gets
		larger.addActionListener(this);

		this.smaller = smaller;
		smaller.addActionListener(this);

		this.left = left;
		left.addActionListener(this);

		this.right = right;
		right.addActionListener(this);

		this.up = up;
		up.addActionListener(this);

		this.down = down;
		down.addActionListener(this);

		setSize(100, 100);

		setBackground(Color.yellow);
	}


	public void paint(Graphics g) {
		g.setColor(Color.blue);
		g.drawOval(upperLeftX, upperLeftY, diameter, diameter);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == larger)
			diameter++;

		else if (e.getSource() == smaller)
			diameter--;

		else if (e.getSource() == left)
			upperLeftX--;
		else if (e.getSource() == right)
			upperLeftX++;

		else if (e.getSource() == up)
			upperLeftY--;

		else if (e.getSource() == down)
			upperLeftY++;

			repaint();

	}

	Button larger, smaller, left, right, up, down;//instance variables

	int
		upperLeftX = 10,
		upperLeftY = 20,
		diameter = 10;
}
