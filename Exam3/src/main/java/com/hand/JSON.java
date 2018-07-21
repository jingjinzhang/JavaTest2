package com.hand;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;

public class JSON extends Thread {

	String[] strs;
	public JSON(String[] strs){
		this.strs = strs;
	}
	@Override
	public void run() {
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name",strs[0]);
		jsonObject.addProperty("open",strs[1]);
		jsonObject.addProperty("close",strs[2]);
		jsonObject.addProperty("current",strs[3]);
		jsonObject.addProperty("high",strs[4]);
		jsonObject.addProperty("low",strs[5]);

		File file = new File("Exam3/temp/股票编码.json");
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
			FileWriter fw = new FileWriter(file,true);
			fw.append(jsonObject.toString());
			fw.flush();
//			pw.append(jsonObject.toString());
//			pw.flush();
			System.out.println("[INFO] 解析为json成功！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
