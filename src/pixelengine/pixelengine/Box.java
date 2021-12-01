package pixelengine;

import math.Vec2d;

public class Box extends GameObject {
	
	private int w;
	private int h;
	private Pixel color;
	private double elasticity;
	private Vec2d vel;
	
	public Box(int w, int h, double elasticity, Pixel color) {
		vel = Vec2d.ZERO;
		this.w = w;
		this.h = h;
		this.elasticity = elasticity;
		this.color = color;
	}
	
	public void setVel(Vec2d vel) {
		this.vel = vel;
	}
	
	@Override
	public void update(int w, int h, Vec2d gravity, double friction, double rFriction) {
			
		// Add bouncing box logic
		vel = vel.add(gravity);
		pos = pos.add(vel);
		vel = vel.scale(friction);
		
		if(pos.getX() + this.w >= w) {
			vel = vel.flipX().scale(elasticity);
			pos = pos.setX(w - this.w);
		}
		if(pos.getX() < 0) {
			vel = vel.flipX().scale(elasticity);
			pos = pos.setX(0);
		}
		
		if(pos.getY() + this.h >= h) {
			vel = vel.flipY().scale(elasticity);
			vel = vel.scale(rFriction);
			pos = pos.setY(h - this.h);
		}
		if(pos.getY() < 0) {
			vel = vel.flipY().scale(elasticity);
			pos = pos.setY(0);
		}
		
	}
	
	@Override
	public void draw(PixelBuffer buffer) {

		
		buffer.drawRect((int)pos.getX(), (int)pos.getY(), w, h, color);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Box " + w + " " + h;
	}
}
