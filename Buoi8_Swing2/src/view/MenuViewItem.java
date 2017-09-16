package view;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuViewItem {
	private JMenuItem itemStatusBar;

	public JMenuItem getItemViewStatusBar() {
		return itemStatusBar;
	}
	
	public MenuViewItem(){
		itemStatusBar = viewStatusBar();
	}
	
	public void addViewItem(JMenu menuView){
		menuView.add(itemStatusBar);
	}
	
	private JMenuItem viewStatusBar(){
		JMenuItem itemStatusBar = new JMenuItem("Status Bar");
		return itemStatusBar;
	}
}
