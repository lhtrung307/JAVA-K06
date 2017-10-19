package viewcontrol;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.MyMail;
import model.UserMail;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class SendForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_to;
	private JTextField textField_cc;
	private JTextField textField_bcc;
	private MyMail myMail;
	private JTextField textField_subject;
	private JTextField textField_filePath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendForm frame = new SendForm();
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
	public SendForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTo.setBounds(10, 67, 105, 27);
		contentPane.add(lblTo);
		
		JLabel lblCc = new JLabel("CC:");
		lblCc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCc.setBounds(10, 105, 105, 27);
		contentPane.add(lblCc);
		
		JLabel lblBcc = new JLabel("BCC:");
		lblBcc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBcc.setBounds(10, 143, 105, 27);
		contentPane.add(lblBcc);
		
		JLabel lblBodyContent = new JLabel("Body Content");
		lblBodyContent.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBodyContent.setBounds(10, 199, 163, 27);
		contentPane.add(lblBodyContent);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 239, 552, 126);
		contentPane.add(textArea);
		
		JButton btnSendMail = new JButton("Send mail");
		btnSendMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String subject = textField_subject.getText();
				String to = textField_to.getText();
				String cc = textField_cc.getText();
				String bcc = textField_bcc.getText();
				String content = textArea.getText();
				String filePath = textField_filePath.getText();
				UserMail userMail = new UserMail(to, cc, bcc, subject, content, filePath);
				boolean check = userMail.sendMail(myMail.session, myMail.username);
				if(check){
					JOptionPane.showMessageDialog(SendForm.this, "Success!");
				} else{
					JOptionPane.showMessageDialog(SendForm.this, "Fail!");
				}
			}
		});
		btnSendMail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSendMail.setBounds(88, 440, 133, 33);
		contentPane.add(btnSendMail);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogOut.setBounds(336, 440, 133, 33);
		contentPane.add(btnLogOut);
		
		textField_to = new JTextField();
		textField_to.setColumns(10);
		textField_to.setBounds(96, 66, 373, 33);
		contentPane.add(textField_to);
		
		textField_cc = new JTextField();
		textField_cc.setColumns(10);
		textField_cc.setBounds(96, 105, 373, 33);
		contentPane.add(textField_cc);
		
		textField_bcc = new JTextField();
		textField_bcc.setColumns(10);
		textField_bcc.setBounds(96, 141, 373, 33);
		contentPane.add(textField_bcc);
		
		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubject.setBounds(10, 29, 105, 27);
		contentPane.add(lblSubject);
		
		textField_subject = new JTextField();
		textField_subject.setColumns(10);
		textField_subject.setBounds(96, 28, 373, 33);
		contentPane.add(textField_subject);
		
		JLabel lblFilePath = new JLabel("File Path:");
		lblFilePath.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFilePath.setBounds(10, 388, 163, 27);
		contentPane.add(lblFilePath);
		
		textField_filePath = new JTextField();
		textField_filePath.setColumns(10);
		textField_filePath.setBounds(115, 387, 340, 33);
		contentPane.add(textField_filePath);
		
		JButton btnChoose = new JButton("Choose");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				int returnVal = jfc.showOpenDialog(SendForm.this);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File file = jfc.getSelectedFile();
					textField_filePath.setText(file.getAbsolutePath());
				}
			}
		});
		btnChoose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChoose.setBounds(486, 388, 117, 33);
		contentPane.add(btnChoose);
	}

	public MyMail getMyMail() {
		return myMail;
	}

	public void setMyMail(MyMail myMail) {
		this.myMail = myMail;
	}
}

