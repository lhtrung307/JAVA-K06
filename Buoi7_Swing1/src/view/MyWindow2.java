package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyWindow2 extends JFrame implements ActionListener{
	public MyWindow2() {
		this.setTitle("My Window 1.0");
		
		//this.setLayout(new FlowLayout());
		this.setLayout(new GridLayout(10, 5));
		
		//Kich co
		this.setSize(800, 600);
		//Add button
//		for(int i = 0; i < 50; i++){
			JButton button = new JButton("" + 1);
			button.addActionListener(this);
			this.add(button);
//		}
		//Hien thi
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("Hello");
		JButton b = (JButton)e.getSource();
		System.out.println(b.getText());
//		JButton button = new JButton("" + 3);
//		button.addActionListener(this);
//		this.add(button);
//		this.setVisible(true);
	}
	
}
