/**
 *使用Files类读取文件信息
 */
package com.cao.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * 
 */
public class ReadFile2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			String path = System.getProperty("user.dir") + "/data/nihao.txt";

			List<String> lines = Files.readAllLines(Paths.get(path));

			for (String line : lines) {
				// 处理每行数据
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
