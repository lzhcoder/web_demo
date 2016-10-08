package com.servlet;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestStream extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TestStream() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	    doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
//		 //创建一个新的URL实例url
//		 URL url = new URL("http://localhost/uploadFile/replaceFile");
//		 //根据url建立连接
//		 URLConnection con = url.openConnection();
//		 
//		 //设置该连接可写
//		 con.setDoOutput(true);
//		 //禁用cache
//		 con.setUseCaches(false);
//		 OutputStream outs=con.getOutputStream();
//      	
//         URL u = new URL("http://localhost/uploadFile/get?id=123");
//         ByteArrayOutputStream os=new ByteArrayOutputStream();
//         BufferedImage imageOrigin = ImageIO.read(u);
//          
//         ImageIO.write(imageOrigin, "png", os); //利用ImageIO类提供的write方法，将bi以png图片的数据模式写入流。
//         byte b[]=os.toByteArray();
//         outs.write(b);
//         outs.close();
//         
//         url.openStream();
         
		
		 URL url = new URL("http://localhost/uploadFile/replaceFile?id=203");
         HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
         // 发送POST请求必须设置如下两行  

         conn.setDoOutput(true);  
         conn.setUseCaches(false);  
         conn.setRequestMethod("POST");  
         conn.setRequestProperty("Content-Type","text/html");  
         conn.setRequestProperty("Cache-Control","no-cache");  
         conn.setRequestProperty("Charsert", "UTF-8");   
         conn.connect();  
         conn.setConnectTimeout(10000);  
         OutputStream out =conn.getOutputStream();  

         URL u = new URL("http://localhost/uploadFile/get?id=123");
         ByteArrayOutputStream os=new ByteArrayOutputStream();
         BufferedImage imageOrigin = ImageIO.read(u);
        
         ImageIO.write(imageOrigin, "png", os); //利用ImageIO类提供的write方法，将bi以png图片的数据模式写入流。
         byte b[]=os.toByteArray();
 
         ByteArrayInputStream in   = new ByteArrayInputStream(b); 

         int bytes = 0;  
         byte[] buffer = new byte[1024];  
         while ((bytes = in.read(buffer)) != -1) {  
             out.write(buffer, 0, bytes);  
         }  
         in.close();  
         out.flush();  
         out.close();   
    
         conn.getInputStream();  
         conn.disconnect();  
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
