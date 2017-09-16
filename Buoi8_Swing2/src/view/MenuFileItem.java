package view;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuFileItem{
	//File new
	private JMenuItem itemNew;
	
	//File open
	private JMenuItem itemOpen;
	
	//File save
	private JMenuItem itemSave;

	//File save as
	private JMenuItem itemSaveAs;
	
	//File page setup
	private JMenuItem itemPageSetup;
	
	//File print
	private JMenuItem itemPrint;
	
	//File exit
	private JMenuItem itemExit;
	
	public MenuFileItem(){
		itemNew = fileNew();
		itemOpen = fileOpen();
		itemSave = fileSave();
		itemSaveAs = fileSaveAs();
		itemPageSetup = filePageSetup();
		itemPrint = filePrint();
		itemExit = fileExit();
	}
	

	public JMenuItem getItemNew() {
		return itemNew;
	}

	public JMenuItem getItemOpen() {
		return itemOpen;
	}

	public JMenuItem getItemSave() {
		return itemSave;
	}

	public JMenuItem getItemSaveAs() {
		return itemSaveAs;
	}

	public JMenuItem getItemPageSetup() {
		return itemPageSetup;
	}

	public JMenuItem getItemPrint() {
		return itemPrint;
	}

	public JMenuItem getItemExit() {
		return itemExit;
	}
	
	public void addMenuFile(JMenu menuFile){
		menuFile.add(itemNew);
		menuFile.add(itemOpen);
		menuFile.add(itemSave);
		menuFile.add(itemSaveAs);
		menuFile.addSeparator();
		menuFile.add(itemPageSetup);
		menuFile.add(itemPrint);
		menuFile.addSeparator();
		menuFile.add(itemExit);
	}
	
	private JMenuItem fileNew() {
		JMenuItem itemNew = new JMenuItem("New");
		itemNew.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		return itemNew;
	}
	
	private JMenuItem fileOpen(){
		JMenuItem itemOpen = new JMenuItem("Open");
		itemOpen.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		return itemOpen;
	}
	
	private JMenuItem fileSave(){
		JMenuItem itemSave = new JMenuItem("Save");
		itemSave.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		return itemSave;
	}
	
	private JMenuItem fileSaveAs(){
		JMenuItem itemSaveAs = new JMenuItem("Save As");
		return itemSaveAs;
	}
	
	private JMenuItem filePageSetup(){
		JMenuItem itemPageSetup = new JMenuItem("Page Setup");
		return itemPageSetup;
	}
	
	private JMenuItem filePrint(){
		JMenuItem itemPrint = new JMenuItem("Print");
		itemPrint.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		return itemPrint;
	}
	
	private JMenuItem fileExit(){
		JMenuItem itemExit = new JMenuItem("Exit");
		return itemExit;
	}
}
