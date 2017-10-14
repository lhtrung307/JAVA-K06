package tientrinh;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Read extends Thread {
	Socket sk;

	public Read(Socket sk) {
		super();
		this.sk = sk;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream(), "UTF-8"));
			while (true) {
				String sms2 = br.readLine();
				System.out.println(sms2);
				if (sms2.startsWith("exit")) {
					sk.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
