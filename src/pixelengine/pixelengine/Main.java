package pixelengine;

public class Main {
	
	public static GameScreen screen;
	
	// Function to generate a random set of numbers with a min and max range
	public static int rand(int min, int max) {
		return (int) (min + (Math.random() * ((max + 1) - min)));
	}
	
	public static void main(String[] args) {
		screen = new GameScreen();
		PixelBuffer buffer = new PixelBuffer(screen);
		
		
		float angle = 0.0f;

		float x = 50;
		float y = 100;
		float xV = 4;
		float yV = 0;
		float elasticity = 0.5f;
		float friction = 0.999f;
		float rFriction = 0.99f;
		int radius = 10;

		
		while(true) {
			buffer.clear();


			buffer.fillCircle((int)x, (int)y, radius, new Pixel(125, 125, 125));
			
			yV += .5;
			x += xV;
			y += yV;
			yV *= friction;
			xV *= friction;
			
			
			if(x + radius >= buffer.getW()) {
				xV = -xV * elasticity;
				x = buffer.getW() - radius;
			}
			if(x - radius <= 0) {
				xV = -xV * elasticity;
				x = radius;
			}
			if(y + radius >= buffer.getH()) {
				yV = -yV * elasticity;
				y = buffer.getH() - radius;
				xV *= rFriction;
			}
			if(y - radius <= 0) {
				yV = -yV * elasticity;
				y = radius;
			}
			
			
//			buffer.drawRegularPolygon(xMid, yMid, 3, radius, angle * 1.3f, Pixel.yellow);
//			buffer.drawRegularPolygon(xMid, yMid, 4, (int) (Math.sin(angle * 0.01) * 60), angle * 1.3f, Pixel.red);


			
			screen.update();
		}
	}
}