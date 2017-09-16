package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class MyWannacry extends JFrame implements ActionListener{
	private JTextField jTextFieldSource;
	private JTextField jTextFieldCode;
	
	public MyWannacry(){
		this.setTitle("My Wannacry 1.0");
		
		this.setSize(600, 200);
		
		this.getContentPane().setBackground(Color.RED);
		
		JPanel jPanelFileSrc = new JPanel();
		JLabel jLableFileSource = new JLabel("File source");
		jTextFieldSource = new JTextField(40);
		JButton jButton = new JButton("Chon File");
		jButton.addActionListener(this);
		jPanelFileSrc.add(jLableFileSource);
		jPanelFileSrc.add(jTextFieldSource);
		jPanelFileSrc.add(jButton);
		jPanelFileSrc.setBackground(Color.RED);
		
		this.add(jPanelFileSrc);
		
		JPanel jPanelCode = new JPanel();
//		jPanelCode.setLayout(new FlowLayout());
		JLabel jLableCode = new JLabel("Code");
		jTextFieldCode = new JTextField(60);
		jPanelCode.add(jLableCode);
		jPanelCode.add(jTextFieldCode);
		jPanelCode.setBackground(Color.RED);
		
		this.add(jPanelCode);
		
		JPanel jPanelButton = new JPanel();
		JButton encrypt = new JButton("Encrypt");
		JButton decrypt = new JButton("Decrypt");
		jPanelButton.add(encrypt);
		encrypt.addActionListener(this);
		decrypt.addActionListener(this);
		jPanelButton.add(decrypt);
		jPanelButton.setBackground(Color.RED);
		
		this.add(jPanelButton);
		
		
//		JTextPane jTextPane = new JTextPane();
//		jTextPane.setSize(400, 100);
//		this.add(jTextPane);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String tenSuKien = e.getActionCommand();
		if(tenSuKien.equals("Chon File")){
			chonFile();
		}
		if(tenSuKien.equals("Encrypt")){
			encryptFile();
		}
		if(tenSuKien.equals("Decrypt")){
			decryptFile();
		}
	}
	
	private void encryptFile() {
		if(jTextFieldSource.getText().length() == 0){
			JOptionPane.showConfirmDialog(this, "Ban chua chon file!");
		} else{
			String linkSource = jTextFieldSource.getText();
			File fileSource = new File(linkSource);
			if(!fileSource.exists()){
				JOptionPane.showConfirmDialog(this, "File khong ton tai!");
			}else{
				String tenFileDest = linkSource + ".wnr";
				File fileDest = new File(tenFileDest);
				try {
					FileInputStream fis = new FileInputStream(fileSource);
					FileOutputStream fos = new FileOutputStream(fileDest);
					
					String code = jTextFieldCode.getText();
					int k = code.charAt(0) - code.charAt(code.length() - 1);
					
					int i;
					while((i = fis.read()) != -1){
						fos.write(i + k);
					}
					fis.close();
					fos.close();
					fileSource.delete();
					JOptionPane.showConfirmDialog(this, "Da ma hoa xong!!!");
				} catch (Exception e) {
					e.printStackTrace();;
				}
			}
		}
	}
	
	private void decryptFile() {
		if(jTextFieldSource.getText().length() == 0){
			JOptionPane.showConfirmDialog(this, "Ban chua chon file!");
		} else{
			String linkSource = jTextFieldSource.getText();
			File fileSource = new File(linkSource);
			if(!fileSource.exists()){
				JOptionPane.showConfirmDialog(this, "File khong ton tai!");
			}else{
				String tenFileDest = linkSource.substring(0, linkSource.lastIndexOf("."));
				File fileDest = new File(tenFileDest);
				try {
					FileInputStream fis = new FileInputStream(fileSource);
					FileOutputStream fos = new FileOutputStream(fileDest);
					
					String code = jTextFieldCode.getText();
					int k = code.charAt(0) - code.charAt(code.length() - 1);
					
					int i;
					while((i = fis.read()) != -1){
						fos.write(i - k);
					}
					fis.close();
					fos.close();
					fileSource.delete();
					JOptionPane.showConfirmDialog(this, "Da giai ma xong!!!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void copyFile(String fileSrc, String folderDest) {
		File fSrc = new File(fileSrc);
		File fDest = new File(folderDest);
		try {
			if (fSrc.exists() && fDest.exists() && fSrc.isFile() && fDest.isDirectory()) {
				// Tao file tuong tu trong thu muc dich
				String newPath = folderDest + "\\" + fSrc.getName();
				File fileNew = new File(newPath);
				fileNew.createNewFile();
				// Copy
				FileInputStream fileInStream = new FileInputStream(fSrc);
				FileOutputStream fileOutStream = new FileOutputStream(fileNew);
				// int r;
				// while((r = fileInStream.read()) != -1){
				// fileOutStream.write(r);
				// }
				byte[] mang = new byte[1024 * 1024];
				// int soLuong;
				// while(fileInStream.read(mang) > 0){
				//
				// }
				while (true) {
					int soLuong = fileInStream.read(mang);
					if (soLuong > 0) {
						fileOutStream.write(mang, 0, soLuong);
					} else {
						break;
					}
				}
				fileInStream.close();
				fileOutStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	private void chonFile() {
		File file = null;
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			file = jfc.getSelectedFile();
		}
		if(file != null){
			jTextFieldSource.setText(file.getAbsolutePath());
		}
	}



	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new MyWannacry();
	}
}
