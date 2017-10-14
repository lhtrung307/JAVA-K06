package model;

public class TinhThanh {
	private int maTinh;
	private String tenTinh;
	
	public TinhThanh(){
		
	}
	
	public TinhThanh(int maTinh, String tenTinh) {
		this.maTinh = maTinh;
		this.tenTinh = tenTinh;
	}

	public int getMaTinh() {
		return maTinh;
	}

	public void setMaTinh(int maTinh) {
		this.maTinh = maTinh;
	}

	public String getTenTinh() {
		return tenTinh;
	}

	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}

	@Override
	public String toString() {
		return "TinhThanh [maTinh=" + maTinh + ", tenTinh=" + tenTinh + "]";
	}
	
}
