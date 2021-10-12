package pixelengine;

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
	
    // y * screenwidth + x location
    public void setPixel(int x, int y, Pixel pixel) {
    	buffer[y * width + x] = pixel.getValue();
    }
    
    public Pixel getPixel(int x, int y) {
    	return new Pixel(buffer[y * width + x]);
    }

    public void drawRect(int x, int y, int w, int h, Pixel pixel) {
        // for every y iteration, the x iterates its whole amount
        for(int yi = y; yi < y + h; yi++) {
        	for(int xi = x; xi < x + w; xi++) {
        		setPixel(xi, yi, pixel);
        	}
        }
    }
	
}
