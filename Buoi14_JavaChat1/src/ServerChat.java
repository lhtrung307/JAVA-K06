import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {
	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(13579);
			Socket sk = ss.accept();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
