package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test2 {

	public static void main(String[] args) {
		Date b = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(f.format(b));

		Calendar c = Calendar.getInstance();
	
		System.out.println(f.format(c.getTime()));

		c.add(Calendar.MONTH, 2);
		System.out.println(f.format(c.getTime()));
	}
}
