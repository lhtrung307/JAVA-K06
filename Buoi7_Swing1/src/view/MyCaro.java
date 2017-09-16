package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyCaro extends JFrame implements ActionListener {

	JButton[][] banCo = new JButton[10][10];
	int turn = 0;
	int[][] matrix = new int[10][10];

	public MyCaro() {
		this.setTitle("My Caro v 1.0");

		this.setLayout(new GridLayout(10, 10));

		for (int column = 0; column < 10; column++) {
			for (int row = 0; row < banCo.length; row++) {
				banCo[column][row] = new JButton();
				banCo[column][row].setToolTipText(column + " " + row);
				banCo[column][row].addActionListener(this);
				banCo[column][row].setBackground(Color.WHITE);
				this.add(banCo[column][row]);
			}
		}
		
		this.createPanel();

		// Size of window
		this.setSize(800, 600);
		// Show window
		this.setVisible(true);
	}
	
	private void createPanel(){
		JPanel panelGraphics = new JPanel(new BorderLayout());
//		panelGraphics.setBorder();
		this.add(panelGraphics);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		System.out.println(b.getToolTipText());
		b.setEnabled(false);
		
		//Cat chuoi
		String s = b.getToolTipText();
		String[] coordinates = s.split(" ");
		int column = Integer.parseInt(coordinates[0]);
		int row = Integer.parseInt(coordinates[1]);
		String player = "";
		
		//Cat chuoi cach 2
//		char[] vitri = b.getToolTipText().toCharArray();
//		int i = vitri[0] & 0x0F;
//		int j = vitri[2] & 0x0F;
		if ((turn & 1) == 0) {
			b.setText("X");
			b.setBackground(Color.GREEN);
			player = "X";
		} else {
			b.setText("O");
			b.setBackground(Color.YELLOW);
			player = "O";
		}
		turn++;
		
		if(checkWin(row, column) == 1){
			JOptionPane.showMessageDialog(this, player + " da thang!!!");
			endGame();
		}
	}
	
	private int checkWin(int row, int col) {
		int[][] rc = { { 0, -1, 0, 1 }, { -1, 0, 1, 0 }, { 1, -1, -1, 1 },
				{ -1, -1, 1, 1 } };
		
		int i = row, j = col;
		for (int direction = 0; direction < 4; direction++) {
			int count = 0;
			System.out.println("[" + direction + "]-" + "[" + row + "," + col
					+ "]  ");

			i = row;
			j = col;
			while (i > 0 && i < matrix.length && j > 0 && j < matrix.length
					&& matrix[i][j] == matrix[row][col]) {
				count++;
				if (count == 5) {
					return matrix[row][col];
				}
				System.out.print("\t[" + i + "," + j + "]  ");
				i += rc[direction][0];
				j += rc[direction][1];
				System.out.println("--->[" + i + "," + j + "]  ");
			}
			System.out.println("\tcount1 : " + count);

			count--;
			i = row;
			j = col;
			while (i > 0 && i < matrix.length && j > 0 && j < matrix.length
					&& matrix[i][j] == matrix[row][col]) {
				count++;
				if (count == 5) {
					System.out.println(matrix[row][col]);
					return matrix[row][col];
				}
				System.out.print("\t[" + i + "," + j + "]  ");
				i += rc[direction][2];
				j += rc[direction][3];
				System.out.println("--->[" + i + "," + j + "]  ");
			}
			System.out.println("\tcount : " + count);
		}
		return 0;
	}
//	public boolean kiemTraNgang(int column, int row, String player) {
//		int a = 0;
//		int k = column;
//		int l = row;
//		while (true) {
//			if (banCo[k][l].getText().equals(player)) {
//				a++;
//				l--;
//			} else {
//				break;
//			}
//			if(l < 0) {
//				break;
//			}
//		}
//		
//		l = row;
//		while (true) {
//			if (banCo[k][l].getText().equals(player)) {
//				a++;
//				l++;
//			} else {
//				break;
//			}
//			if(l >= 10) {
//				break;
//			}
//		}
//
//		return a >= 6;
//	}
//	
//	public boolean kiemTraDoc(int column, int row, String player){
//		int a = 0;
//		int k = column;
//		int l = row;
//		
//		while (true) {
//			if (banCo[k][l].getText().equals(player)) {
//				a++;
//				k--;
//			} else {
//				break;
//			}
//			if(k < 0) {
//				break;
//			}
//		}
//		
//		k = column;
//		while (true) {
//			if (banCo[k][l].getText().equals(player)) {
//				a++;
//				k++;
//			} else {
//				break;
//			}
//			if(k >= 10) {
//				break;
//			}
//		}
//		return a >= 6;
//	}
//	
//	public boolean kiemTraCheoPhu(int i, int j, String gt){
//		int a = 0;
//		int k = i;
//		int l = j;
//		
//		while (true) {
//			if (banCo[k][l].getText().equals(gt)) {
//				a++;
//				k--;
//				l++;
//			} else {
//				break;
//			}
//			if(k < 0 || l >= 10) {
//				break;
//			}
//		}
//		
//		k = i;
//		l = j;
//		while (true) {
//			if (banCo[k][l].getText().equals(gt)) {
//				a++;
//				k++;
//				l--;
//			} else {
//				break;
//			}
//			if(k >= 10 || l < 0) {
//				break;
//			}
//		}
//		return a >= 6;
//	}
//	
//	public boolean kiemTraCheoChinh(int i, int j, String gt){
//		int a = 0;
//		int k = i;
//		int l = j;
//		
//		while (true) {
//			if (banCo[k][l].getText().equals(gt)) {
//				a++;
//				k++;
//				l++;
//			} else {
//				break;
//			}
//			if(k >= 10 || l >= 10) {
//				break;
//			}
//		}
//		
//		k = i;
//		l = j;
//		while (true) {
//			if (banCo[k][l].getText().equals(gt)) {
//				a++;
//				k--;
//				l--;
//			} else {
//				break;
//			}
//			if(k < 0 || l < 0) {
//				break;
//			}
//		}
//		return a >= 6;
//	}
	
	public void endGame(){
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				banCo[i][j].setEnabled(false);
			}
		}
	}

}
