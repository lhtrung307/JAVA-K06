package stringmethods;

import java.util.*;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date(){
		this.setDay(1);
		this.setMonth(1);
		this.setYear(1900);
	}
	
	public Date(int day, int month, int year){
		if(day >= 1 && day <= 31)
			this.setDay(day);
		if(month >= 1 && month <= 12)
			this.setMonth(month);
		if(year >= 1900 && month <= 9999)
			this.setYear(year);
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public void setDate(int day, int month, int year){
		if(day >= 1 && day <= 31)
			this.setDay(day);
		if(month >= 1 && month <= 12)
			this.setMonth(month);
		if(year >= 1900 && year <= 9999)
			this.setYear(year);
	}
	
	public String toString(){
		return String.format("Day %02d Month %02d Year %04d", day, month, year);
	}

	public static void main(String[] args) {
		int day = 0;
		int month = 0;
		int year = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap ngay: ");
		day = input.nextInt();
		System.out.println("Nhap thang: ");
		month = input.nextInt();
		System.out.println("Nhap nam: ");
		year = input.nextInt();
		Date date = new Date(day, month, year);
		System.out.println(date);
		System.out.println();
		input.close();
	}
}