package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class QuanLySinhVien {
	public void luuMangSinhVien(SinhVien[] mang, String path) {
		File file = new File(path);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			OutputStream os = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			for (SinhVien sinhVien : mang) {
				oos.writeObject(sinhVien);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public SinhVien[] docMangSinhVien(String path) {
		SinhVien[] mangSinhVien = new SinhVien[100];
		File file = new File(path);
		try {
			if (!file.exists()) {
				System.out.println("File khong ton tai");
			}
			InputStream is = new FileInputStream(file);
			ObjectInputStream ios = new ObjectInputStream(is);
			int dem = 0;
			while(true){
				SinhVien sv = (SinhVien) ios.readObject();
				if(sv == null){
					break;
				}
				mangSinhVien[dem] = sv;
				System.out.println(sv.toString());
				dem++;
			}
			ios.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mangSinhVien;
	}
	
	public static void main(String[] args) {
		SinhVien sv1 = new SinhVien("01", "Nguyen Van A", true, 8.3);
		SinhVien sv2 = new SinhVien("02", "Nguyen Van B", true, 5.0);
		
		SinhVien[] sv = new SinhVien[]{sv1, sv2};
		SinhVien[] mang = new SinhVien[100];
		QuanLySinhVien quanLi = new QuanLySinhVien();
		
//		quanLi.luuMangSinhVien(sv, "E:\\zSinhVien.txt");
		mang = quanLi.docMangSinhVien("E:\\zSinhVien.txt");
	}
}
