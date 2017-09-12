package com.kyj.common.utils;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.kyj.common.exception.XMLValidateException;

public class XMLUtil {
	
	public static void validateXML(Reader target, String validateFilePath) throws XMLValidateException {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		URL valiedateFileUrl = Thread.currentThread().getContextClassLoader().getResource(validateFilePath);
		Schema schema;
		try {
			schema = schemaFactory.newSchema(valiedateFileUrl);
			Validator validator = schema.newValidator();
			StreamSource ss = new StreamSource(target);
			validator.validate(ss);
		} catch (SAXException | IOException e) {
			System.out.println(e.getMessage());
			throw new XMLValidateException("文件内容校验错误", e);
		}
		
	}
	
	public static boolean isTagEnd(StringBuffer path,String tagName,XMLEvent event){
		boolean isEnd = false;
		if (event.isEndElement()){
			if(null!=tagName){
			EndElement end = event.asEndElement();
			isEnd = end.getName().getLocalPart().equalsIgnoreCase(tagName);
			}
		}
		return isEnd;
	}
	
	public static void startElement(StringBuffer path,XMLEvent event){
		if(event.isStartElement()){
		StartElement startElement = event.asStartElement();
		path.append("/").append(startElement.getName().getLocalPart());
		}
	}
	
	public static void endElement(StringBuffer path,XMLEvent event){
		if (event.isEndElement())
			path.delete(path.lastIndexOf("/"), path.length());
	}
	
	public static boolean endElement(StringBuffer path,String tagName,XMLEvent event){
		boolean isEnd = false;
		if (event.isEndElement()){
			if(null!=tagName){
			EndElement end = event.asEndElement();
			isEnd = end.getName().getLocalPart().equalsIgnoreCase(tagName);
			}
			path.delete(path.lastIndexOf("/"), path.length());
		}
		return isEnd;
	}
	
	public static String getContent(StringBuffer path,String nodePath,XMLEvent event){
		if (event.isCharacters()) {
			if (path.toString().equalsIgnoreCase(nodePath))
			 {
				Characters text = event.asCharacters();
				if (!text.isWhiteSpace()) {
					return text.getData();
				}
			}
		}
		return null;
	}
	
	public static Map<String,String> getAttributes(StringBuffer path,String nodePath,XMLEvent event) throws Exception{
		Map<String,String> attrMap = null;
		if (event.isStartElement()) {
			StartElement startElement = event.asStartElement();
			if (path.toString().equals(nodePath)) {
				@SuppressWarnings("unchecked")
				Iterator<Attribute> it= startElement.getAttributes();
				if(null!=it)
				while(it.hasNext()){
					Attribute attr = it.next();
					if(null==attrMap)
						attrMap = new HashMap<String, String>();
					attrMap.put(attr.getName().getLocalPart(),attr.getValue());
				}
			}
		}
		return attrMap;
	}
	
	
}
