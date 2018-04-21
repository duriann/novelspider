package daily_20170822;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImageTest2 {
	public static void main(String[] args) throws Exception {
		BufferedImage removeBackgroud = removeBackgroud("D://test2.jpg");
		ImageIO.write(removeBackgroud, "jpg", new File("D://test3.jpg"));
	}
	
	 
	  
	 
	 public static BufferedImage removeBackgroud(String picFile)  
	            throws Exception {  
	        BufferedImage img = ImageIO.read(new File(picFile));  
	        int width = img.getWidth();  
	        int height = img.getHeight();
	        System.out.println("width:"+width);
	        System.out.println("height:"+height);
	        for (int x = 1; x < width - 1; ++x) {  
	            for (int y = 1; y < height - 1; ++y) { 
	            	if (getColorBright(img.getRGB(x, y)) < 100) { 
		            	System.out.println(getColorBright(img.getRGB(x, y)));

	                    if (isBlackOrWhite(img.getRGB( (x - 2), y))  
	                            + isBlackOrWhite(img.getRGB( (x + 2), y))  
	                            + isBlackOrWhite(img.getRGB(x,  (y - 2)))  
	                            + isBlackOrWhite(img.getRGB(x,  (y + 1))) == 4) { 
	                    	System.out.println("干扰点"+"x:"+x+" y:"+y);
	                        img.setRGB(x, y, Color.WHITE.getRGB());  
	                    }  
	                }  
	            }  
	        }  
	        for (int x = 1; x < width - 1; ++x) {  
	            for (int y = 1; y < height - 1; ++y) { 
	            	if (getColorBright(img.getRGB(x, y)) < 100) { 
		            	System.out.println(getColorBright(img.getRGB(x, y)));

	                    if (isBlackOrWhite(img.getRGB( (x - 2), y))  
	                            + isBlackOrWhite(img.getRGB( (x + 2), y))  
	                            + isBlackOrWhite(img.getRGB(x,  (y - 2)))  
	                            + isBlackOrWhite(img.getRGB(x,  (y + 1))) == 4) { 
	                    	System.out.println("干扰点"+"x:"+x+" y:"+y);
	                        img.setRGB(x, y, Color.WHITE.getRGB());  
	                    }  
	                }  
	            }  
	        } 
	        for (int x = 1; x < width - 1; ++x) {  
	            for (int y = 1; y < height - 1; ++y) { 
	            	if (getColorBright(img.getRGB(x, y)) < 100) { 
		            	System.out.println(getColorBright(img.getRGB(x, y)));

	                    if (isBlackOrWhite(img.getRGB( (x - 1), y))  
	                            + isBlackOrWhite(img.getRGB( (x + 1), y))  
	                             
	                            + isBlackOrWhite(img.getRGB(x,  (y + 1))) == 3) { 
	                    	System.out.println("干扰点"+"x:"+x+" y:"+y);
	                        img.setRGB(x, y, Color.WHITE.getRGB());  
	                    }  
	                }  
	            }  
	        }  
	        
//	        for (int x = 1; x < width - 1; ++x) {  
//	            for (int y = 1; y < height - 1; ++y) {  
//	                if (img.getRGB(x, y) ==  Color.black.getRGB()) {
//	                	System.out.println("aa");
//	                    if (img.getRGB(x - 1, y)== img.getRGB(x + 1, y)
//	                              
//	                          && img.getRGB(x, y - 1)==  
//	                           img.getRGB(x, y + 1)) {  
//	                        img.setRGB(x, y, Color.WHITE.getRGB());  
//	                    }  
//	                }  
//	            }  
//	        }  
	        img = img.getSubimage(1, 1, img.getWidth() - 2, img.getHeight() - 2);  
	        return img;  
	    }  
	 public static int getColorBright(int colorInt) {  
	        Color color = new Color(colorInt);  
	        return color.getRed() + color.getGreen() + color.getBlue();  
	  
	    }  
	  
	    public static int isBlackOrWhite(int colorInt) {  
	        if ( getColorBright(colorInt) >500) {  
	            return 1;  
	        }  
	        return 0;  
	    }  
  
}
