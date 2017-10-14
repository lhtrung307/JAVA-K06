package client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import tientrinh.Read;
import tientrinh.Write;

public class Client {
	private String ip;
	private int port;
	public Socket sk;
	public Socket sk2;

	public Client(String ip, int port) {
		this.ip = ip;
		this.port = port;
		
		try {
			sk = new Socket(this.ip, this.port);
			Thread read = new Read(sk);
			Thread write = new Write(sk, "Client");
			read.start();
			write.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void shutdown(int seconds){
		String shutdownCmd = "sd " + seconds;
		try {
			sendCommand(shutdownCmd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void restart(int seconds){
		String restartCmd = "sr " + seconds;
		try {
			sendCommand(restartCmd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cancel(){
		String cancelCmd = "cancel";
		try {
			sendCommand(cancelCmd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void capture(String vitriluu){
		String command = "capture";
		
		try {
			sendCommand(command);
			
			sk2 = new Socket(ip, 13577);
			
			//Nguồn
			BufferedInputStream bis = new BufferedInputStream(sk2.getInputStream());
			//Đích
			OutputStream os = new FileOutputStream(vitriluu);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			byte[] buffer = new byte[1024 * 1024];
			
			while (true) {
				int byteDocDuoc = bis.read(buffer);
				if(byteDocDuoc > 0){
					bos.write(buffer, 0, byteDocDuoc);
				} else {
					break;
				}
				
			}
			bis.close();
			bos.close();
			sk2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void sendCommand(String command) throws IOException{
		PrintWriter pw = new PrintWriter(sk.getOutputStream());
		pw.println(command);
		pw.flush();
	}
//	public String getIp() {
//		return ip;
//	}
//
//	public void setIp(String ip) {
//		this.ip = ip;
//	}
//
//	public int getPort() {
//		return port;
//	}
//
//	public void setPort(int port) {
//		this.port = port;
//	}

}
