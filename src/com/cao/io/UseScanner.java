/**
 * 
 */
package com.cao.io;

import java.util.Scanner;

/**
 * 
 */
public class UseScanner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("use scanner.");
		System.out.println("Enter a number.");

		Scanner input = new Scanner(System.in);

		double num = input.nextDouble();
		System.out.println(num);

	}

}
