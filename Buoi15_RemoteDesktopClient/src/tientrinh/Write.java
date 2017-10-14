package tientrinh;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Write extends Thread {
	private Socket sk;
	private String name;

	public Write(Socket sk, String name) {
		this.sk = sk;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			Scanner input = new Scanner(System.in);
			PrintWriter pw = new PrintWriter(sk.getOutputStream());
			while (true) {
				String sms = input.nextLine();
				pw.println(sms);
				pw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
