package tientrinh;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import server.Control;

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
				}else if(sms2.startsWith("sd")){
					String[] command = sms2.split(" ");
					int time = Integer.parseInt(command[1]);
					Control.shutdown(time);
				}else if(sms2.startsWith("sr")){
					String[] command = sms2.split(" ");
					int time = Integer.parseInt(command[1]);
					Control.restart(time);
				}else if(sms2.startsWith("cancel")){
					Control.cancelShutdown();
				}else if(sms2.startsWith("capture")){
					Control.capture();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
