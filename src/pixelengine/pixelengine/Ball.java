package pixelengine;

import math.Vec2d;

public class Ball extends GameObject {
	
	private double radius;
	private Vec2d vel;
	private double elasticity;
	private Pixel color;
	
	public Ball(double radius, double elasticity, Pixel color) {
		vel = Vec2d.ZERO;
		this.radius = radius;
		this.elasticity = elasticity;
		this.color = color;
	}

	public void setVel(Vec2d vel) {
		this.vel = vel;
	}
	
	@Override
	public void update(int w, int h, Vec2d gravity, double friction, double rFriction) {
		
		vel = vel.add(gravity);
		pos = pos.add(vel);
		vel = vel.scale(friction);
		
		if(pos.getX() + radius >= w) {
			vel = vel.flipX().scale(elasticity);
			pos = pos.setX(w - radius);
		}
		if(pos.getX() - radius <= 0) {
			vel = vel.flipX().scale(elasticity);
			pos = pos.setX(radius);
		}
		
		if(pos.getY() + radius >= h) {
			vel = vel.flipY().scale(elasticity);
			vel = vel.scale(rFriction);
			pos = pos.setY(h - radius);
		}
		if(pos.getY() - radius <= 0) {
			vel = vel.flipY().scale(elasticity);
			pos = pos.setY(radius);
		}
	}
	
	@Override
	public void draw(PixelBuffer buffer) {
		
		buffer.fillCircle((int)pos.getX(), (int)pos.getY(), (int) (radius - 1), color);
		buffer.drawCircle((int)pos.getX(), (int)pos.getY(), (int) (radius - 1), color);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ball " + radius;
	}
}
