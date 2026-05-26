/**
 * 数值型字符串转换为数值
 */
package com.cao.common;

/**
 * 
 */
public class StringToNumDemo {

	/**
	 * 
	 */
	public StringToNumDemo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1.String->int
		String intString = "888";
		System.out.println(Integer.valueOf(intString));

		String number = "999.99";

		// 2.String ->float
		System.out.println(Float.valueOf(number));

		// 3.String ->double
		System.out.println(Double.valueOf(number));

	}

}
