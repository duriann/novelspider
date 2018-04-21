package daily_20170822;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageTest {
	public static void main(String[] args) throws Exception {
		BufferedImage removeBackgroud = removeBackground("D://1.jpg");
		ImageIO.write(removeBackgroud, "jpg", new File("D://test.jpg"));
	}
	public static BufferedImage removeBackground(String picSrc) throws Exception{
		BufferedImage bufimg = ImageIO.read(new File(picSrc));
		for(int x = 0;x<bufimg.getWidth();x++){
			for(int y =0;y<bufimg.getHeight();y++){
				if(isWhite(bufimg.getRGB(x, y))==1){
					bufimg.setRGB(x, y, Color.white.getRGB());
				}else {
					bufimg.setRGB(x, y, Color.black.getRGB());
				}
			}
		}
		return bufimg;
	}
	public static int isWhite(int colorInt) {  
        Color color = new Color(colorInt);  
        if (color.getRed() + color.getGreen() + color.getBlue() > 300) {  
            return 1;  
        }  
        return 0;  
    }  
  
    public static int isBlack(int colorInt) {  
        Color color = new Color(colorInt);  
        if (color.getRed() + color.getGreen() + color.getBlue() <= 100) {  
            return 1;  
        }  
        return 0;  
    }  
}
