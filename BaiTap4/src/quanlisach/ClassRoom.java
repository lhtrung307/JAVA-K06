package quanlisach;

public class ClassRoom {
	String name;
	String industryName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	
	public ClassRoom(){}
	
	public ClassRoom(String name, String industryName){
		this.setName(name);
		this.setIndustryName(industryName);
	}
}
