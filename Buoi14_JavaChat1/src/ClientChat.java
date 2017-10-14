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
			Socket sk = new Socket("192.168.1.106", 13579);
			PrintWriter pw = new PrintWriter(sk.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream(), "UTF-8"));
			
			while(true){
				
				String sms2 = br.readLine();
				System.out.println(sms2);
				
				if(sms2.indexOf("exit") > -1){
					sk.close();
				}
				
				System.out.println("Nhập");
				String sms = input.nextLine();
				pw.println("Client: " + sms);
				pw.flush();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
