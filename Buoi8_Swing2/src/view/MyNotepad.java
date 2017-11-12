package view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MyNotepad extends JFrame implements ActionListener{
	private String tenFile = "";
	private JTextPane jTextPane;
	private MenuBarItem menuBarItem; 
	
	public MyNotepad(){
		this.setTitle("My Notepad v 1.0");
		
		this.setSize(800, 600);
		
		this.setAppIcon();
		
		this.setLayout(new BorderLayout());
		
		menuBarItem = new MenuBarItem();
		addFileItemEvent();
		addEditItemEvent();
		addFormatItemEvent();
		addViewItemEvent();
		addHelpItemEvent();
		
		JMenuBar menuBar = new JMenuBar();
		menuBarItem.addToMenuBar(menuBar);
		
		//Them menu vao notepad
		this.add(menuBar, BorderLayout.NORTH);
		
		jTextPane = new JTextPane();
		JScrollPane jScrollPane = new JScrollPane(jTextPane);
		this.add(jScrollPane, BorderLayout.CENTER);
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void setAppIcon(){
		Image icon = new ImageIcon(getClass().getResource("notepad-icon.png")).getImage();
		this.setIconImage(icon);
	}
	
	private void addFileItemEvent(){
		menuBarItem.getFileItem().getItemNew().addActionListener(this);
		menuBarItem.getFileItem().getItemOpen().addActionListener(this);
		menuBarItem.getFileItem().getItemSave().addActionListener(this);
		menuBarItem.getFileItem().getItemSaveAs().addActionListener(this);
		menuBarItem.getFileItem().getItemPageSetup().addActionListener(this);
		menuBarItem.getFileItem().getItemPrint().addActionListener(this);
		menuBarItem.getFileItem().getItemExit().addActionListener(this);
		
	}
	
	private void addEditItemEvent(){
		menuBarItem.getEditItem().getItemUndo().addActionListener(this);
		menuBarItem.getEditItem().getItemCopy().addActionListener(this);
		menuBarItem.getEditItem().getItemCut().addActionListener(this);
		menuBarItem.getEditItem().getItemPaste().addActionListener(this);
		menuBarItem.getEditItem().getItemDel().addActionListener(this);
		menuBarItem.getEditItem().getItemFind().addActionListener(this);
		menuBarItem.getEditItem().getItemFindNext().addActionListener(this);
		menuBarItem.getEditItem().getItemReplace().addActionListener(this);
		menuBarItem.getEditItem().getItemSelectAll().addActionListener(this);
		menuBarItem.getEditItem().getItemTimeDate().addActionListener(this);
	}
	
	private void addFormatItemEvent(){
		menuBarItem.getFormatItem().getItemWordWrap().addActionListener(this);
		menuBarItem.getFormatItem().getItemFont().addActionListener(this);
	}
	
	private void addViewItemEvent(){
		menuBarItem.getViewItem().getItemViewStatusBar().addActionListener(this);
	}
	
	private void addHelpItemEvent(){
		menuBarItem.getHelpItem().getItemViewHelp().addActionListener(this);
		menuBarItem.getHelpItem().getItemAbout().addActionListener(this);
	}


	
	public static void main(String[] args) {
		try {
            // Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
		new MyNotepad();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String tenSuKien = e.getActionCommand();
		if(tenSuKien.equals("New")){
			this.newFile();
		}
		if(tenSuKien.equals("Save")){
			this.save();
		}
		if(tenSuKien.equals("Save As")){
			this.saveAs();
		}
		if(tenSuKien.equals("Open")){
			this.open();
		}
		if(tenSuKien.equals("Exit")){
			this.exit();
		}
		if(tenSuKien.equals("Print")){
			this.print();
		}
		if(tenSuKien.equals("Word Wrap")){
			this.wordWrap();
		}
		if(tenSuKien.equals("Page Setup")){
			this.pageSetup();
		}
	}

	

	private void newFile(){
		confirmSaveFileDialog();
	}
	
	private void cleanFile(){
		tenFile = "";
		jTextPane.setText("");
	}

	private void saveAs() {
		String tenFileDuPhong = tenFile;
		tenFile = "";
		save();
		if(tenFile.equals("")){
			tenFile = tenFileDuPhong;
		}
	}
	
	private boolean save() {
		boolean isSave = false;
		try {
			File file = new File(tenFile);
			if(tenFile.equals("")){
				JFileChooser jfc = new JFileChooser();
				int returnVal = jfc.showSaveDialog(this);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					file = jfc.getSelectedFile();
					isSave = true;
				}
			}
			if(!file.exists()){
				file.createNewFile();
			}
			saveFile(file.getAbsolutePath());
			
		}catch (Exception e) {
//			e.printStackTrace();
			System.out.println("hello");
		}
		return isSave;
	}
	
	private void saveFile(String tenFile){
		this.tenFile = tenFile;
		String duLieu = jTextPane.getText();
		OutputStream os;
		try {
			os = new FileOutputStream(tenFile);
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			osw.write(duLieu);
			osw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean open(){
		boolean isOpen = false;
		try{
			if(!jTextPane.getText().equals("")){
				confirmSaveFileDialog();
			}
			if(jTextPane.getText().equals("")){
				File openFile = new File(tenFile);
				JFileChooser jfc = new JFileChooser();
				int returnVal = jfc.showOpenDialog(this);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					openFile = jfc.getSelectedFile();
					isOpen = true;
				}
				this.readFile(openFile.getAbsolutePath());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return isOpen;
	}
	
//	private void readFile(String tenFile){
//		this.tenFile = tenFile;
//		char[] duLieu = new char[2];
//		String duLieuFull = "";
//		try{
//			InputStream is = new FileInputStream(tenFile);
//			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
//			while(isr.read(duLieu) != -1){
//				duLieuFull += String.valueOf(duLieu);
//			}
//			jTextPane.setText(duLieuFull);
//			isr.close();
//		} catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	
	private void readFile(String tenFile){
		this.tenFile = tenFile;
		try {
			InputStream is = new FileInputStream(tenFile);
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String kq = "";
			while(true){
				String s = br.readLine();
				if(s == null){
					break;
				}
				s = (kq.length() == 0) ? s : "\n" + s;
				kq = kq + s;
			}
			jTextPane.setText(kq);
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void confirmSaveFileDialog(){
		int choose = JOptionPane.showConfirmDialog(this, "Ban co muon luu noi dung hay khong");
		if(choose == JOptionPane.YES_OPTION){
			if(this.save()){
				cleanFile();
			}
		} else if(choose == JOptionPane.NO_OPTION){
			cleanFile();
		}
	}
	
	private void pageSetup(){
		PrinterJob pj = PrinterJob.getPrinterJob();
		PageFormat pf = pj.pageDialog(pj.defaultPage());
	}
	
	private void print(){
		try {
			jTextPane.setContentType("text/html");
			jTextPane.print();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void wordWrap() {
		// TODO Auto-generated method stub
		
	}
	
	private void exit(){
		this.confirmSaveFileDialog();
		System.exit(0);
	}
	
	
}
