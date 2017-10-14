package viewcontrol;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.MyMail;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblngNhp = new JLabel("LOGIN FORM");
		lblngNhp.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblngNhp.setBounds(162, 11, 105, 27);
		contentPane.add(lblngNhp);
		
		JLabel lblServerMail = new JLabel("Server mail:");
		lblServerMail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblServerMail.setBounds(10, 57, 105, 27);
		contentPane.add(lblServerMail);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPort.setBounds(10, 106, 105, 27);
		contentPane.add(lblPort);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setBounds(10, 157, 105, 27);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(10, 201, 105, 27);
		contentPane.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(125, 100, 259, 33);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(125, 149, 259, 33);
		contentPane.add(textField_2);
		
		JComboBox comboBox_serverMail = new JComboBox();
		comboBox_serverMail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_serverMail.setModel(new DefaultComboBoxModel(new String[] {"smtp.gmail.com", "smtp-mail.outlook.com"}));
		comboBox_serverMail.setBounds(125, 57, 189, 27);
		contentPane.add(comboBox_serverMail);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String serverMail = textField.getText();
				String serverMail = comboBox_serverMail.getSelectedItem().toString();
				
				String s_port = textField_1.getText();
				int port = Integer.parseInt(s_port);
				String username = textField_2.getText();
				String password = passwordField.getText();
				MyMail myMail = new MyMail(serverMail, port, username, password);
				if(myMail.login()){
					SendForm sendForm = new SendForm();
					sendForm.setMyMail(myMail);
					sendForm.setVisible(true);
					LoginForm.this.setVisible(false);
					JOptionPane.showConfirmDialog(LoginForm.this, "Login successful");
				} else{
					JOptionPane.showConfirmDialog(LoginForm.this, "Login fail");
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBounds(162, 264, 105, 33);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(125, 198, 259, 33);
		contentPane.add(passwordField);
		
		
	}
}
