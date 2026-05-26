/**
 * 字符串的常用方法
 * 更多使用方法请见：https://www.w3cschool.cn/java/java-string.html
 */
package com.cao.common;

import java.util.StringTokenizer;

/**
 * 
 */
public class UseStringDemo {

	/**
	 * 
	 */
	public UseStringDemo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "Welcome to ";

		String str2 = "China";

		// 1.字符串的长度
		int length = str1.length();
		System.out.println(length);

		// 2.连接两个字符串
		String welcome = str1 + str2;
		System.out.println(welcome);

		// 3.取子串,下标从2开始的子串
		String subStr = welcome.substring(2);// lcome to China
		System.out.println(subStr);

		// 3.取子串,范围子串[1,5),4个字符
		String rangeStr = welcome.substring(1, 5);
		System.out.println(rangeStr);

		// 4.取第2个字符,下标从0开始
		char ch = welcome.charAt(2 - 1);// e
		System.out.println(ch);

		// 5.分割字符串
		String[] strList = welcome.split(" ");

		for (String str : strList) {

			System.out.println(str);

		}

		// 6.使用StringTokenizer分割字符串
		StringTokenizer tokenizer = new StringTokenizer(welcome);

		while (tokenizer.hasMoreElements()) {
			String object = tokenizer.nextToken();
			System.out.println(object);

		}

		// 7.判断两个字符串的内容是否相等

		String name1 = "张三";
		String name2 = "王五";

		if (name1.equals(name2)) {
			System.out.println("name1与name2的内容相同.");
		} else {
			System.out.println("name1与name2的内容不相同.");
		}

		// 8.连接两个字符串
		String name = name1.concat(name2);
		System.out.println("name: " + name);

	}

}
