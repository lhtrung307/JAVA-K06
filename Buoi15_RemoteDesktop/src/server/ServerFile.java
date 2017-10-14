package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import tientrinh.Read;
import tientrinh.Write;
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
