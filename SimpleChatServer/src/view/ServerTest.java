package view;

import javax.swing.JFrame;;

public class ServerTest {

	public static void main(String[] args) {
		Server hello = new Server();
		hello.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hello.startRunning();
	}

}
