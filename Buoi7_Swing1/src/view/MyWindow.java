package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MyWindow extends JFrame{
	public MyWindow() {
		this.setTitle("My Window 1.0");
		
		//this.setLayout(new FlowLayout());
		this.setLayout(new BorderLayout());
		
		//Kich co
		this.setSize(800, 600);
		//Add button
		JButton open = new JButton("OPEN");
		
		JButton close = new JButton("CLOSE");
		
		JTextField fullName = new JTextField();
		fullName.setColumns(30);
		
		this.add(open, BorderLayout.NORTH);
		
		this.add(close, BorderLayout.WEST);
		
		this.add(fullName, BorderLayout.EAST);
		//Hien thi
		this.setVisible(true);
	}
	
}
