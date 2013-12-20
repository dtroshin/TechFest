import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Lab4_Chineseboard extends Applet {
	public void init() {
		add(new ChineseCheckerboard(this));
	}
}

class ChineseCheckerboard extends Canvas {
    public ChineseCheckerboard(Applet parentApplet) {
        setSize(600, 600);
    }

    /*******************
    We'll have an array, holesInRow, that contains the number of holes per row of the board--
    the first row contains 1 hole, the second 2, the third, 3 (see below).

    We define a utility function drawRow that accepts as its paramter which row to draw
    (as well as the Graphics object sent to paint so we can call our drawing methods).
    *****************/

    public void paint(Graphics g) {
        for (int i = 0; i < holesInRow.length; i++)
            drawRow(g, i);
    }

    /*******
    drawRow figures out the (horizontal) center of the display, the width of the current row (from the number
    of holes in that row, their size and the spacing gap). It then calculates the starting horizintal position
    by subtracting half of the row width from the center position, so that half of the row will be displayed on
    one side, and the other half on the other. The vertical position remains fixed for the entire row.
    *******/

    void drawRow(Graphics g, int row) {
        int centerX = getWidth() / 2;           // figure out center of display
        int startY = 0;
        int numHoles = holesInRow[row];
        int rowWidth = numHoles * holeDiam + (numHoles-1) * holeGap;    //row width is number of holes + appropriate number of spacings
        int startX = centerX - rowWidth / 2;            // Starting horizontal position is centerX less half the row width
        int y = startY + row * (holeDiam + holeGap);    // Vertically position based upon which row you're displaying
        g.setColor(Color.BLACK);
        for (int i = 0; i < numHoles; i++) {            // Draw each hole
			if(i==0 || (i+1)==numHoles)
				g.setColor(Color.RED);
			else
				g.setColor(Color.BLACK);
			
            g.fillOval(startX + i * (holeDiam + holeGap), y, holeDiam, holeDiam);
            g.drawOval(startX + i * (holeDiam + holeGap), y, holeDiam, holeDiam);
        }
    }

    final int holeDiam = 15;
    final int holeGap = (int)(holeDiam * 0.25);

    // Here's the array containing the number of holes per row

    int [] holesInRow = {1, 2, 3, 4, 13, 12, 11, 10, 9, 10, 11, 12, 13, 4, 3, 2, 1};
}
