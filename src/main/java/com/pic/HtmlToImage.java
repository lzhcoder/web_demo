package com.pic;

import gui.ava.html.image.generator.HtmlImageGenerator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.util.HttpUtils;

public class HtmlToImage {
	 
	    public static void main(String[] args) {
	    	
	        try {
	        	
		    	HttpClient client =  new DefaultHttpClient();  
	            
		    	String html = HttpUtils.getHtml(client,"http://localhost/btkjsite_designcloud/before/kindeditorContent?designid=28");
	 
	            String outFileImagePath = "D:/Test.jpg";
	           
	            HtmlImageGenerator imageGenerator = new HtmlImageGenerator();

	   
	            
	            imageGenerator.loadHtml(html);
	            BufferedImage bi =   imageGenerator.getBufferedImage();
	            
	            Graphics graphics = bi.getGraphics();
	            graphics.setColor(Color.BLACK);
	            graphics.setXORMode(Color.BLACK);
	            
	            imageGenerator.saveAsImage(outFileImagePath);

	            
	           // imageGenerator.saveAsHtmlWithMap("hello-world.html", outFileImagePath);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
