package pixelengine;

import math.Vec2d;

public abstract class GameObject {
	
	protected Vec2d pos = Vec2d.ZERO;
	
	public void setPos(Vec2d pos) {
		this.pos = pos;
	}
	
	public Vec2d getPos() {
		return pos;
	}
	
	public abstract void update(int w, int h, Vec2d gravity, double friction, double rFriction);
	
	public abstract void draw(PixelBuffer buffer);
	
}
