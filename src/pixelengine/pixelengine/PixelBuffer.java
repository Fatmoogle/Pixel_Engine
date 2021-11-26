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

		int xdAbs = Math.abs(xd);
		int ydAbs = Math.abs(yd);

		boolean doX = xdAbs >= ydAbs;

		if(doX && x1 > x2 || !doX && y1 > y2) {
			int t = x1; x1 = x2; x2 = t;
			t = y1; y1 = y2; y2 = t;
		}

		if(doX) {
			float slope = yd / (float)xd;
			for(int x = 0; x <= xdAbs; x++) {
				int y = (int)(x * slope);
				setPixel(x1 + x, y1 + y, pixel);
			}
		} else {
			float slope = xd / (float)yd;
			for(int y = 0; y <= ydAbs; y++) {
				int x = (int)(y * slope);
				setPixel(x1 + x, y1 + y, pixel);
			}
		}
	}

	public void drawRegularPolygon(int midX, int midY, int sides, int radius, float angle, Pixel color) {
		float stepAngle = 360.0f / sides ;

		int xLast = midX + (int) (Math.sin(Math.toRadians(angle)) * radius);;
		int yLast = midY + (int) (Math.cos(Math.toRadians(angle)) * radius);;

		for(float i = angle + stepAngle; i <= angle + 360; i += stepAngle) {
			int xDelta = (int) (Math.sin(Math.toRadians(i)) * radius);
			int yDelta = (int) (Math.cos(Math.toRadians(i)) * radius);

			int xNext = midX + xDelta;
			int yNext = midY + yDelta;

			drawLine(xLast, yLast, xNext, yNext, color);

			xLast = xNext;
			yLast = yNext;
		}
	}
	
	public void drawSpiral(int x, int y, float angle, Pixel color) {
		float stepAngle = 1.0f;
		float radius = 0;

		int xLast = x + (int) (Math.sin(Math.toRadians(angle)) * radius);;
		int yLast = y + (int) (Math.cos(Math.toRadians(angle)) * radius);;

		for(float i = angle + stepAngle; i < angle + 360 * 10; i += stepAngle) {
			int xDelta = (int) (Math.sin(Math.toRadians(i)) * radius);
			int yDelta = (int) (Math.cos(Math.toRadians(i)) * radius);
			
			radius += 0.05;

			int xNext = x + xDelta;
			int yNext = y + yDelta;

			drawLine(xLast, yLast, xNext, yNext, color);

			xLast = xNext;
			yLast = yNext;
		}
	}
	
	// Function for circle-generation using Bresenham's algorithm
    public void drawCircle(int xc, int yc, int r, Pixel color) {
        int x = 0, y = r;
        int d = 3 - 2 * r;
        setPixel(xc+x, yc+y, color);
        setPixel(xc-x, yc+y, color);
        setPixel(xc+x, yc-y, color);
        setPixel(xc-x, yc-y, color);
        setPixel(xc+y, yc+x, color);
        setPixel(xc-y, yc+x, color);
        setPixel(xc+y, yc-x, color);
        setPixel(xc-y, yc-x, color);

        while (y >= x) {
            if (d > 0) {
                y--;
                d = d + (4 * x) - (4 * y) + 10;
            } else {
                d = d + (4 * x) + 6;
            }
            x++;
            setPixel(xc+x, yc+y, color);
            setPixel(xc-x, yc+y, color);
            setPixel(xc+x, yc-y, color);
            setPixel(xc-x, yc-y, color);
            setPixel(xc+y, yc+x, color);
            setPixel(xc-y, yc+x, color);
            setPixel(xc+y, yc-x, color);
            setPixel(xc-y, yc-x, color);
        }
    }
	
    public void fillCircle(int xMid, int yMid, int r, Pixel color) {
    	int rSqr = r * r;
    	int x1 = xMid - r;
    	int y1 = yMid - r;
    	int x2 = xMid + r;
    	int y2 = yMid + r;
    	
    	if(x1 < 0) {
    		x1 = 0;
    	}
    	if(y1 < 0) {
    		y1 = 0;
    	}
    	if(x2 >= getW()) {
    		x2 = getW() - 1;
    	}
    	if(y2 >= getH()) {
    		y2 = getH() - 1;
    	}
    	
       for(int y = y1; y <= y2; y++) {
    	   for(int x = x1; x <= x2; x++) {
    		   int xd = x - xMid;
    		   int yd = y - yMid;
    		   
    		   if(xd * xd + yd * yd < rSqr) {
    			   setPixelUnsafe(x, y, color);
    		   }  
    	   }
       }
    }
	
    
	//draw sprial function 
	// with each iteration, increase the radius and dont complete the circlee

}
