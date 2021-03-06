package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuBarItem {
	private JMenu menuFile;
	private MenuFileItem fileItem = new MenuFileItem();
	private JMenu menuEdit;
	private MenuEditItem editItem = new MenuEditItem();
	private JMenu menuFormat;
	private MenuFormatItem formatItem = new MenuFormatItem();
	private JMenu menuView;
	private MenuViewItem viewItem = new MenuViewItem();
	private JMenu menuHelp;
	private MenuHelpItem helpItem = new MenuHelpItem();
	
	public JMenu getMenuFile() {
		return menuFile;
	}
	public JMenu getMenuEdit() {
		return menuEdit;
	}
	public MenuFileItem getFileItem() {
		return fileItem;
	}
	public JMenu getMenuFormat() {
		return menuFormat;
	}
	public JMenu getMenuView() {
		return menuView;
	}
	public JMenu getMenuHelp() {
		return menuHelp;
	}
	
	public MenuEditItem getEditItem() {
		return editItem;
	}
	public MenuFormatItem getFormatItem() {
		return formatItem;
	}
	public MenuViewItem getViewItem() {
		return viewItem;
	}
	public MenuHelpItem getHelpItem() {
		return helpItem;
	}
	public MenuBarItem(){
		createMenuFile();
		createMenuEdit();
		createMenuFormat();
		createMenuView();
		createMenuHelp();
	}
	
	private void createMenuFile(){
		menuFile = new JMenu("File");
		fileItem.addMenuFile(menuFile);
	}
	
	private void createMenuEdit(){
		menuEdit = new JMenu("Edit");
		editItem.addEditItem(menuEdit);
	}
	
	private void createMenuFormat(){
		menuFormat = new JMenu("Format");
		formatItem.addFormatItem(menuFormat);
	}
	
	private void createMenuView(){
		menuView = new JMenu("View");
		viewItem.addViewItem(menuView);
	}
	
	private void createMenuHelp(){
		menuHelp = new JMenu("Help");	
		helpItem.addHelpItem(menuHelp);
	}
	
	
	public void addToMenuBar(JMenuBar menuBar){
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuFormat);
		menuBar.add(menuView);
		menuBar.add(menuHelp);
	}
}
