/**
 * 
 */
package com.cao.time;

import java.util.Date;

/**
 * 
 */
public class UseDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 第一种方式
		long timeNumber = System.currentTimeMillis();
		Date time = new Date(timeNumber);
		System.out.println(time);

	}

}
