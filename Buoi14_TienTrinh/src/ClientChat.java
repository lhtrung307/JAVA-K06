import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		try {
			Socket sk = new Socket("192.168.1.114", 13579);
			Thread read = new Read(sk);
			Thread write = new Write(sk, "Trung");
			read.start();
			write.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
