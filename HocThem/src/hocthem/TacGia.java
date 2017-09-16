package hocthem;

public class TacGia {
	
	private String ten;
	private Ngay ngaySinh;
	
	public TacGia() {}

	public TacGia(String ten, Ngay ngaySinh) {
		this.ten = ten;
		this.ngaySinh = ngaySinh;
	}
	
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Ngay getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Ngay ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
	
}
