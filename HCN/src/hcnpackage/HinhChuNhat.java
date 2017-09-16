package hcnpackage;

public class HinhChuNhat implements HCNInterface{
	private double chieuDai;
	private double chieuRong;
	

	public double dientichHCN() {
		return chieuDai * chieuRong;
	}

	public double getChieuDai() {
		return chieuDai;
	}

	public double getChieuRong() {
		return chieuRong;
	}

	public void setDaiRong(double chieuDai, double chieuRong) {
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}
	
	public String toString(){
		return String.format("Hinh chu nhat co chieu dai %f, chieu rong %f, dien tich %f", chieuDai, chieuRong, this.dientichHCN());
	}
}
