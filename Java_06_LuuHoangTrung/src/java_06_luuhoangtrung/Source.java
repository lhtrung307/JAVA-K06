package java_06_luuhoangtrung;

public class Source {

	public static void main(String[] args) {
		SinhVien sinhVien = new SinhVien("0123", "Lưu Hoàng", "Trung", new Ngay(30, 07, 1997), 7.5, new Lop("Java K06", "CNTT"));
		System.out.println(sinhVien);
		if(sinhVien.ktDau()){
			System.out.println("Sinh viên " + sinhVien.getTen() + " đậu rồi!!!");
		} else{
			System.out.println("Sinh viên " + sinhVien.getTen() + " rớt rồi!!!");
		}
		
		System.out.println("Sinh viên " + sinhVien.getTen() + " thuộc khoa: " + sinhVien.getTenKhoa());
		SinhVien sinhVien1 = new SinhVien("01234", "Phạm Thị Thùy", "Trang", new Ngay(30, 07, 1997), 8.5, new Lop("Java K06", "CNTT"));
		System.out.println(sinhVien1);
		if(sinhVien.ktNgaySinh(sinhVien1)){
			System.out.println("Hai sinh viên " + sinhVien.getTen() + " " + sinhVien1.getTen() + " trùng ngày sinh.");
		} else{
			System.out.println("Hai sinh viên " + sinhVien.getTen() + " " + sinhVien1.getTen() + " không trùng ngày sinh.");
		}
	}

}
