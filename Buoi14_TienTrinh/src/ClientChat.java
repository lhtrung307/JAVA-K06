import java.net.Socket;

public class ClientChat {
	public static void main(String[] args) {
		
		try {
			Socket sk = new Socket("localhost", 13579);
			Thread read = new Read(sk);
			Thread write = new Write(sk, "Trung");
			read.start();
			write.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
