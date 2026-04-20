/**
 * 
 */
package com.cao.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 */
public class UseSimpleDateFormat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = dateFormat.format(new Date());

		System.out.println(currentTime);

	}

}
