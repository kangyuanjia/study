package com.kyj.common.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

public class StreamHandler {
	
	//输入流转字符串
	public static StringBuffer stream2str(InputStream in){
		 InputStreamReader reader = null;
		 BufferedReader br = null;
		 StringBuffer xmlContent = new StringBuffer();
	     try {
			reader = new InputStreamReader(in,"UTF-8");
			br=new BufferedReader(reader);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
	     try {
	    	 String str = null;
			while ((str=br.readLine())!=null) {
			     str=str.replaceAll("[\n\r]","").trim();
			     if(str.length()>0&&str.charAt(0)!='<')
			    	 xmlContent.append(" ");
			     xmlContent.append(str);
			 }
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally{
		   try {
			br.close();
			reader.close();
			in.close();
		   } catch (IOException e) {
			 e.printStackTrace();
		   }
		}
	     return xmlContent;
	}
	
	//字符串转Reader
	public static Reader str2reader(StringBuffer str){
		 if (str != null && !str.equals("")) { 
		        try { 
		            StringReader stringReader = new StringReader(str.toString()); 
		            return stringReader; 
		        } catch (Exception e) { 
		            e.printStackTrace(); 
		        } 
		    } 
		    return null; 
	}
	
	//字符串转输入流
	public static InputStream str2stream(StringBuffer str){
		 if (str != null && !str.equals("")) { 
		        try { 
		            ByteArrayInputStream stringInputStream = new ByteArrayInputStream(str.toString().getBytes("UTF-8")); 
		            return stringInputStream; 
		        } catch (Exception e) {
		            e.printStackTrace(); 
		        } 
		    } 
		    return null; 
	}
	
	//ByteArrayOutputStream转FileOutputStream
	public static FileOutputStream byte2file(ByteArrayOutputStream bos,String filePath){
		FileOutputStream fos = null;
		try {
			fos =new FileOutputStream(new File(filePath));
		    bos.writeTo(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				bos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fos;
	}
}
