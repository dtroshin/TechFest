import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class PaintCanvas extends Canvas implements ActionListener, AdjustmentListener {
	PaintCanvas(Scrollbar lengthAdjuster, Scrollbar thickAdjuster, Button lucky,
					TextField lengthDisplay, TextField thicknessDisplay, Button bgChange, Button fgChange,
					Button left, Button right, Button up, Button down) {

					
		this.lengthAdjuster = lengthAdjuster;
		this.thickAdjuster = thickAdjuster;
		this.lucky = lucky;
		this.lengthDisplay = lengthDisplay;
		this.thicknessDisplay = thicknessDisplay;
		this.bgChange = bgChange;
		this.fgChange = fgChange;

		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
		
		lengthAdjuster.addAdjustmentListener(this);	
		thickAdjuster.addAdjustmentListener(this);	
		lucky.addActionListener(this);		
		bgChange.addActionListener(this);
		fgChange.addActionListener(this);
		
		left.addActionListener(this);
		right.addActionListener(this);
		up.addActionListener(this);
		down.addActionListener(this);

		setSize(200, 200);

		centerX = getWidth() / 2;
		centerY = getHeight() / 2;
		length = lengthAdjuster.getValue();

		lengthDisplay.setText(length+"");
		thicknessDisplay.setText(thickness+"");

		setBackground(new Color(15, 150, 200));
	}

	private void makeThick() {
		thickness = thickAdjuster.getValue();
		thicknessDisplay.setText(thickness+"");
		repaint();
	}
	
	private void changeBG() {
		Random random = new Random();
		setBackground(new Color((random.nextInt(225)+1), (random.nextInt(225)+1), (random.nextInt(225)+1) ));
		repaint();
	}
	
	private void changeFG() {
		Random random = new Random();
		setForeground(new Color((random.nextInt(225)+1), (random.nextInt(225)+1), (random.nextInt(225)+1) ));
		repaint();
	}

	private void makeRandomThickness() {
		Random random = new Random();
		thickness = random.nextInt(20)+1;
		thicknessDisplay.setText(thickness+"");
		thickAdjuster.setValue(thickness);
		repaint();
	}

	public void paint(Graphics g) {
		for (int i = 0; i < thickness; i++)			// Draw 'thickness' number of adjacent lines
			g.drawLine(centerX-(length/2), centerY+i, centerX+(length/2), centerY+i);			
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bgChange)
			changeBG();
		else if (e.getSource() == fgChange)
			changeFG();
		else if (e.getSource() == left)
			centerX--;
		else if (e.getSource() == right)
			centerX++;
		else if (e.getSource() == up)
			centerY--;
		else if (e.getSource() == down)
			centerY++;
		else if(e.getSource() == lucky)
			makeRandomThickness();
		repaint();
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		if (e.getSource() == lengthAdjuster){
			lengthDisplay.setText(length+"");
			length = lengthAdjuster.getValue();				// Only one scrollbar, no need for getSource() invocation
			lengthDisplay.setText(length+"");
		}
		else if (e.getSource() == thickAdjuster){
			thicknessDisplay.setText(thickness+"");
			thickness = thickAdjuster.getValue();
			if(thickness <= 0)
				thicknessDisplay.setText("0");
			else
				thicknessDisplay.setText(thickness+"");
		}
		repaint();
	}

	Scrollbar 
		lengthAdjuster,
		thickAdjuster;

	TextField
		lengthDisplay,
		thicknessDisplay; 

	int 
		centerX,
		centerY,
		length,
		thickness = 1;

	Button 
		bgChange,
		fgChange,
		left, right, up, down,
		thicker,
		thinner,
		lucky;


}