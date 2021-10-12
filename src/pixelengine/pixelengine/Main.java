package pixelengine;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Main {
	
	private static Frame frame;
    private static Canvas canvas;
    
    protected static final int canvasWidth = 640;
    protected static final int canvasHeight = 360;

    public static BufferedImage setUpScreen() {
    	frame = new Frame();
        canvas = new Canvas();

        canvas.setPreferredSize(new Dimension(canvasWidth * 2 , canvasHeight * 2));
        
        frame.add(canvas);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Closed");
                System.exit(0);
            }
        });
        
        frame.setVisible(true);
        
        return new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
    }
    
    // y * screenwidth + x location
    public static void setPixel(int[] buffer, int x, int y, int color) {
    	buffer[y * canvasWidth + x] = color;
    }

    
    public static void drawRect(int[] buffer, int x, int y, int w, int h, int color) {
        // for every y iteration, the x iterates its whole amount
        for(int yi = y; yi < y + h; yi++) {
        	for(int xi = x; xi < x + w; xi++) {
        		setPixel(buffer, xi, yi, color);
        	}
        }
    }
    
    // Function to generate a random set of numbers with a min and max range
	public static int rand(int min, int max) {
		return (int) (min + (Math.random() * ((max + 1) - min)));
	}

	public static void flipScreen(BufferedImage bufferedImage) {
        Graphics g = canvas.getGraphics();
        g.drawImage(bufferedImage, 0, 0, canvasWidth * 2, canvasHeight * 2, null);
        g.dispose();
	}
    
    public static int rgb(float r, float g, float b) {
    	return rgb((int)(r * 255), (int)(g * 255), (int)(b * 255));
    }
	
	public static int rgb(int r, int g, int b) {
    	int fullAlpha = 0xFF000000;
    	return fullAlpha | r << 16 | g << 8 | b;
    }
    
	public static void main(String[] args) {
		
		BufferedImage bufferedImage = setUpScreen();
		
        int buffer[] = ((DataBufferInt) bufferedImage.getRaster().getDataBuffer()).getData();
        
        /*int green = rgb(12, 240, 90);
        int red = rgb(240, 12, 90);
        int blue = rgb(12, 10, 249); 
        
        int[] colors = new int[] {red, green, blue}; */

        
        while(true) {
        	
        	/* for(int j = 0; j < 1; j++) {
            	int x = rand(0, 600);
            	int y = rand(0, 240);
            	int colorNum = rand(0, 2); */
        	
        	for(float i = 0; i < 360; i += 0.1) {
        		int r = (int) (((Math.sin(i) / 2) + 0.5) * 255.0);
        		int b = (int) (((Math.cos(i) / 2) + 0.5) * 255.0);
        		
        		int color1 = rgb(r, 0, 0);
        		int color2 = rgb(0, 0, b);
        		int blackBackground = rgb(0, 0, 0);
        		
        		int sqWidth = 100; 
        		
        		drawRect(buffer, 0, 0, canvasWidth, canvasHeight, blackBackground);
        		drawRect(buffer, (((canvasWidth / 2) - sqWidth) / 2), ((canvasHeight / 2) - sqWidth / 2), sqWidth, sqWidth, color1);
        		drawRect(buffer, (((canvasWidth / 2) - sqWidth) / 2) + 320, ((canvasHeight / 2) - sqWidth / 2), sqWidth, sqWidth, color2);

        		
            	flipScreen(bufferedImage);
        	}
        	
//            public static void drawRect(int[] buffer, int x, int y, int w, int h, int color) {

        	

//        		}
        
        }
      }
	}
		
        
     
        
        
        



