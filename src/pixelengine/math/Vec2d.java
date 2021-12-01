package math;

public class Vec2d {
	
	public static final Vec2d ZERO = new Vec2d (0,0);

	private double x;
	private double y;
	
	public Vec2d(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vec2d(double angle) {
		this.x = Math.sin(angle);
		this.y = Math.cos(angle);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public Vec2d setX(double x) {
		return new Vec2d(x, this.y);
	}
	
	public Vec2d setY(double y) {
		return new Vec2d(this.x, y);
	}
	
	public Vec2d add(Vec2d v) {
		return new Vec2d(this.x + v.x , this.y + v.y);
	}
	
	public Vec2d sub(Vec2d v) {
		return new Vec2d(this.x - v.x , this.y - v.y);
	}
	
	public Vec2d scale(double s) {
		return new Vec2d(this.x * s , this.y * s);
	}
	
	public Vec2d flipX() {
		return new Vec2d(-this.x, this.y);
	}
	
	public Vec2d flipY() {
		return new Vec2d(this.x, -this.y);

	}
	
	public Vec2d invert() {
		return new Vec2d(-this.x, -this.y);
	}
	
	public Vec2d normalize() {
		double len = length();
		return new Vec2d(this.x / len, this.y / len);
	}
	
	public double length() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}
	
	@Override
    public String toString() {
        return "{ " + this.x + ", " + this.y + " }";
    }
}
