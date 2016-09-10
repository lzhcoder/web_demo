package com.pic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class MergeVipImage {
	
	public static void main(String[] args){
        try {
            
          
                    InputStream imagein=new FileInputStream("D:\\logo.jpg");
                    InputStream imagein2=new FileInputStream("D:\\cc.jpg");

                    BufferedImage image=ImageIO.read(imagein);
                    BufferedImage image2=ImageIO.read(imagein2);
                    Graphics g=image.getGraphics();
                    g.drawImage(image2,image.getWidth()-image2.getWidth()-100,image.getHeight()-image2.getHeight()-100,image2.getWidth(),image2.getHeight(),null);
                    OutputStream outImage=new FileOutputStream("D:\\systemAvatar.jpg");
                    JPEGImageEncoder enc=JPEGCodec.createJPEGEncoder(outImage);
                    enc.encode(image);
                    imagein.close();
                    imagein2.close();
                    outImage.close();
              
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    
   }
}
