package model;

import java.util.ArrayList;

public class DSTinhThanh {
	private ArrayList<TinhThanh> dsTinhThanh;

	public DSTinhThanh(ArrayList<TinhThanh> dsTinhThanh) {
		this.dsTinhThanh = dsTinhThanh;
	}

	public ArrayList<TinhThanh> getDsTinhThanh() {
		return dsTinhThanh;
	}

	public void setDsTinhThanh(ArrayList<TinhThanh> dsTinhThanh) {
		this.dsTinhThanh = dsTinhThanh;
	}

	public void printDSTinhThanh(){
		for (TinhThanh tinhThanh : dsTinhThanh) {
			System.out.println(tinhThanh);
		}
	}
	
	
}
