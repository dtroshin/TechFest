import java.applet.*;
import java.awt.*;

public class Lab3_4 extends Applet {
	public void init() {
		Button larger = new Button("Larger");
		add(larger);

		Button smaller = new Button("Smaller");
		add(smaller);

		Button left= new Button("Left");
		add(left);

		Button right = new Button("Right");
		add(right);

		Button up = new Button("UP");
		add(up);

		Button down = new Button("Down");
		add(down);

		add(new CircleCanvas(larger, smaller, left, right, up, down));
		add(new PlainCanvas());
	}
}
