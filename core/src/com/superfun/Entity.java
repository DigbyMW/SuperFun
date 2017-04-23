package com.superfun;

public class Entity {
	// Coordinate of entity in the window:
	public int position_x;
	public int position_y;
	
	// Pixels to move each step:
	private int speed_x;
	private int speed_y;
	
	// Speed to try and reach:
	public int speed_target_x;
	public int speed_target_y;
	
	// Maximum amount to increase or decrease speed by in a single step:
	public int speed_change;
	
	Entity () {
		position_x = 0;
		position_y = 0;
		
		speed_x = 0;
		speed_y = 0;
		
		speed_target_x = 0;
		speed_target_y = 0;
		
		speed_change = 0;
	}
	
	
	// Update position of the entity:
	public void update () {
		// Reassign speeds to aproach speed targets:
		speed_x = updateSpeed(speed_x, speed_target_x);
		speed_y = updateSpeed(speed_y, speed_target_y);
		
		// Apply speed to entity's current position:
		position_x += speed_x;
		position_y += speed_y;
	}
	
	// Calculate new speed values to reach the speed target:
	private int updateSpeed (int speed, int speed_target) {
		// Do nothing if the speed target has been reached
		if (speed != speed_target) {
			
			// Check if speed needs to increase or decrease
			if (speed < speed_target) { // Increase
				speed += speed_change;
				if (speed > speed_target) {
					// Prevent speed from exceding the speed target
					speed = speed_target;
				}
			} else { // Decrease
				speed -= speed_change;
				if (speed < speed_target) {
					speed = speed_target;
				}
			}
		}
		return speed;
	}
}
