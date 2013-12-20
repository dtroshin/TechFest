import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Lab5 extends Applet {
    public void init() {
        Button Normal = new Button("Normal");
		Button Stop = new Button("Stop");
		Button Caution = new Button("Caution");
		Button rTurn = new Button("Right Turn");
		Button Off = new Button("Off");
		
		setLayout(new BorderLayout());
		
		Panel Controls = new Panel();
		Controls.setLayout(new GridLayout(5,1));
		Controls.add(Normal);
		Controls.add(Stop);
		Controls.add(Caution);
		Controls.add(rTurn);
		Controls.add(Off);
		add(Controls, BorderLayout.WEST);
		
		Scrollbar speedControl = new Scrollbar(Scrollbar.VERTICAL, 1000,0,0,3000);
		add(speedControl, BorderLayout.EAST);
		
        BlinkCanvas blinkCanvas = new BlinkCanvas(Normal, Stop, Caution, rTurn,Off, speedControl);
        add(blinkCanvas, BorderLayout.CENTER);
		

        new BlinkThread(blinkCanvas).start();
		
    }
}

class BlinkCanvas extends Canvas implements ActionListener, AdjustmentListener{
    BlinkCanvas(Button Normal, Button Stop, Button Caution, Button rTurn, Button Off, Scrollbar speedControl) {
        
		this.Normal = Normal;
		this.Stop = Stop;
		this.Caution = Caution;
		this.rTurn = rTurn;
		this.Off = Off;
		this.speedControl = speedControl;
		
		speedControl.addAdjustmentListener(this);
		
        Normal.addActionListener(this);
		Stop.addActionListener(this);
		Caution.addActionListener(this);
		rTurn.addActionListener(this);
		Off.addActionListener(this);
        setSize(250, 400);
		Center = (getWidth()/2);
    }

    public void paint(Graphics g) {
		//Draw Outline of Traffic Single
		g.drawLine(0,((int)getWidth() / 3), Center, 20);
		g.drawLine(Center, 20, getWidth(), (int)(getWidth()/3));
		
		//Draw empty lights
		g.setColor(Color.BLACK);
		g.fillOval(Center-40, 80, 75, 75);
		g.fillOval(Center-40, 170, 75, 75);
		g.fillOval(Center-40, 260, 75, 75);
		
		if(NSig == true)
			NormalSig(g);
		else if(SSig == true)
			StopSig(g);
		else if(CSig == true)
			CautionSig(g);
		else if(RSig == true)
			RightSig(g);
		else if(reset == true)
			Reset(g);
    }
	
	public void NormalSig(Graphics g){

		if(count==1){
			g.setColor(Color.BLACK);
			g.fillOval(Center-40, 80, 75, 75);
			
			g.setColor(theColor);
			g.fillOval(Center-40, 260, 75, 75);
		}
		else if (count==2){
			g.setColor(Color.BLACK);
			g.fillOval(Center-40, 260, 75, 75);
			
			g.setColor(theColor);
			g.fillOval(Center-40, 170, 75, 75);
		}
		else if (count==3){
			g.setColor(Color.BLACK);
			g.fillOval(Center-40, 170, 75, 75);
			
			g.setColor(theColor);
			g.fillOval(Center-40, 80, 75, 75);
		}
	}
	
	public void StopSig(Graphics g){
		g.setColor(theColor);
		g.fillOval(Center-40, 170, 75, 75);
	}
	
	public void CautionSig(Graphics g){
		g.setColor(theColor);
		g.fillOval(Center-40, 170, 75, 75);
	}
	
	public void RightSig(Graphics g){
		int	[] xPoints = { (Center-30), (Center+10), (Center+10), (Center+30), (Center+10), (Center+10), (Center-30)};
		int	[] yPoints = { 290, 290, 275, 300, 325, 310,310};
		g.setColor(theColor);
		Polygon p = new Polygon(xPoints, yPoints, nPoints);
		g.fillPolygon(p);
	}
	
	public void Reset(Graphics g){
		g.setColor(Color.BLACK);
		g.fillOval(Center-40, 80, 75, 75);
		g.fillOval(Center-40, 170, 75, 75);
		g.fillOval(Center-40, 260, 75, 75);
		reset = false;
	}
    public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == Normal){
			NSig = true;
			SSig = false;
			CSig = false;
			RSig = false;
			reset = false;
		}
		else if(ae.getSource() == Stop){
			NSig = false;
			SSig = true;
			CSig = false;
			RSig = false;
			reset = false;
		}
		else if(ae.getSource() == Caution){
			NSig = false;
			SSig = false;
			CSig = true;
			RSig = false;
			reset = false;
			theColor = Color.ORANGE;
		}
		else if(ae.getSource() == rTurn){
			NSig = false;
			SSig = false;
			CSig = false;
			RSig = true;
			reset = false;
			theColor = Color.GREEN;
        }
		else if(ae.getSource() == Off){
			NSig = false;
			SSig = false;
			CSig = false;
			RSig = false;
			reset = true;
		}
    }
	
	public void adjustmentValueChanged(AdjustmentEvent e) {}

	public void toggleColor(Graphics g){
		g.fillOval(Center-40, 80, 75, 75);
		g.fillOval(Center-40, 170, 75, 75);
		g.fillOval(Center-40, 260, 75, 75);
		repaint();
	}
    public boolean isBlinking() {return reset;}

    public void toggleColor() {
        if(NSig == true){
			if(count==0)
				theColor = Color.GREEN;
			else if(count==1){
				theColor = Color.ORANGE;}
			else if(count==2){
				theColor = Color.RED;
			}
			if(count<4)
				count++;
			if(count==4)
				count=0;
		}	
			
		else if(SSig == true)
			theColor = theColor == Color.RED ? Color.BLACK : Color.RED;
		else if(CSig == true)
			theColor = theColor == Color.ORANGE ? Color.BLACK : Color.ORANGE;
		else if(RSig == true)
			theColor = Color.GREEN;
		else if(reset == true)
			theColor = Color.BLACK;
    }

	int Center,
		nPoints =7,
		count=0;
		
    Color theColor = Color.BLACK;
	
    boolean 
		NSig = false,
		SSig = false,
		CSig = false,
		RSig = false,
		reset = true,
		SysOff = false;
	
    Button 
		Normal,
		Stop,
		Caution,
		rTurn,
		Off;
		
	Scrollbar speedControl;
}

class BlinkThread extends Thread {
    BlinkThread(BlinkCanvas blinkCanvas) {
        this.blinkCanvas = blinkCanvas;
    }

   	public void run() {
		while (true) {
			if (blinkCanvas.isBlinking()==false) {
                try {
                    Thread.sleep(blinkCanvas.speedControl.getValue());
                } catch (InterruptedException e) {}
                blinkCanvas.toggleColor();
				blinkCanvas.repaint();
			}
        }
	}

	BlinkCanvas blinkCanvas;

}
