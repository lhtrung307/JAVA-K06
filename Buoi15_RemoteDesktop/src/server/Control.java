package server;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Control {
	public static void runCommand(String command) {
		try {
			Runtime.getRuntime().exec(command);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void shutdown(int second) {
		String shutdownCmd = "shutdown -s -t " + second;
		runCommand(shutdownCmd);
	}

	public static void restart(int second) {
		String restartCmd = "shutdown -r -t " + second;
		runCommand(restartCmd);
	}

	public static void cancelShutdown() {
		String cancelCmd = "shutdown -a";
		runCommand(cancelCmd);
	}

	public static void makeDir(String name) {
		
	}
	
	public static void capture(){
		try {
			BufferedImage bi = chupManHinh();
			File outputimg = new File("D:\\TestImage\\" + System.currentTimeMillis() + ".png");
			ImageIO.write(bi, "png", outputimg);
			
			ServerFile serverFile = new ServerFile(outputimg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static BufferedImage chupManHinh() throws AWTException{
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		Robot r = new Robot();
		return r.createScreenCapture(new Rectangle(0, 0, (int)screenDim.getWidth(), (int)screenDim.getHeight()));
	}

	public static void main(String[] args) {
		capture();
	}

}
