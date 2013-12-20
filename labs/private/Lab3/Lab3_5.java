import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Lab3_5 extends Applet implements AdjustmentListener {
	public void init() {
		scrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 50, 0, 0, 100);
		add(scrollbar);
		scrollbar.addAdjustmentListener(this);
		
		textField = new TextField(3);
		textField.setText(scrollbar.getValue()+"");
		textField.setEditable(false);
		add(textField);
		
		scrollbar2 = new Scrollbar(Scrollbar.VERTICAL, 10, 0, 0, 100);
		add(scrollbar2);
		scrollbar2.addAdjustmentListener(this);
		
		textField2 = new TextField(3);
		textField2.setText(scrollbar2.getValue()+"");
		textField2.setEditable(false);
		add(textField2);
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		if(e.getSource() == scrollbar)
			textField.setText(scrollbar.getValue()+"");	
			
		if(e.getSource() == scrollbar2)
			textField2.setText(scrollbar2.getValue()+"");
	}

	Scrollbar scrollbar, scrollbar2;
	TextField textField, textField2;
}