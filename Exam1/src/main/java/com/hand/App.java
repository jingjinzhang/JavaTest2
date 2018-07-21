package com.hand;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;

public class App {
	public static void main(String[] args) {
		download();
	}

	public static void download() {



		try {
			URL url = new URL("http://192.168.11.205:18080/trainning/SampleChapter1.pdf");
			URLConnection conn = url.openConnection();

			File file = new File("Exam1/temp/SampleChapter1.pdf");
			if(file.exists()){
				file.delete();
			}
			BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(file));
			byte[] bytes = new byte[10000];
			int count = 0;
			while ((count = bis.read(bytes)) != -1) {
				bos.write(bytes,0,count);
			}

			bos.close();
			bis.close();
			System.out.println("下载成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
