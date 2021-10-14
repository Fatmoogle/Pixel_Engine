package pixelengine;

public class Pixel {

	public static final Pixel red = new Pixel(255, 0, 0);
	public static final Pixel green = new Pixel(0, 255, 0);
	public static final Pixel blue = new Pixel(0, 0, 255);
	public static final Pixel yellow = new Pixel(255, 255, 0);
	public static final Pixel black = new Pixel(0, 0, 0);
	public static final Pixel white = new Pixel(255, 255, 255);

	private final int value;
	
	public Pixel() {
		value = 0xFF000000; //black
	}
	
	public Pixel(int val) {
		value = val;
	}
	
	public Pixel(float r, float g, float b) {
    	this((int)(r * 255), (int)(g * 255), (int)(b * 255));
    }
	
	public Pixel(int r, int g, int b) {
    	int fullAlpha = 0xFF000000;
    	value = fullAlpha | r << 16 | g << 8 | b;
    }
	
	public int getValue() {
		return value;
	}
	
	public int getR() {
		return (value >> 16) & 255;
	}
	
	public int getG() {
		return (value >> 8) & 255;
	}
	
	public int getB() {
		return value & 255;
	}
	

	
}
