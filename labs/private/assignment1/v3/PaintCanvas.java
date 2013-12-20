import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.lang.Math;


class PaintCanvas extends Canvas implements AdjustmentListener, ItemListener, MouseListener{
	PaintCanvas(Scrollbar RedAdjuster, Scrollbar BlueAdjuster, Scrollbar GreenAdjuster,
				TextField rDisplay, TextField bDisplay, TextField gDisplay,
				Checkbox bgChange, Checkbox fgChange, Checkbox fill, Checkbox nofill, Checkbox circle, Checkbox rect){

		addMouseListener(this);
		
		this.RedAdjuster = RedAdjuster;
		this.GreenAdjuster = GreenAdjuster;
		this.BlueAdjuster = BlueAdjuster;
		
		this.fill = fill;
		this.nofill = nofill;
		this.circle = circle;
		this.rect = rect;
		
		this.bgChange = bgChange;
		this.fgChange = fgChange;
		
		this.rDisplay = rDisplay;
		this.bDisplay = bDisplay;
		this.gDisplay = gDisplay;
		
		RedAdjuster.addAdjustmentListener(this);	
		BlueAdjuster.addAdjustmentListener(this);	
		GreenAdjuster.addAdjustmentListener(this);	
		
		fill.addItemListener(this);
		nofill.addItemListener(this);
		
		circle.addItemListener(this);
		rect.addItemListener(this);
		
		bgChange.addItemListener(this);
		fgChange.addItemListener(this);

		setSize(200, 200);

		centerX = getWidth() / 2;
		centerY = getHeight() / 2;
		rHue = RedAdjuster.getValue();
		bHue = BlueAdjuster.getValue();
		gHue = GreenAdjuster.getValue();

		rDisplay.setText(rHue+"");
		bDisplay.setText(bHue+"");
		gDisplay.setText(gHue+"");
		

		setBackground(new Color(15, 150, 200));
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

	public void adjustmentValueChanged(AdjustmentEvent e) {
		if (e.getSource() == RedAdjuster){
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
		RedAdjuster,
		BlueAdjuster,
		GreenAdjuster;

	TextField
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