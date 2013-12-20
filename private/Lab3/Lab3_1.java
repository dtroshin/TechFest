import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Lab3_1 extends Applet implements ActionListener {
	public void init() {
		Label label1 = new Label("First text Area: ");

		textArea1 = new TextArea("Hello", 5, 40);
		textArea1.setForeground(Color.red);

		swapEm = new Button("Swap");
		swapEm.addActionListener(this);

		clearEm = new Button("Clear");
		clearEm.addActionListener(this);

		Label label2 = new Label("Second text field: ");

		textField2 = new TextField("Goodbye");
		textField2.setEditable(false);

		add(label1);
		add(textArea1);
		add(swapEm);
		add(label2);
		add(textField2);
		add(clearEm);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == swapEm) {
			String temp = textArea1.getText();
			String temp2 = textField2.getText();

			if(temp.compareTo(temp2) > 0){
				temp = textArea1.getText();
				textArea1.setText(textField2.getText());
				textField2.setText(temp);
			}
		}
		if (e.getSource() == clearEm){
			textArea1.setText(null);
			textField2.setText(null);
		}
	}

	TextArea textArea1;
	TextField textField2;
	Button swapEm,clearEm;
}