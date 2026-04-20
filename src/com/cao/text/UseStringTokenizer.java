/**
 *使用StringTokenizer分割字符串
 */
package com.cao.text;

import java.util.StringTokenizer;

/**
 * 
 */
public class UseStringTokenizer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "Welcome to China.";
		StringTokenizer tokenizer = new StringTokenizer(text);
		while (tokenizer.hasMoreTokens()) {

			String str = tokenizer.nextToken();
			System.out.println(str);
		}

	}

}
