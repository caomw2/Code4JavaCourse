package com.cao.time;

import java.util.Calendar;
import java.util.Date;

public class UseCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar calendar = Calendar.getInstance();

		Date time = calendar.getTime();

		System.out.println("Current time is: " + time);
		System.out.println(calendar.getTimeZone());

	}

}
