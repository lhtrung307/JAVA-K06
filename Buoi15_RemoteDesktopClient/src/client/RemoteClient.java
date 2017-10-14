package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class RemoteClient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblTrngThiCha;
	private Client client = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoteClient frame = new RemoteClient();
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
	public RemoteClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CHƯƠNG TRÌNH ĐIỀU KHIỂN MÁY TÍNH TỪ XA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(135, 30, 459, 51);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Địa chỉ IP:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(65, 76, 79, 41);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(171, 82, 359, 32);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblPort = new JLabel("Port:");
		lblPort.setHorizontalAlignment(SwingConstants.CENTER);
		lblPort.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPort.setBounds(65, 127, 79, 41);
		contentPane.add(lblPort);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(171, 133, 359, 32);
		contentPane.add(textField_1);

		JButton btnNewButton = new JButton("Kết nối");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ip = textField.getText();
				String s_port = textField_1.getText();
				int port = Integer.parseInt(s_port);
				client = new Client(ip, port);
				if (client.sk != null) {
					lblTrngThiCha.setText("Đã kết nối!");
					JOptionPane.showMessageDialog(RemoteClient.this, "Đã kết nối!!");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(199, 179, 105, 32);
		contentPane.add(btnNewButton);

		JButton btnHyKtNi = new JButton("Hủy kết nối");
		btnHyKtNi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (client.sk != null) {
					client.sk = null;
					JOptionPane.showMessageDialog(RemoteClient.this, "Đã ngắt kết nối!");
				} else {
					JOptionPane.showMessageDialog(RemoteClient.this, "Hiện không tồn tại kết nối!!!");
				}
			}
		});
		btnHyKtNi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHyKtNi.setBounds(378, 179, 126, 32);
		contentPane.add(btnHyKtNi);

		lblTrngThiCha = new JLabel("Trạng thái: Chưa kết nối");
		lblTrngThiCha.setHorizontalAlignment(SwingConstants.LEFT);
		lblTrngThiCha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrngThiCha.setBounds(65, 222, 239, 41);
		contentPane.add(lblTrngThiCha);

		JSeparator separator = new JSeparator();
		separator.setBounds(25, 274, 691, 2);
		contentPane.add(separator);

		JLabel lblThiGian = new JLabel("Thời gian:");
		lblThiGian.setHorizontalAlignment(SwingConstants.CENTER);
		lblThiGian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThiGian.setBounds(65, 288, 79, 41);
		contentPane.add(lblThiGian);

		textField_2 = new JTextField();
		textField_2.setBounds(154, 294, 105, 32);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblGiy = new JLabel("(giây)");
		lblGiy.setBounds(269, 303, 46, 14);
		contentPane.add(lblGiy);

		JButton btnTtMy = new JButton("Tắt máy");
		btnTtMy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkClientStatusOn()) {
					client.shutdown(Integer.parseInt(textField_2.getText()));
				} else {
					JOptionPane.showMessageDialog(RemoteClient.this, "Hiện không tồn tại kết nối!!!");
				}
			}
		});
		btnTtMy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTtMy.setBounds(322, 287, 105, 32);
		contentPane.add(btnTtMy);

		JButton btnKhingLi = new JButton("Khởi động lại");
		btnKhingLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkClientStatusOn()) {
					client.restart(Integer.parseInt(textField_2.getText()));
				} else {
					JOptionPane.showMessageDialog(RemoteClient.this, "Hiện không tồn tại kết nối!!!");
				}
			}
		});
		btnKhingLi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnKhingLi.setBounds(437, 287, 132, 32);
		contentPane.add(btnKhingLi);

		JButton btnHyLnh = new JButton("Hủy lệnh");
		btnHyLnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkClientStatusOn()) {
					client.cancel();
				} else {
					JOptionPane.showMessageDialog(RemoteClient.this, "Hiện không tồn tại kết nối!!!");
				}
			}
		});
		btnHyLnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHyLnh.setBounds(579, 287, 105, 32);
		contentPane.add(btnHyLnh);

		JLabel lblThMcLu = new JLabel("Thư mục lưu hình");
		lblThMcLu.setHorizontalAlignment(SwingConstants.CENTER);
		lblThMcLu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThMcLu.setBounds(65, 343, 149, 41);
		contentPane.add(lblThMcLu);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(224, 349, 359, 32);
		contentPane.add(textField_3);

		JButton btnChn = new JButton("Chọn");
		btnChn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				int returnVal = jfc.showSaveDialog(RemoteClient.this);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File file = jfc.getSelectedFile();
					textField_3.setText(file.getAbsolutePath());
				}
			}
		});
		btnChn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChn.setBounds(611, 347, 105, 32);
		contentPane.add(btnChn);

		JButton btnChpMnHnh = new JButton("Chụp màn hình");
		btnChpMnHnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkClientStatusOn()) {
					String vitriluu = textField_3.getText();
					client.capture(vitriluu);
				} else {
					JOptionPane.showMessageDialog(RemoteClient.this, "Hiện không tồn tại kết nối!!!");
				}
			}
		});
		btnChpMnHnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChpMnHnh.setBounds(284, 392, 172, 32);
		contentPane.add(btnChpMnHnh);
	}
	
	private boolean checkClientStatusOn(){
		return client != null && client.sk != null;
	}
}
