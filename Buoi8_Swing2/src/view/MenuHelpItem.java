package view;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuHelpItem {
	//Format Word Wrap
	private JMenuItem itemViewHelp;
			
	//Format Font
	private JMenuItem itemAbout;

	public JMenuItem getItemViewHelp() {
		return itemViewHelp;
	}

	public JMenuItem getItemAbout() {
		return itemAbout;
	}
	
	public MenuHelpItem(){
		itemViewHelp = helpViewHelp();
		itemAbout = helpAbout();
	}
	
	private JMenuItem helpViewHelp(){
		JMenuItem itemViewHelp = new JMenuItem("View Help");
		return itemViewHelp;
	}
	
	private JMenuItem helpAbout(){
		JMenuItem itemAbout = new JMenuItem("About");
		return itemAbout;
	}
	
	public void addHelpItem(JMenu menuHelp){
		menuHelp.add(itemViewHelp);
		menuHelp.addSeparator();
		menuHelp.add(itemAbout);
	}
}
