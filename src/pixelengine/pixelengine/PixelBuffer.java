package pixelengine;

import java.util.Arrays;

public class PixelBuffer {

	private int buffer[];
	private int width;
	private int height;
	
	public PixelBuffer(int w, int h) {
		width = w;
		height = h;
		buffer = new int[w * h];
	}
	
	public PixelBuffer(GameScreen screen) {
		width = screen.getW();
		height = screen.getH();
		buffer = screen.getIntBuffer();
	}
	
	public int getW() {
		return width;
	}
	
	public int getH() {
		return height;
	}
	
    public void setPixelUnsafe(int x, int y, Pixel pixel) {
    	int addr = y * width + x;
    	buffer[addr] = pixel.getValue();
    }
    
    public void setPixel(int x, int y, Pixel pixel) {
    	if(x >= 0 && x < width && y >= 0 && y < height) {
    		setPixelUnsafe(x, y, pixel);
    	}
    }
    
    public Pixel getPixel(int x, int y) {
    	return new Pixel(buffer[y * width + x]);
    }
    
    public void clear() {
    	clear(Pixel.black);
    	
    }

    public void clear(Pixel pixel) {
    	Arrays.fill(buffer, pixel.getValue());
    }
    
    public void drawRect(int x, int y, int w, int h, Pixel pixel) {
        // for every y iteration, the x iterates its whole amount
        for(int yi = y; yi < y + h; yi++) {
        	for(int xi = x; xi < x + w; xi++) {
        		setPixel(xi, yi, pixel);
        	}
        }
    }
    
  public void drawLine(int x1, int y1, int x2, int y2, Pixel pixel) {
        
        int xd = x2 - x1;
        int yd = y2 - y1;
        
        if(Math.abs(xd) >= Math.abs(yd)) {
            if(x1 > x2) {
                int t = x1;
                x1 = x2;
                x2 = t;
                
                t = y1;
                y1 = y2;
                y2 = t;
            }
            float slope = yd / (float)xd;
            xd = Math.abs(xd);
            for(int x = 0; x <= xd; x++) {
                int y = (int)(x * slope);
                setPixel(x1 + x, y1 + y, pixel);
            }
        } else {
            if(y1 > y2) {
                int t = x1;
                x1 = x2;
                x2 = t;
                
                t = y1;
                y1 = y2;
                y2 = t;
            }
            float slope = xd / (float)yd;
            yd = Math.abs(yd);
            for(int y = 0; y <= yd; y++) {
                int x = (int)(y * slope);
                setPixel(x1 + x, y1 + y, pixel);
            }
        }
    }
}
