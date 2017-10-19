import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Read extends Thread {
	Socket sk;
	String smsRecive;

	public Read(Socket sk) {
		this.sk = sk;
		smsRecive = "";
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream(), "UTF-8"));
			while (true) {
				readMessage(br);
				if (isExit()) {
					sk.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readMessage(BufferedReader br) throws IOException {
		smsRecive = br.readLine();
		System.out.println(smsRecive);
	}

	private boolean isExit() {
		return smsRecive.indexOf("exit") > -1;
	}
}
