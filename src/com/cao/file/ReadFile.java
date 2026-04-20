/**
 * 使用Scanner读取文件信息
 */
package com.cao.file;

import java.io.File;
import java.util.Scanner;

/**
 * 
 */
public class ReadFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			String path = System.getProperty("user.dir");

			File file = new File(path + "/data/nihao.txt");
			Scanner readFile = new Scanner(file);

			while (readFile.hasNextLine()) {

				String strLine = readFile.nextLine();
				System.out.println(strLine);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

	}
}
