import java.applet.*;
import java.awt.*;

public class Lab3_6 extends Applet {
	public void init() {

		Scrollbar lengthAdjuster = new Scrollbar(Scrollbar.HORIZONTAL, 30, 0, 0, 100);
		Scrollbar thickAdjuster = new Scrollbar(Scrollbar.VERTICAL, 1,0,0,100);
		
		TextField lengthDisplay = new TextField(3);
		lengthDisplay.setEditable(false);
		
		TextField thicknessDisplay = new TextField(3);
		thicknessDisplay.setEditable(false);
		
		Button lucky = new Button("Feeling Lucky?");
		Button bgChange = new Button("Background Change");
		Button fgChange = new Button("Foreground Change");
		
		Button left= new Button("Left");
		Button right = new Button("Right");
		Button up = new Button("UP");
		Button down = new Button("Down");
		PaintCanvas paintCanvas = new PaintCanvas(lengthAdjuster, thickAdjuster, lucky,
									lengthDisplay, thicknessDisplay, bgChange, fgChange, left, right, up, down);


		setLayout(new BorderLayout());

		add(paintCanvas, BorderLayout.CENTER);

		Panel direction = new Panel();
		direction.add(left);
		direction.add(right);
		direction.add(up);
		direction.add(down);
		add(direction, BorderLayout.NORTH);
		
		Panel buttonPanel = new Panel();
		buttonPanel.setLayout(new GridLayout(0, 1));
		buttonPanel.add(thickAdjuster);
		buttonPanel.add(thicknessDisplay);
		buttonPanel.add(lucky);
		add(buttonPanel, BorderLayout.EAST);

		Panel scrollPanel = new Panel();
		scrollPanel.add(lengthAdjuster);
		scrollPanel.add(lengthDisplay);
		add(scrollPanel, BorderLayout.SOUTH);
		
		Panel colorPanel = new Panel();
		colorPanel.setLayout(new GridLayout(0,1));
		colorPanel.add(bgChange);
		colorPanel.add(fgChange);
		add(colorPanel, BorderLayout.WEST);
	}
}