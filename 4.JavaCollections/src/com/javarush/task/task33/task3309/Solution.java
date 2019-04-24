package com.javarush.task.task33.task3309;

import org.w3c.dom.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        StringWriter stringWriter = new StringWriter();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.newDocument();


/*	        Element documentElement = document.getDocumentElement();
	        Comment comment1 = document.createComment(comment);
	        NodeList nodeList = documentElement.getElementsByTagName(tagName);
	        for (int i = 0; i < nodeList.getLength(); i++) {
		        nodeList.item(i).insertBefore(comment1, nodeList.item(i));
	        }*/

	        JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            marshaller.marshal(obj, stringWriter);

        } catch (JAXBException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        return stringWriter.toString();
    }

    public static void main(String[] args) {
        System.out.println(toXmlWithComment(new Ex(), "strings", "This is a comment"));
    }
}


