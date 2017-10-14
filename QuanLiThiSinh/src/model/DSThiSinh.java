package model;

import java.util.ArrayList;

public class DSThiSinh {
	private ArrayList<ThiSinh> dsThiSinh;

	public DSThiSinh(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}

	public ArrayList<ThiSinh> getDsThiSinh() {
		return dsThiSinh;
	}

	public void setDsThiSinh(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}
	
	public void printDSThiSinh(){
		for (ThiSinh thiSinh : dsThiSinh) {
			System.out.println(thiSinh);
		}
	}
}
