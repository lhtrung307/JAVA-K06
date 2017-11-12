package model;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class Test {

	protected Shell shlStudent;
	private Table table;
	private Text text;
	private Text text_1;
	private Text text_3;
	private Text text_5;
	private Text text_2;
	private Text text_4;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Test window = new Test();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlStudent.open();
		shlStudent.layout();
		while (!shlStudent.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlStudent = new Shell();
		shlStudent.setSize(759, 600);
		shlStudent.setText("Student");
		
		Menu menu = new Menu(shlStudent, SWT.BAR);
		shlStudent.setMenuBar(menu);
		
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");
		
		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);
		
		MenuItem mntmNewItem = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem.setText("Open");
		
		MenuItem mntmClose = new MenuItem(menu_1, SWT.NONE);
		mntmClose.setText("Close");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mntmExit = new MenuItem(menu_1, SWT.NONE);
		mntmExit.setText("Exit");
		
		MenuItem mntmAbout = new MenuItem(menu, SWT.CASCADE);
		mntmAbout.setText("About");
		
		Menu menu_2 = new Menu(mntmAbout);
		mntmAbout.setMenu(menu_2);
		
		MenuItem mntmAboutMe = new MenuItem(menu_2, SWT.NONE);
		mntmAboutMe.setText("About me");
		
		Group grpStudentFilter = new Group(shlStudent, SWT.NONE);
		grpStudentFilter.setText("Student filter");
		grpStudentFilter.setBounds(10, 10, 723, 69);
		
		text = new Text(grpStudentFilter, SWT.BORDER);
		text.setBounds(81, 31, 171, 28);
		
		Label lblNewLabel = new Label(grpStudentFilter, SWT.CENTER);
		lblNewLabel.setFont(SWTResourceManager.getFont("Arial", 10, SWT.NORMAL));
		lblNewLabel.setBounds(10, 34, 55, 28);
		lblNewLabel.setText("BirthPlace");
		
		text_1 = new Text(grpStudentFilter, SWT.BORDER);
		text_1.setBounds(424, 31, 150, 28);
		
		Label lblNewLabel_1 = new Label(grpStudentFilter, SWT.NONE);
		lblNewLabel_1.setBounds(363, 34, 55, 15);
		lblNewLabel_1.setText("StudentID");
		
		Button btnFillter = new Button(grpStudentFilter, SWT.NONE);
		btnFillter.setBounds(604, 31, 94, 28);
		btnFillter.setText("Fillter");
		
		Group grpStudentInfo = new Group(shlStudent, SWT.NONE);
		grpStudentInfo.setText("Student Info");
		grpStudentInfo.setBounds(10, 304, 723, 227);
		
		Label lblNewLabel_2 = new Label(grpStudentInfo, SWT.NONE);
		lblNewLabel_2.setBounds(10, 30, 55, 15);
		lblNewLabel_2.setText("New Label");
		
		Label label = new Label(grpStudentInfo, SWT.NONE);
		label.setText("New Label");
		label.setBounds(10, 100, 55, 15);
		
		Label label_1 = new Label(grpStudentInfo, SWT.NONE);
		label_1.setText("New Label");
		label_1.setBounds(10, 130, 55, 15);
		
		Label label_2 = new Label(grpStudentInfo, SWT.NONE);
		label_2.setText("New Label");
		label_2.setBounds(10, 68, 55, 15);
		
		Label label_3 = new Label(grpStudentInfo, SWT.NONE);
		label_3.setText("New Label");
		label_3.setBounds(10, 160, 55, 15);
		
		text_3 = new Text(grpStudentInfo, SWT.BORDER);
		text_3.setBounds(71, 130, 76, 21);
		
		text_5 = new Text(grpStudentInfo, SWT.BORDER);
		text_5.setBounds(71, 30, 76, 21);
		
		text_2 = new Text(grpStudentInfo, SWT.BORDER);
		text_2.setBounds(71, 160, 76, 21);
		
		text_4 = new Text(grpStudentInfo, SWT.BORDER);
		text_4.setBounds(71, 97, 76, 21);
		
		Group grpListStudent = new Group(shlStudent, SWT.NONE);
		grpListStudent.setText("List Student");
		grpListStudent.setBounds(10, 85, 723, 213);
		
		table = new Table(grpListStudent, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 35, 703, 168);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(36);
		tblclmnNewColumn.setText("No");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(78);
		tblclmnNewColumn_1.setText("ID");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(169);
		tblclmnNewColumn_2.setText("Name");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(110);
		tblclmnNewColumn_3.setText("Place");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(97);
		tblclmnNewColumn_4.setText("Date");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_5.setWidth(42);
		tblclmnNewColumn_5.setText("Sex");
		
		TableColumn tblclmnNewColumn_6 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_6.setWidth(62);
		tblclmnNewColumn_6.setText("Math");
		
		TableColumn tblclmnNewColumn_7 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_7.setWidth(62);
		tblclmnNewColumn_7.setText("Physic");
		
		TableColumn tblclmnNewColumn_8 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_8.setWidth(64);
		tblclmnNewColumn_8.setText("Chemistry");

	}
}
