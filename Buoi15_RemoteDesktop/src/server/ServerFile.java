package server;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import tientrinh.WriteFile;

public class ServerFile {
	File file;
	
	public ServerFile(File file) {
		this.file = file;
		
		Socket sk;
		try {
			ServerSocket ss = new ServerSocket(13577);
			sk = ss.accept();
			WriteFile wf = new WriteFile(sk, "Server", file);
			wf.start();
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
