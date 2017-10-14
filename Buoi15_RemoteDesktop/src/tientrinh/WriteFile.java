package tientrinh;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class WriteFile extends Thread {
	private Socket sk;
	private String name;
	File file;

	public WriteFile(Socket sk, String name, File file) {
		this.sk = sk;
		this.name = name;
		this.file = file;
	}

	@Override
	public void run() {
		try {
			//Nguồn
			InputStream is = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(is);
			//Đích
			BufferedOutputStream bos = new BufferedOutputStream(sk.getOutputStream());
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
