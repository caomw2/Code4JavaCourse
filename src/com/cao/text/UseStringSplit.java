/**
 * 使用String类中的split函数分割字符串。
 */
package com.cao.text;

/**
 * 
 */
public class UseStringSplit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "Welcome to China.";

		String[] list = text.split(" ");

		for (String word : list) {

			System.out.println(word);

		}
	}

}
