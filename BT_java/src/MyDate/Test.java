package MyDate;

public class Test {
	public static void main (String[] args) {
		MyDate md = new MyDate(30,6,2023);
		md.setDay(23);
		System.out.println("Day = "+ md.getDay());
	}
}
