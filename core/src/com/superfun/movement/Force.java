package com.superfun.movement;

public class Force {
	// Distance to move in pixels
	protected double speed_x;
	protected double speed_y;
	
	public Force() {
		set(0, 0);
	}
	
	
	// Set speed for each axis
	public void set(double speed_x, double speed_y) {
		this.speed_x = speed_x;
		this.speed_y = speed_y;
	}
	
	// Set speed by using the speed from another force
	public void set(Force force) {
		set(force.getSpeedX(), force.getSpeedY());
	}
	
	
	public double getSpeedX() {
		return speed_x;
	}
	
	public double getSpeedY() {
		return speed_y;
	}
}
