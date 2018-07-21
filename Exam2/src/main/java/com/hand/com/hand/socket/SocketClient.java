package com.hand.com.hand.socket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClient extends Thread{

	public static void main(String[] args) {
		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(12345));
			BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(
							new File("Exam2/temp/SampleChapter1.pdf")));
			byte[] bytes = new byte[10000];
			int count;
			while(bis.available() != 0){
				count = bis.read(bytes);
				bos.write(bytes,0,count);
			}
			bos.close();
			bis.close();
			System.out.println("读取成功！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
