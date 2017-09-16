package view;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuFormatItem {
	//Format Word Wrap
	private JMenuItem itemWordWrap;
	
	//Format Font
	private JMenuItem itemFont;

	public JMenuItem getItemWordWrap() {
		return itemWordWrap;
	}

	public JMenuItem getItemFont() {
		return itemFont;
	}
	
	public MenuFormatItem(){
		itemWordWrap = formatWordWrap();
		itemFont = formatFont();
	}
	
	
	public void addFormatItem(JMenu menuFormat){
		menuFormat.add(itemWordWrap);
		menuFormat.add(itemFont);
	}
	
	private JMenuItem formatWordWrap(){
		JMenuItem itemWordWrap = new JMenuItem("Word Wrap");
		return itemWordWrap;
	}
	
	private JMenuItem formatFont(){
		JMenuItem itemFont = new JMenuItem("Font");
		return itemFont;
	}
}
