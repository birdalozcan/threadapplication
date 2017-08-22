package com.application.thread;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class MyThread implements Runnable, Cloneable {
	
    private String filename;
    private ArrayList<Integer> numberarray = new ArrayList<Integer>();
    
    public Object clone() throws CloneNotSupportedException {
		return (Object) super.clone();
	}
    
    public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public ArrayList<Integer> getNumberarray() {
		return numberarray;
	}

	public void setNumberarray(ArrayList<Integer> numberarray) {
		this.numberarray = numberarray;
	}
    
    @Override
    public void run() {
		Functions.XmlBuilder(getNumberarray(), getFilename());
	}
}

public class Functions {
	
	ArrayList<Integer> createArray() {
		ArrayList<Integer> newarray = new ArrayList<Integer>();
		for (int i = 0; i < 1000; i++) {
			newarray.add((int)((Math.random()*1000000) + 1));
		}
		return newarray;
	}
	
	ArrayList<Integer> XmlParser (ArrayList<Integer> inputArray) {
		try {
	         DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = null;
	         for (File file : new File("C:/Users/birdal/Desktop/xmlfiles/").listFiles()) {
	        	 if (!file.getName().equals("sorted.xml")) {
	        		 doc = dBuilder.parse(file.getAbsolutePath());
		        	 doc.getDocumentElement().normalize();
			         NodeList nList = doc.getElementsByTagName("sayi");
			         for (int i = 0; i < nList.getLength(); i++) {
			            Node nNode = nList.item(i);
			            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			               Element eElement = (Element) nNode;
			               inputArray.add(Integer.parseInt(eElement.getTextContent()));
			            }
			         }
	        	 }
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		return inputArray;
	}
	
	static void XmlBuilder (ArrayList<Integer> inputArray, String filename) {
		try {
    		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    	    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    	    
    	    Document doc = docBuilder.newDocument();
    	    Element rootElement = doc.createElement("sayiList");
    	    doc.appendChild(rootElement);
    	    
    	    for (int i = 0; i < inputArray.size(); i++) {
    	    	Element sayi = doc.createElement("sayi");
    	    	rootElement.appendChild(sayi);
    	    	sayi.setAttribute("index", ""+(i+1));
    	    	sayi.appendChild(doc.createTextNode(""+inputArray.get(i)));
			}
    	    
    		TransformerFactory transformerFactory = TransformerFactory.newInstance();
    		Transformer transformer = transformerFactory.newTransformer();
			 
    	    DOMSource source = new DOMSource(doc);
    	    StreamResult result = new StreamResult(new File("C:/Users/birdal/Desktop/xmlfiles/" + filename));
    	    
    	    transformer.transform(source, result);
    	    
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}