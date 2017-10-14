package view;

import javax.swing.JFrame;

public class ClientTest {
	public static void main(String[] args) {
		Client hi;
		
		hi = new Client("127.0.0.1");
		hi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hi.startRunning();
		
	}
}
