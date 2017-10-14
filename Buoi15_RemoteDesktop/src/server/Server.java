package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import tientrinh.Read;
import tientrinh.Write;

public class Server {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		try {
			
			ServerSocket ss = new ServerSocket(13579);
			
			while (true) {
				Socket sk = ss.accept();
				Thread read = new Read(sk);
				Thread write = new Write(sk, "Server");
				read.start();
				write.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
