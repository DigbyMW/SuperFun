package com.superfun;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input.Keys;
import com.superfun.movement.Entity;
import com.superfun.movement.Force;

public class SuperFun extends ApplicationAdapter {
	SpriteBatch batch;
	Texture ship_texture;
	
	Entity ship_entity;
	Force ship_force;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		ship_texture = new Texture("ship.png");
		
		ship_entity = new Entity();
		ship_entity.drag = 2;
		
		ship_force = new Force();
	}

	@Override
	public void render () {
		// Movement
		double speed_x = 0;
		double speed_y = 0;
		
		Force current_force = ship_entity.getForce();
		
		if (Gdx.input.isKeyPressed(Keys.D) && current_force.getSpeedX() < 16) {
			speed_x += 4;
		} if (Gdx.input.isKeyPressed(Keys.A) && current_force.getSpeedX() > - 16) {
			speed_x -= 4;
		} if (Gdx.input.isKeyPressed(Keys.W) && current_force.getSpeedY() < 16) {
			speed_y += 4;
		} if (Gdx.input.isKeyPressed(Keys.S) && current_force.getSpeedY() > - 16) {
			speed_y -= 4;
		}
		
		ship_force.set(speed_x, speed_y);
		ship_entity.addForce(ship_force);
		
		ship_entity.update();
		
		
		// Graphics
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(ship_texture, (int) ship_entity.position_x, (int) ship_entity.position_y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		ship_texture.dispose();
	}
}
