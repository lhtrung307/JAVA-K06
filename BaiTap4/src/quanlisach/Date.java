package quanlisach;

public class Date {

	public Date() {
	}

	private int day;
	private int month;
	private int year;


	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if(day > 0 && day <= 31){
			this.day = day;
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if(month > 0 && month <= 12){
			this.month = month;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Date(int day, int month, int year) {
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
	}

	public String toString() {
		return "";
	}

}