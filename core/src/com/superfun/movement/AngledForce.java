package com.superfun.movement;

public class AngledForce extends Force {
	private double direction;
	private double speed;
	
	public AngledForce() {
		set(0, 0);
	}
	
	
	// Overides the default behaviour for setting x and y speeds
	public void set(double speed_x, double speed_y) {
		this.speed_x = speed_x;
		this.speed_y = speed_y;
		
		// Correct direction and speed to match speed_x and speed_y
		updateDirection();
		updateSpeed();
	}
	
	
	// Set direction using an angle
	public void setDirection(double direction) {
		this.direction = direction;
		update();
	}
	
	// Set overall speed
	public void setSpeed(double speed) {
		this.speed = speed;
		update();
	}
	
	// Calculate speed_x and speed_y according to direction and speed
	private void update() {
		speed_x = speed * Math.cos(direction);
		speed_y = speed * Math.sin(direction);
	}
	
	
	// Update direction according to speed_x and speed_y
	private void updateDirection() {
		direction = Math.atan2(speed_x, speed_y);
	}
	
	// Update speed according to speed_x and speed_y
	private void updateSpeed() {
		speed = Math.sqrt(Math.pow(speed_x, 2) + Math.pow(speed_y, 2));
	}
	
	
	public double getDirection() {
		return direction;
	}
	
	public double getSpeed() {
		return speed;
	}
}
