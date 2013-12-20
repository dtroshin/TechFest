import java.applet.*;
import java.awt.*;

public class Assignment1 extends Applet{
	public void init() {

		Scrollbar lengthAdjuster = new Scrollbar(Scrollbar.HORIZONTAL, 30, 0, 0, 250);
		Scrollbar thickAdjuster = new Scrollbar(Scrollbar.VERTICAL, 1,0,0,250);
		
		TextField lengthDisplay = new TextField();
		lengthDisplay.setEditable(false);
		
		TextField thicknessDisplay = new TextField();
		thicknessDisplay.setEditable(false);
		
		TextField rDisplay = new TextField();
		rDisplay.setEditable(false);
		
		TextField bDisplay = new TextField();
		bDisplay.setEditable(false);
		
		TextField gDisplay = new TextField();
		gDisplay.setEditable(false);
		
		Button lucky = new Button("Feeling Lucky?");
		
		CheckboxGroup BackOrFore = new CheckboxGroup();
		Checkbox bgChange = new Checkbox("Background Change", BackOrFore, false);
		Checkbox fgChange = new Checkbox("Foreground Change", BackOrFore, true);
		
		CheckboxGroup CircOrRect = new CheckboxGroup();
		Checkbox circle = new Checkbox("Circle",CircOrRect,false);
		Checkbox rect = new Checkbox("Rectangle",CircOrRect,true);
		
		CheckboxGroup FillorEmpty = new CheckboxGroup();
		Checkbox fill = new Checkbox("Fill", FillorEmpty, true);
		Checkbox empty = new Checkbox ("No-Fill", FillorEmpty, false);
		
		Label Red = new Label("R");
		Scrollbar RedAdjust = new Scrollbar(Scrollbar.VERTICAL, 0,0,0,226);
		Label Blue = new Label("B");
		Scrollbar BlueAdjust = new Scrollbar(Scrollbar.VERTICAL, 0,0,0,226);
		Label Green = new Label("G");
		Scrollbar GreenAdjust = new Scrollbar(Scrollbar.VERTICAL, 0,0,0,226);
		
		Button left= new Button("Left");
		Button right = new Button("Right");
		Button up = new Button("UP");
		Button down = new Button("Down");
		int x=5;

		PaintCanvas paintCanvas = new PaintCanvas(RedAdjust, BlueAdjust, GreenAdjust,
										lucky, bgChange, fgChange, left, right, up, down,
										lengthDisplay, thicknessDisplay, rDisplay, bDisplay, gDisplay,
										fill, empty, circle, rect);


		setLayout(new BorderLayout());
		
		add(paintCanvas, BorderLayout.CENTER);
		

		Panel direction = new Panel();
		direction.add(left);
		direction.add(right);
		direction.add(up);
		direction.add(down);
		add(direction, BorderLayout.NORTH);
		
		Panel rightPanel = new Panel();
		rightPanel.setLayout(new GridLayout(0, 1));
		rightPanel.add(thickAdjuster);
		rightPanel.add(thicknessDisplay);
		rightPanel.add(circle);
		rightPanel.add(rect);
		rightPanel.add(lucky);
		add(rightPanel, BorderLayout.EAST);

		Panel scrollPanel = new Panel();
		scrollPanel.add(lengthAdjuster);
		scrollPanel.add(lengthDisplay);
		add(scrollPanel, BorderLayout.SOUTH);
		
		
		Panel CheckboxColorPanel = new Panel();
		CheckboxColorPanel.setLayout(new GridLayout(4,1));
		CheckboxColorPanel.add(bgChange);
		CheckboxColorPanel.add(fgChange);
		CheckboxColorPanel.add(fill);
		CheckboxColorPanel.add(empty);
		
		Panel colorPanel = new Panel();
		colorPanel.setLayout(new GridLayout(3,3));
		colorPanel.add(Red);
		colorPanel.add(Blue);
		colorPanel.add(Green); 
		colorPanel.add(rDisplay);
		colorPanel.add(bDisplay);
		colorPanel.add(gDisplay);
		colorPanel.add(RedAdjust);
		colorPanel.add(BlueAdjust);
		colorPanel.add(GreenAdjust);
		
		
		Panel leftPanel = new Panel();
		leftPanel.setLayout(new GridLayout(2,1));
		leftPanel.add(CheckboxColorPanel);
		leftPanel.add(colorPanel);
		add(leftPanel, BorderLayout.WEST);
	}
}