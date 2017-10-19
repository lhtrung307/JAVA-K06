import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
	private String smsServer;
	private String smsClient;
	private Socket sk;

	public String getSmsServer() {
		return smsServer;
	}

	public void setSmsServer(String smsServer) {
		this.smsServer = smsServer;
	}

	public String getSmsClient() {
		return smsClient;
	}

	public void setSmsClient(String smsClient) {
		this.smsClient = smsClient;
	}

	public Socket getSk() {
		return sk;
	}

	public void setSk(Socket sk) {
		this.sk = sk;
	}

	public ClientChat(String smsServer, String smsClient, Socket sk) {
		this.smsServer = smsServer;
		this.smsClient = smsClient;
		this.sk = sk;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			ClientChat newClient = new ClientChat("", "", new Socket("192.168.1.106", 13579));
			while (true) {
				newClient.readMessage();
				if (newClient.isExit()) {
					newClient.sk.close();
				}
				System.out.println("Nhập");
				newClient.smsClient = input.nextLine();
				newClient.sendMessage();
			}
		} catch (IOException e) {
			System.out.println("Have a problem when closing socket!!!");
		}
	}

	private boolean isExit() {
		return smsServer.indexOf("exit") > -1;
	}

	private void readMessage() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream(), "UTF-8"));
		smsServer = br.readLine();
		System.out.println(smsServer);
	}

	private void sendMessage() throws IOException {
		PrintWriter pw = new PrintWriter(sk.getOutputStream());
		pw.println("Client: " + smsClient);
		pw.flush();
	}

}
