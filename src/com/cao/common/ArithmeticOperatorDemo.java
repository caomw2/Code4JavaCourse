/**
 * 使用算术运算符，+，-，*，/，%
 */
package com.cao.common;

/**
 * 
 */
public class ArithmeticOperatorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 15;
		int b = 4;

		// 1.加法运算
		int sum = a + b;
		System.out.println("a+b = " + sum);

		// 2.减法运算
		int minus = a - b;
		System.out.println("a-b = " + minus);

		// 3.乘法运算
		int multipl = a * b;
		System.out.println("a * b = " + multipl);

		// 4.除法运算
		float quotient = a / b;
		System.out.println("a/b = " + quotient);

		quotient = a / 4.0f;
		System.out.println("a/4.0f = " + quotient);

		// 5.余数运算
		int remainder = a % b;
		System.out.println("a%b = " + remainder);

	}

}
