import java.applet.*;
import java.awt.*;

public class Assignment1 extends Applet{
	public void init() {
		
		TextField rDisplay = new TextField();
		rDisplay.setEditable(false);
		
		TextField bDisplay = new TextField();
		bDisplay.setEditable(false);
		
		TextField gDisplay = new TextField();
		gDisplay.setEditable(false);
		
		
		CheckboxGroup BackOrFore = new CheckboxGroup();
		Checkbox bgChange = new Checkbox("Background Change", BackOrFore, false);
		Checkbox fgChange = new Checkbox("Foreground Change", BackOrFore, true);
		
		CheckboxGroup CircOrRect = new CheckboxGroup();
		Checkbox circle = new Checkbox("Circle",CircOrRect,false);
		Checkbox rect = new Checkbox("Rectangle",CircOrRect,true);
		
		CheckboxGroup Fillornofill = new CheckboxGroup();
		Checkbox fill = new Checkbox("Fill", Fillornofill, true);
		Checkbox nofill = new Checkbox ("No-Fill", Fillornofill, false);
		
		Label Red = new Label("R");
		Scrollbar RedAdjust = new Scrollbar(Scrollbar.VERTICAL, 0,0,0,226);
		Label Blue = new Label("B");
		Scrollbar BlueAdjust = new Scrollbar(Scrollbar.VERTICAL, 0,0,0,226);
		Label Green = new Label("G");
		Scrollbar GreenAdjust = new Scrollbar(Scrollbar.VERTICAL, 0,0,0,226);
		
		Label ShapeControl= new Label("Shape Control");

		PaintCanvas paintCanvas = new PaintCanvas(RedAdjust, BlueAdjust, GreenAdjust,
												  rDisplay, bDisplay, gDisplay,
												  bgChange, fgChange, fill, nofill, circle, rect);


		setLayout(new BorderLayout());
		add(paintCanvas, BorderLayout.CENTER);
		
		Panel rightPanel = new Panel();
		rightPanel.setLayout(new GridLayout(0, 1));
		rightPanel.add(ShapeControl);
		rightPanel.add(circle);
		rightPanel.add(rect);
		add(rightPanel, BorderLayout.EAST);

		Panel scrollPanel = new Panel();
		add(scrollPanel, BorderLayout.SOUTH);
		
		
		Panel ShapePropPanel = new Panel();
		ShapePropPanel.setLayout(new GridLayout(4,1));
		ShapePropPanel.add(bgChange);
		ShapePropPanel.add(fgChange);
		ShapePropPanel.add(fill);
		ShapePropPanel.add(nofill);
		
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
		leftPanel.setLayout(new GridLayout(3,1));
		leftPanel.add(ShapePropPanel);
		leftPanel.add(colorPanel);
		add(leftPanel, BorderLayout.WEST);
	}
}