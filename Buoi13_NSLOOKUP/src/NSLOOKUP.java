import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class NSLOOKUP extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextPane textPane;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
			            // Set cross-platform Java L&F (also called "Metal")
			        UIManager.setLookAndFeel(
			            UIManager.getSystemLookAndFeelClassName());
					} 
				    catch (Exception e) {
				       e.printStackTrace();
				    }
					NSLOOKUP frame = new NSLOOKUP();
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
	public NSLOOKUP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PHẦN MỀM PHÂN GIẢI TÊN MIỀN VÀ KIỂM TRA KẾT NỐI");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 41);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(20, 63, 392, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Phân Giải");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ip = textField.getText();
				if(ip == null || ip.indexOf(".") < 0){
					JOptionPane.showMessageDialog(NSLOOKUP.this, "Thông tin tên miền chưa đúng!");
				} else {
					try {
						InetAddress ina = InetAddress.getByName(ip);
						String ipv4 = ina.getHostAddress();
						String ketQua = "IP: " + ipv4;
						textPane.setText(ketQua);
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(20, 115, 125, 41);
		contentPane.add(btnNewButton);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textPane.setBounds(10, 182, 414, 68);
		contentPane.add(textPane);
		
		btnNewButton_1 = new JButton("Kiểm tra kết nối (ping)");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ip = textField.getText();
				if(ip == null || ip.indexOf(".") < 0){
					JOptionPane.showMessageDialog(NSLOOKUP.this, "Thông tin tên miền chưa đúng!");
				} else {
					try {
						InetAddress ina = InetAddress.getByName(ip);
						String ketQua = ina.isReachable(5000) ? "Host is reachable" : "Host is not reachable";
						textPane.setText(ketQua);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(208, 115, 179, 41);
		contentPane.add(btnNewButton_1);
	}
}
