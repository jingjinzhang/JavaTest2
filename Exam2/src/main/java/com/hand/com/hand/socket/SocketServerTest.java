package com.hand.com.hand.socket;


import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest{

	public static void transform(Socket socket){
		File file = new File("Exam2/SampleChapter1.pdf");
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
			byte[] bytes = new byte[10000];
			while (bis.read(bytes) == -1){
				bos.write(bytes);
				System.out.println(new String(bytes));
			}
			bos.close();
			bis.close();
			System.out.println("发送成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(12345);
			Socket socket = serverSocket.accept();
			JOptionPane.showMessageDialog(null,"有客服端连接了12345端口");
			if(socket.isConnected()){
				transform(socket);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
