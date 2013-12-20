import java.awt.*;

public class PlainCanvas extends Canvas{
	PlainCanvas() {
			setSize(100, 100);
			setBackground(Color.red);

	}

	public void paint(Graphics g) {
			g.setColor(Color.blue);
			g.drawString("Canvas",10,10);
	}
}