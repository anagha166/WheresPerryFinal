package imgs;
import java.awt.image.BufferedImage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class Level {
	private int x,y; //location attributes
	private Image img2; 	
	private AffineTransform tx;
	private BufferedImage color;
 
		
	//default constructor
	public Level() {
		img2 = getImage("/imgs/test.png");  //load the image
		tx = AffineTransform.getTranslateInstance(x,y);
		//initialize the location of the image, use your variables
		x = 0;
		y = 0;
	}
		
	//constructor that allows specifying the file name of the image
	//sets fileName of the image to use
	public Level(String fileName) {
		img2 = getImage("/imgs/" + fileName);
		tx = AffineTransform.getTranslateInstance(x,y);
		init(x,y);
	}
		
		
	public void changePicture(String newFileName) {
		img2 = getImage(newFileName);
		init(x,y);
	}
		
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		update();
		g2.drawImage(img2, tx, null);

	}
	
	public boolean getclr(int x, int y) {
		boolean check = false;
	
		int clr = color.getRGB(x, y);
        int red =   (clr & 0x00ff0000) >> 16;
        int green = (clr & 0x0000ff00) >> 8;
        int blue =   clr & 0x000000ff;
		if(red == 51 && green == 30 && blue == 22) {
			check = true;
		}
		if(red == 255 && green == 255 && blue == 255) {
			check = true;
		}
		
		System.out.println("Red Color value = " + red);
        System.out.println("Green Color value = " + green);
        System.out.println("Blue Color value = " + blue);
        
        
		return check;
		
	}
		
	//update the picture variable location
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(1,1);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1,1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Level.class.getResource(path);
			color = ImageIO.read(imageURL);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
