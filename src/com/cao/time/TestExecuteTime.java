/**
 * 
 */
package com.cao.time;

/**
 * 
 */
public class TestExecuteTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long startTime = System.currentTimeMillis();// 开始时间
		for (int i = 0; i < 100000; i++) {

			System.out.println("i= " + i);
		}

		long endTime = System.currentTimeMillis();// 结束时间

		// 执行时间
		long executeTime = endTime - startTime;

		System.out.println("execute time is " + executeTime + " ms");

	}

}
