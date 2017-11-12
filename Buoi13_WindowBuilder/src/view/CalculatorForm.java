package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CalculatorForm {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorForm window = new CalculatorForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculatorForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmMayTinhKhoa = new JMenuItem("May tinh khoa hoc");
		mnFile.add(mntmMayTinhKhoa);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmMayTinhThong = new JMenuItem("May tinh thong thuon");
		mnFile.add(mntmMayTinhThong);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 5, 0, 0));
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton button = new JButton("New button");
		panel.add(button);
		
		JButton button_1 = new JButton("New button");
		panel.add(button_1);
		
		JButton button_2 = new JButton("New button");
		panel.add(button_2);
		
		JButton button_3 = new JButton("/");
		panel.add(button_3);
		
		JButton button_4 = new JButton("New button");
		panel.add(button_4);
		
		JButton button_5 = new JButton("7");
		panel.add(button_5);
		
		JButton button_6 = new JButton("8");
		panel.add(button_6);
		
		JButton button_7 = new JButton("9");
		panel.add(button_7);
		
		JButton btnX = new JButton("X");
		panel.add(btnX);
		
		JButton button_9 = new JButton("New button");
		panel.add(button_9);
		
		JButton button_10 = new JButton("4");
		panel.add(button_10);
		
		JButton button_11 = new JButton("5");
		panel.add(button_11);
		
		JButton btnNewButton = new JButton("6");
		panel.add(btnNewButton);
		
		JButton button_12 = new JButton("-");
		panel.add(button_12);
		
		JButton button_16 = new JButton("New button");
		panel.add(button_16);
		
		JButton button_17 = new JButton("1");
		panel.add(button_17);
		
		JButton button_14 = new JButton("2");
		panel.add(button_14);
		
		JButton button_15 = new JButton("3");
		panel.add(button_15);
		
		JButton button_18 = new JButton("+");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(button_18);
		
		JButton button_19 = new JButton("New button");
		panel.add(button_19);
		
		JButton button_13 = new JButton("New button");
		panel.add(button_13);
		
		JButton button_20 = new JButton("0");
		panel.add(button_20);
		
		JButton button_21 = new JButton(".");
		panel.add(button_21);
		
		JButton button_22 = new JButton("=");
		panel.add(button_22);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if( e.getButton() == MouseEvent.BUTTON1){
					textField.setText("Click!!!");
				}
			}
		});
		frame.getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
	}

}
