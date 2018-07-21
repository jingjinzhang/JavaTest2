package com.hand;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;

public class XML extends Thread {

	String[] strs;
	public XML(String[] strs){
		this.strs = strs;
	}

	@Override
	public void run() {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
			Document document = db.newDocument();
			Element root = document.createElement("xml");

			Element stock = document.createElement("stock");
			Element name = document.createElement("name");
			name.setTextContent(strs[0]);

			Element open = document.createElement("open");
			open.setTextContent(strs[1]);

			Element close = document.createElement("close");
			close.setTextContent(strs[2]);

			Element current = document.createElement("current");
			current.setTextContent(strs[3]);

			Element high = document.createElement("high");
			high.setTextContent(strs[4]);

			Element low = document.createElement("low");
			low.setTextContent(strs[5]);

			stock.appendChild(name);
			stock.appendChild(open);
			stock.appendChild(close);
			stock.appendChild(current);
			stock.appendChild(high);
			stock.appendChild(low);

			root.appendChild(stock);
			document.appendChild(root);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StringWriter sw = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(sw));

			transformer.transform(new DOMSource(document), new StreamResult(new File("Exam3/temp/股票编码.xml")));
			System.out.println("[INFO] 解析为xml成功！");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
