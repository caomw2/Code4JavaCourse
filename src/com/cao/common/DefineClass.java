/**
 * 如何使用类
 */
package com.cao.common;

/**
 * 
 */
public class DefineClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1.第一种使用方式
		Person person = new Person();

		person.setName("张三");
		person.setSex("男");
		person.setAge(35);

		System.out.println("姓名: " + person.getName() + ", 性别: " + person.getSex() + ", 年龄: " + person.getAge());

		// 2.第二种使用方式
		Person pers = new Person("李四", "女", 28);
		System.out.println("姓名: " + pers.getName() + ", 性别: " + pers.getSex() + ", 年龄: " + pers.getAge());

	}

}
