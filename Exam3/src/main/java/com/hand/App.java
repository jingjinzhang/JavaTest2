package com.hand;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class App {
	public static void main(String[] args) {

		System.out.println("[INFO] 股票编码："+601006);
		System.out.println("[INFO] 开始获取数据。。。。。。");
		String str = "";
		try {
			URL url = new URL("http://hq.sinajs.cn/list=sh"+601006);
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);

			byte[] bytes = new byte[1000];
			int count = 0;
			while ((count = bis.read(bytes)) != -1) {

				str = new String(bytes, 0, count, "UTF-8");
				 //System.out.print(str);
			}
			bis.close();
			is.close();
			System.out.println("[INFO] 解析数据成功!");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] strs = str.split(",");
		strs[0] = strs[0].split("\"")[1];
		strs[0] = strs[0].substring(0, strs[0].length() - 1);

		System.out.println();
		new JSON(strs).start();
		new XML(strs).start();
	}
}
