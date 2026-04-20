package com.cao.chapter3;

import java.util.Scanner;

public class ComputeArea2 {

	public static void main(String[] args) {
		double radius; // Declare radius double area; // Declare area

		System.out.println("Enter a number.");

		Scanner input = new Scanner(System.in);

		radius = input.nextDouble();

		if (radius > 0) {

			// Compute area
			double area = radius * radius * 3.14159;
			// Display results
			System.out.println("The area for the circle" + " of radius " + radius + " is " + area);
		} else {

			System.out.println("Negative input.");
		}

	}
}
