package com.cao.common;

//数值转换为字符串
public class NumToStringDemo {

	public NumToStringDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1.整数转换为字符串
		String age = Integer.toString(23);

		System.out.println("age: " + age);

		// 2.float ->String
		float salary = 8999.99f;
		String outSalary = Float.toString(salary);
		System.out.println("salary: " + salary);

		// 3.double -> String

		double second = 2026.88;
		String outSecond = Double.toString(second);
		System.out.println("second: " + outSecond);
	}

}
