import java.io.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Lab3_3 extends Applet implements ActionListener{
	public void init() {
		B0 = new Button("0");	B0.addActionListener(this);
		B1 = new Button("1");	B1.addActionListener(this);
		B2 = new Button("2");	B2.addActionListener(this);
		B3 = new Button("3");	B3.addActionListener(this);
		B4 = new Button("4");	B4.addActionListener(this);
		B5 = new Button("5");	B5.addActionListener(this);
		B6 = new Button("6");	B6.addActionListener(this);
		B7 = new Button("7");	B7.addActionListener(this);
		B8 = new Button("8");	B8.addActionListener(this);
		B9 = new Button("9");	B9.addActionListener(this);
		
		BNLock = new Button("NumLock");	BNLock.addActionListener(this);
		BDiv = new Button("/");			BDiv.addActionListener(this);
		BMult = new Button("*");		BMult.addActionListener(this);
		BSub = new Button("-");			BSub.addActionListener(this);
		BAdd = new Button("+");			BAdd.addActionListener(this);
		BEnter = new Button("Enter");	BEnter.addActionListener(this);
		BPoint = new Button(".");		BPoint.addActionListener(this);
		
		setLayout(new BorderLayout());

		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(1,0));
		p1.add(BNLock);
		p1.add(BDiv);
		p1.add(BMult);
		p1.add(BSub);
		add(p1, BorderLayout.NORTH);

		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(2,1));
		p2.add(BAdd);
		p2.add(BEnter);
		add(p2, BorderLayout.EAST);

		Panel p3 = new Panel();
		p3.setLayout(new GridLayout(3, 3));		// 2 rows, variable columns
		p3.add(B1);	p3.add(B2);
		p3.add(B3);	p3.add(B4);	p3.add(B5);
		p3.add(B6);	p3.add(B7);	p3.add(B8);
		p3.add(B9);
		add(p3, BorderLayout.CENTER);
		
		Panel p4 = new Panel();
		p4.setLayout(new GridLayout(1,0));
		p4.add(B0);	p4.add(BPoint);
		add(p4, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == B0)
			System.out.println("0 was pressed");
		if(e.getSource() == B1)
			System.out.println("1 was pressed");
		if(e.getSource() == B2)
			System.out.println("2 was pressed");
		if(e.getSource() == B3)
			System.out.println("3 was pressed");
		if(e.getSource() == B4)
			System.out.println("4 was pressed");
		if(e.getSource() == B5)
			System.out.println("5 was pressed");
		if(e.getSource() == B6)
			System.out.println("6 was pressed");
		if(e.getSource() == B7)
			System.out.println("7 was pressed");
		if(e.getSource() == B8)
			System.out.println("8 was pressed");
		if(e.getSource() == B9)
			System.out.println("9 was pressed");
			
		if(e.getSource() == BNLock)
			System.out.println("NumLock was pressed");
		if(e.getSource() == BDiv)
			System.out.println("/ was pressed");
		if(e.getSource() == BMult)
			System.out.println("* was pressed");
		if(e.getSource() == BSub)
			System.out.println("- was pressed");
		if(e.getSource() == BAdd)
			System.out.println("+ was pressed");
		if(e.getSource() == BEnter)
			System.out.println("Enter was pressed");
		if(e.getSource() == BPoint)
			System.out.println(". was pressed");		
	}
		
	
	Button BNLock, BDiv, BMult, BSub, BAdd, BEnter, BPoint;
	Button B0, B1, B2, B3, B4, B5, B6, B7, B8, B9;
}
