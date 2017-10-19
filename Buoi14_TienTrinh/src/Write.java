import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Write extends Thread {
	private Socket sk;
	private String name;
	private String smsSend;

	public Write(Socket sk, String name) {
		this.sk = sk;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			
			while (true) {
				setNewMessage();
				sendMessage();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void sendMessage() throws IOException {
		PrintWriter pw = new PrintWriter(sk.getOutputStream());
		pw.println(name + ": " + smsSend);
		pw.flush();
	}
	
	private void setNewMessage(){
		Scanner input = new Scanner(System.in);
		smsSend = input.nextLine();
	}

}
