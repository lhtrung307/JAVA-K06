package quanlisach;

public class Student {
	private String id;
	private String fullName;
	private Date dOB;
	private double gpa;
	private ClassRoom classRoom;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getdOB() {
		return dOB;
	}
	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public ClassRoom getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}
	
	public Student(){
		this.dOB = new Date();
		this.classRoom = new ClassRoom();
	}
	
	public Student(String id, String fullName, Date dOB, double gpa, ClassRoom classRoom){
		this.setId(id);
		this.setFullName(fullName);
		this.setdOB(dOB);
		this.setGpa(gpa);
		this.setClassRoom(classRoom);
	}
	
	public String getIndustryName(){
		return this.getClassRoom().getIndustryName();
	}
	
	public boolean isGraduate(){
		return this.getGpa() >= 5.0;
	}
	
	public boolean isSameDOB(Student anotherStudent){
		return this.getdOB().getDay() == anotherStudent.getdOB().getDay();
	}
}
