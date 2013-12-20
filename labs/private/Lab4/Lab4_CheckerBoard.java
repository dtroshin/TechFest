import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Lab4_CheckerBoard extends Applet {
	public void init() {
		add(new Checkerboard(this));
	}	
}

class Checkerboard extends Canvas {
	public Checkerboard(Applet parentApplet) {
		setSize(500, 500);
	}
		
	public void paint(Graphics g) {
		int hBorderHeight = (int)(getHeight() * (BORDER_PCT / 2)); 
		int vBorderWidth = (int)(getWidth() * (BORDER_PCT / 2)); 
		int upperLeftBoardX = vBorderWidth;
		int upperLeftBoardY = hBorderHeight;
		int boxHeight = (getHeight() - 2 * hBorderHeight) / BOARD_SIZE;
		int boxWidth = (getWidth() - 2 * vBorderWidth) / BOARD_SIZE;
		setBackground(Color.GREEN);

		for (int rows= 0; rows < BOARD_SIZE; rows++)
			for (int cols= 0; cols < BOARD_SIZE; cols++) {
				g.setColor(rows % 2 == 0 ^ cols % 2  == 0 ? Color.BLACK : Color.WHITE);
				g.fillRect(upperLeftBoardX + cols * boxWidth,
						upperLeftBoardY + rows * boxHeight,
						boxWidth, boxHeight);
				if(rows <3){
					if(g.getColor() == Color.BLACK){
						g.setColor(Color.RED);
						g.fillOval(upperLeftBoardX + cols * boxWidth,
							upperLeftBoardY + rows * boxHeight,
							boxWidth, boxHeight);
					}
				}
				if(rows >4){
					if(g.getColor() == Color.WHITE){
						g.setColor(Color.CYAN);
						g.fillOval(upperLeftBoardX + cols * boxWidth,
							upperLeftBoardY + rows * boxHeight,
							boxWidth, boxHeight);
					}
				}
			}
	}

	private static double BORDER_PCT= .1;	
	private int hBorderHeight, vBorderWidth;	
	private int boxWidth, boxHeight;
	private static final int BOARD_SIZE = 8;
}
