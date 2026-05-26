/**
 * 格式化输出
 */
package com.cao.common;

/**
 * 
 */
public class OutputFormat {

	/**
	 * 
	 */
	public OutputFormat() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int age = 25;

		String name = "张三";

		float high = 180;// cm

		double weight = 70;// 70kg

		boolean flag = true;

		char ch = 'a';

		System.out.printf("%s\t%d\t%f\t%f\t%c\t%b", name, age, high, weight, ch, flag);

	}

}
