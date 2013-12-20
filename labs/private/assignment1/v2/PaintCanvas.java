import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.lang.Math;


class PaintCanvas extends Canvas implements ActionListener, AdjustmentListener, ItemListener, MouseListener{
	PaintCanvas(Scrollbar lengthAdjuster, Scrollbar thickAdjuster, Scrollbar RedAdjuster, Scrollbar BlueAdjuster, Scrollbar GreenAdjuster,
				Button lucky, Checkbox bgChange, Checkbox fgChange, Button left, Button right, Button up, Button down,
				TextField lengthDisplay, TextField thicknessDisplay, TextField rDisplay, TextField bDisplay, TextField gDisplay,
				Checkbox fill, Checkbox nofill, Checkbox circle, Checkbox rect) {

		addMouseListener(this);
		
		this.lengthAdjuster = lengthAdjuster;
		this.thickAdjuster = thickAdjuster;
		this.RedAdjuster = RedAdjuster;
		this.GreenAdjuster = GreenAdjuster;
		this.BlueAdjuster = BlueAdjuster;
		
		this.fill = fill;
		this.nofill = nofill;
		this.circle = circle;
		this.rect = rect;
		this.lucky = lucky;
		
		this.bgChange = bgChange;
		this.fgChange = fgChange;
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
		
		this.lengthDisplay = lengthDisplay;
		this.thicknessDisplay = thicknessDisplay;
		this.rDisplay = rDisplay;
		this.bDisplay = bDisplay;
		this.gDisplay = gDisplay;
		
		lengthAdjuster.addAdjustmentListener(this);	
		thickAdjuster.addAdjustmentListener(this);
		RedAdjuster.addAdjustmentListener(this);	
		BlueAdjuster.addAdjustmentListener(this);	
		GreenAdjuster.addAdjustmentListener(this);	
		
		fill.addItemListener(this);
		nofill.addItemListener(this);
		
		circle.addItemListener(this);
		rect.addItemListener(this);
		
		bgChange.addItemListener(this);
		fgChange.addItemListener(this);
		
		lucky.addActionListener(this);	
		left.addActionListener(this);
		right.addActionListener(this);
		up.addActionListener(this);
		down.addActionListener(this);

		setSize(200, 200);

		centerX = getWidth() / 2;
		centerY = getHeight() / 2;
		length = lengthAdjuster.getValue();
		rHue = RedAdjuster.getValue();
		bHue = BlueAdjuster.getValue();
		gHue = GreenAdjuster.getValue();

		lengthDisplay.setText(length+"");
		thicknessDisplay.setText(thickness+"");
		rDisplay.setText(rHue+"");
		bDisplay.setText(bHue+"");
		gDisplay.setText(gHue+"");
		

		setBackground(new Color(15, 150, 200));
	}

	private void makeThick() {
		thickness = thickAdjuster.getValue();
		thicknessDisplay.setText(thickness+"");
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
		thickness = Math.abs((x1-x2));
		length = Math.abs((y1-y2));	
		if(fillcheck && rectCheck){
				g.fillRect(x1,y1,thickness,length);	}
		else if(!fillcheck && rectCheck ){
				g.drawRect(x1,y1,thickness,length);}
				
		 if(fillcheck && !rectCheck ){
				g.fillOval(x1,y1,thickness,length);}
		else if(!fillcheck && !rectCheck ){
				g.drawOval(x1,y1,thickness,length);}
	}
	
	public void itemStateChanged(ItemEvent e){
		if(e.getSource() == nofill ){
			fillcheck = false;
		}
		else if(e.getSource() == fill){
			fillcheck = true;
		}
		ShapeChange();
		repaint();
	}
	
	public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
	}
    public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == left)
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
			length = lengthAdjuster.getValue();
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
		else if (e.getSource() == RedAdjuster){
			rHue = RedAdjuster.getValue();
			rDisplay.setText(rHue+"");
		}
		else if (e.getSource() == BlueAdjuster){
			bHue = BlueAdjuster.getValue();
			bDisplay.setText(bHue+"");
		}
		else if (e.getSource() == GreenAdjuster){
			gHue = GreenAdjuster.getValue();
			gDisplay.setText(gHue+"");
		}
		colorChange();
		repaint();
	}

	public void ShapeChange(){
		if(rect.getState() && !circle.getState())
			rectCheck=true;
		else if (!rect.getState() && circle.getState())
			rectCheck=false;
	}
	
	public void colorChange(){
		color = new Color (rHue, gHue, bHue);
		if(bgChange.getState() && !fgChange.getState() )
			setBackground(color);
		else if(fgChange.getState() && !bgChange.getState())
			setForeground(color);
	}
	boolean
		fillcheck=true,
		rectCheck=true;
		
	Scrollbar 
		lengthAdjuster,
		thickAdjuster,
		RedAdjuster,
		BlueAdjuster,
		GreenAdjuster;

	TextField
		lengthDisplay,
		thicknessDisplay,
		rDisplay,
		bDisplay,
		gDisplay; 

	int 
	x1,x2,y1,y2,
	rand = 1,
		centerX,
		centerY,
		length,
		rHue,
		bHue,
		gHue,
		thickness = 4;

	Button 
		left, right, up, down,
		thicker,
		thinner,
		lucky;

	Checkbox 
		fgChange,
		bgChange,
		fill,
		nofill,
		rect,
		circle;
		
	Color
		color;
}