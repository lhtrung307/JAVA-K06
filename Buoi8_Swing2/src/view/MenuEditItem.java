package view;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuEditItem {
	//Edit Undo
	private JMenuItem itemUndo;
	
	//Edit Cut
	private JMenuItem itemCut;
	
	//Edit Copy
	private JMenuItem itemCopy;
	
	//Edit Paste
	private JMenuItem itemPaste;
	
	//Edit Del
	private JMenuItem itemDel;
	
	//Edit Find
	private JMenuItem itemFind;
	
	//Edit Find Next
	private JMenuItem itemFindNext;
	
	//Edit Replace
	private JMenuItem itemReplace;
	
	//Edit Go To
	private JMenuItem itemGoTo;
	
	//Edit Select All
	private JMenuItem itemSelectAll;
	
	//Edit Time/Date
	private JMenuItem itemTimeDate;
	

	public JMenuItem getItemUndo() {
		return itemUndo;
	}

	public JMenuItem getItemCut() {
		return itemCut;
	}

	public JMenuItem getItemCopy() {
		return itemCopy;
	}

	public JMenuItem getItemPaste() {
		return itemPaste;
	}

	public JMenuItem getItemDel() {
		return itemDel;
	}

	public JMenuItem getItemFind() {
		return itemFind;
	}

	public JMenuItem getItemFindNext() {
		return itemFindNext;
	}

	public JMenuItem getItemReplace() {
		return itemReplace;
	}

	public JMenuItem getItemGoTo() {
		return itemGoTo;
	}

	public JMenuItem getItemSelectAll() {
		return itemSelectAll;
	}

	public JMenuItem getItemTimeDate() {
		return itemTimeDate;
	}
	
	public MenuEditItem(){
		itemUndo = editUndo();
		itemCut = editCut();
		itemCopy = editCopy();
		itemPaste = editPaste();
		itemDel = editDel();
		itemFind = editFind();
		itemFindNext = editFindNext();
		itemReplace = editReplace();
		itemGoTo = editGoTo();
		itemSelectAll = editSelectAll();
		itemTimeDate = editTimeDate();
		
	}
	
	public void addEditItem(JMenu menuEdit){
		menuEdit.add(itemUndo);
		menuEdit.addSeparator();
		menuEdit.add(itemCut);
		menuEdit.add(itemCopy);
		menuEdit.add(itemPaste);
		menuEdit.add(itemDel);
		menuEdit.addSeparator();
		menuEdit.add(itemFind);
		menuEdit.add(itemFindNext);
		menuEdit.add(itemReplace);
		menuEdit.add(itemGoTo);
		menuEdit.addSeparator();
		menuEdit.add(itemSelectAll);
		menuEdit.add(itemTimeDate);
	}
	
	private JMenuItem editUndo(){
		JMenuItem itemUndo = new JMenuItem("Undo");
		itemUndo.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		return itemUndo;
	}
	
	private JMenuItem editCut(){
		JMenuItem itemCut = new JMenuItem("Cut");
		itemCut.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		return itemCut;
	}
	
	private JMenuItem editCopy(){
		JMenuItem itemCopy = new JMenuItem("Copy");
		itemCopy.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		return itemCopy;
	}
	
	private JMenuItem editPaste(){
		JMenuItem itemPaste = new JMenuItem("Paste");
		itemPaste.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		return itemPaste;
	}
	
	private JMenuItem editDel(){
		JMenuItem itemDel = new JMenuItem("Delete");
		itemDel.setAccelerator(
				KeyStroke.getKeyStroke( KeyEvent.VK_DELETE, 0));
		return itemDel;
	}
	
	private JMenuItem editFind(){
		JMenuItem itemFind = new JMenuItem("Find");
		itemFind.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		return itemFind;
	}
	
	private JMenuItem editFindNext(){
		JMenuItem itemFindNext = new JMenuItem("Find Next");
		itemFindNext.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		return itemFindNext;
	}
	
	private JMenuItem editReplace(){
		JMenuItem itemReplace = new JMenuItem("Replace");
		itemReplace.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
		return itemReplace;
	}
	
	private JMenuItem editGoTo(){
		JMenuItem itemGoTo = new JMenuItem("Go To");
		itemGoTo.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		return itemGoTo;
	}
	
	private JMenuItem editSelectAll(){
		JMenuItem itemSelectAll = new JMenuItem("Select All");
		itemSelectAll.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		return itemSelectAll;
	}
	
	private JMenuItem editTimeDate(){
		JMenuItem itemTimeDate = new JMenuItem("Time/Date");
		itemTimeDate.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		return itemTimeDate;
	}
}
