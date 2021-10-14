package pixelengine;

public class Main {
	
	public static GameScreen screen;

	public static int canvasWidth;
    

    
    // Function to generate a random set of numbers with a min and max range
	public static int rand(int min, int max) {
		return (int) (min + (Math.random() * ((max + 1) - min)));
	}
    
	public static void main(String[] args) {
		
		screen = new GameScreen();
		PixelBuffer buffer = new PixelBuffer(screen);
		Pixel bgColor = Pixel.black;
		
		int x = 0;
		int y = 0;
		
		
		
        while(true) {
        	
        	for(float i = 0; i < 360; i += 0.1) {
        		int r = 255;
        		int b = (int) (((Math.cos(i) / 2) + 0.5) * 255.0);
        		
        		Pixel color1 = new Pixel(r, 0, 0);
        		Pixel color2 = new Pixel(0, 0, b);
        		
        		int sqWidth = 25;
        		       		
        		buffer.drawRect(0, 0, buffer.getW(), buffer.getH(), bgColor);
        		
        		buffer.drawRect(x, y, sqWidth, sqWidth, color1);
        		
        		
        		if(x < (buffer.getW() - sqWidth)) {
        			x = x + 5;
        			System.out.println(x);
	    		} else if(x == (buffer.getW() - sqWidth)){
	    			System.out.println(x);
	    			x = x - 5;
	    		}
        		
//        		if(x < (buffer.getW() - sqWidth)) {
//        			x = x + 5;
//        			System.out.println(x);
//        		} else if(x == (buffer.getW() - sqWidth)){
//        			System.out.println(x);
//        			x = x - 5;
//        		}
//        	    	
//        		buffer.moveRect(x, y);
//    			System.out.println(0 + 1);

        		
        		
      
//        		buffer.drawRect((((buffer.getW() / 2) - sqWidth) / 2), ((buffer.getH() / 2) - sqWidth / 2), sqWidth, sqWidth, color1);
//        		buffer.drawRect((((buffer.getW() / 2) - sqWidth) / 2) + 320, ((buffer.getH() / 2) - sqWidth / 2), sqWidth, sqWidth, color2);

        		screen.update();
        	}
        }
      }
	}
		
        
     
        
        
        



