package pixelengine;

import java.util.ArrayList;
import java.util.HashMap;

import math.Vec2d;

public class Main {
	
	public static GameScreen screen;
	
	// Function to generate a random set of numbers with a min and max range
	public static int rand(int min, int max) {
		return (int) (min + (Math.random() * ((max + 1) - min)));
	}
	
	public static void main(String[] args) {
		screen = new GameScreen();
		PixelBuffer buffer = new PixelBuffer(screen);
		
		float angle = 90.0f;

		Vec2d gravity = new Vec2d(0, 0.25);
				
		double speed = 1 / 5.0;
				
		double friction = 0.999f;
		double rFriction = 0.99f;

		gravity = gravity.scale(speed);
		friction = 1.0 - ((1.0 - friction) * speed);
		rFriction = 1.0 - ((1.0 - rFriction) * speed);
		
		Ball ball1 = new Ball(13, 0.85, Pixel.red);
		ball1.setPos(new Vec2d(50, 100));
		ball1.setVel(new Vec2d(Math.toRadians(angle)).scale(40.0 * speed));
		
		Ball ball2 = new Ball(30, 0.55, Pixel.blue);
		ball2.setPos(new Vec2d(90, 10));
		ball2.setVel(new Vec2d(Math.toRadians(angle + 20)).scale(40.0 * speed));
		
		Ball ball3 = new Ball(4, 0.90, Pixel.green);
		ball3.setPos(new Vec2d(70, 35));
		ball3.setVel(new Vec2d(Math.toRadians(angle - 80)).scale(40.0 * speed));
		
		Box box = new Box(32, 64, 0.99, Pixel.yellow);
		box.setPos(new Vec2d(120, 120));
		box.setVel(new Vec2d(Math.toRadians(angle - 80)).scale(40.0 * speed));
		
		ArrayList<GameObject> objects = new ArrayList<GameObject>();
		objects.add(ball1);
		objects.add(ball2);
		objects.add(ball3);
		objects.add(ball3);
		objects.add(box);
		
		objects.sort((a, b) -> (int)(a.getPos().getX() - b.getPos().getX()));
//		objects.forEach(b -> System.out.println(b.getPos().getX()));
//		System.out.println(objects.get(1));	
//		System.out.println(objects.size());
//		System.out.println(objects.indexOf(ball3));
//		System.out.println(objects.toString());
		
		ArrayList<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(99);
		integers.add(105);
		integers.add(32);
		integers.add(40);

//		integers.sort((a ,b) -> a - b);
//		integers.forEach(i -> System.out.println(i));
		
		HashMap<String, GameObject> map = new HashMap<>(); 
		map.put("joe", ball1);
		map.put("bill", ball2);
		map.put("kyle", ball3);
		System.out.println(map.get("bill").getPos());

// look at hashmaps and check out the methods
		
		
		
		while(true) {
			buffer.clear();
			
			for(GameObject object : objects) {
				object.update(buffer.getW(), buffer.getH(), gravity, friction, rFriction);
			}
			
			
			for(GameObject object : objects) {
				object.draw(buffer);
			}
			
			screen.update();
		}
	}
}