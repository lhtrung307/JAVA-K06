import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerChat {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		try {
			
			ServerSocket ss = new ServerSocket(13579);
			Socket sk = ss.accept();
			Thread read = new Read(sk);
			Thread write = new Write(sk, "Trung");
			while (true) {
				

				
				read.start();
				write.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
