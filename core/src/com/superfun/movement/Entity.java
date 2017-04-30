package com.superfun.movement;

// Class for creating moving objects
public class Entity {
	
	// Coordinate of entity in the window
	public double position_x;
	public double position_y;
	
	// Pixels to move each step
	private double speed_x;
	private double speed_y;
	
	// How much to slow speed by each step
	public double drag;
	
	public Entity () {
		position_x = 0;
		position_y = 0;
		
		speed_x = 0;
		speed_y = 0;
		
		drag = 0;
	}
	
	
	// Update position of the entity:
	public void update () {
		// Apply speed to entity's current position
		position_x += speed_x;
		position_y += speed_y;
		
		
		// Total speed per step
		double speed_total = Math.abs(speed_x) + Math.abs(speed_y);
		
		// Drag:
		if (drag != 0 && speed_total != 0) {
			// Scale down speed_x and speed_y
			// speed_x + speed_y should equal 1 after this.
			speed_x /= speed_total;
			speed_y /= speed_total;
			
			// Apply drag to total speed
			speed_total -= drag;
			if (speed_total < 0) {
				speed_total = 0;
			}
			
			// Apply drag to speed_x and speed_y
			speed_x *= speed_total;
			speed_y *= speed_total;
		}
	}
	
	
	public void addForce(Force force) {
		speed_x += force.getSpeedX();
		speed_y += force.getSpeedY();
	}
	
	public void setForce(Force force) {
		speed_x = force.getSpeedX();
		speed_y = force.getSpeedY();
	}
	
	
	public Force getForce() {
		Force force = new Force();
		force.set(speed_x, speed_y);
		return force;
	}
}
