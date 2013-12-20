import java.io.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Lab3_2 extends Applet implements ActionListener {
	public void init() {
		String parmString =  getParameter("number");
		n = Integer.parseInt(parmString);


		if(n==1){
			setLayout(new BorderLayout());

			topButton = new Button("Top");
			add(topButton, BorderLayout.NORTH);
			topButton.addActionListener(this);

			bottomButton = new Button("Bottom");
			add(bottomButton, BorderLayout.SOUTH);
			bottomButton.addActionListener(this);

			rightButton = new Button("Right");
			add(rightButton, BorderLayout.EAST);
			rightButton.addActionListener(this);

			leftButton = new Button("Left");
			add(leftButton, BorderLayout.WEST);
			leftButton.addActionListener(this);

			middleButton = new Button("Middle");
			add(middleButton, BorderLayout.CENTER);
			middleButton.addActionListener(this);
		}
		
		if(n==2){
			setLayout(new GridLayout(3,2));
			
			Button1 = new Button("One");
			add(Button1);
			Button1.addActionListener(this);
			
			Button2 = new Button("Two");
			add(Button2);
			Button2.addActionListener(this);
			
			Button3 = new Button("Three");
			add(Button3);
			Button3.addActionListener(this);
			
			Button4 = new Button("Four");
			add(Button4);
			Button4.addActionListener(this);
			
			Button5 = new Button("Five");
			add(Button5);
			Button5.addActionListener(this);
		}
		
		if(n==3){
			setLayout(new FlowLayout());
			
			FlowButton1 = new Button("FlowOne");
			add(FlowButton1);
			FlowButton1.addActionListener(this);
			
			FlowButton2 = new Button("FlowTwo");
			add(FlowButton2);
			FlowButton2.addActionListener(this);
			
			FlowButton3 = new Button("FlowThree");
			add(FlowButton3);
			FlowButton3.addActionListener(this);
			
			FlowButton4 = new Button("FlowFour");
			add(FlowButton4);
			FlowButton4.addActionListener(this);
			
			FlowButton5 = new Button("FlowFive");
			add(FlowButton5);
			FlowButton5.addActionListener(this);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == topButton)
			System.out.println("topButton was pressed");
		if(e.getSource() == bottomButton)
			System.out.println("bottomButton was pressed");
		if(e.getSource() == rightButton)
			System.out.println("rightButton was pressed");
		if(e.getSource() == leftButton)
			System.out.println("leftButton was pressed");
		if(e.getSource() == middleButton)
			System.out.println("middleButton was pressed");
			
		if(e.getSource() == Button1)
			System.out.println("Button1 was pressed");
		if(e.getSource() == Button2)
			System.out.println("Button2 was pressed");
		if(e.getSource() == Button3)
			System.out.println("Button3 was pressed");
		if(e.getSource() == Button4)
			System.out.println("Button4 was pressed");
		if(e.getSource() == Button5)
			System.out.println("Button5 was pressed");
		
		if(e.getSource() == FlowButton1)
			System.out.println("FlowButton1 was pressed");
		if(e.getSource() == FlowButton2)
			System.out.println("FlowButton2 was pressed");
		if(e.getSource() == FlowButton3)
			System.out.println("FlowButton3 was pressed");
		if(e.getSource() == FlowButton4)
			System.out.println("FlowButton4 was pressed");
		if(e.getSource() == FlowButton5)
			System.out.println("FlowButton5 was pressed");
	}
	
	int n;
	Button topButton, bottomButton, rightButton, leftButton, middleButton;
	Button Button1, Button2, Button3, Button4, Button5;
	Button FlowButton1, FlowButton2, FlowButton3, FlowButton4, FlowButton5;
}