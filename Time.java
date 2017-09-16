
public class Time{
	private int hour;
	private int minute;
	private int second;

	public void setTime(int hour, int minute, int second){
		this.hour = ((hour >= 0 && hour < 24) ? hour : 0);
		this.minute = ((minute >= 0 && minute < 60) ? minute : 0);
		this.second = ((second >= 0 && second < 60) ? second : 0);
	}

	public String toMilitary(){
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}

	public String toString(){
		return String.format("%d:%02d:%02d %s", ((hour == 0 || hour == 12) ? 12 : hour % 12), minute, second, (hour < 12 ? "AM" : "PM"));
	}
}