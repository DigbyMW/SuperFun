package com.superfun;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input.Keys;

public class SuperFun extends ApplicationAdapter {
	SpriteBatch batch;
	Texture ship_texture;
	Entity ship_entity;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		ship_texture = new Texture("ship.png");
		ship_entity = new Entity();
		ship_entity.speed_change = 2;
	}

	@Override
	public void render () {
		// Input
		ship_entity.speed_target_x = 0;
		ship_entity.speed_target_y = 0;
		
		if (Gdx.input.isKeyPressed(Keys.D)) {
			ship_entity.speed_target_x += 16;
		} if (Gdx.input.isKeyPressed(Keys.A)) {
			ship_entity.speed_target_x -= 16;
		} if (Gdx.input.isKeyPressed(Keys.W)) {
			ship_entity.speed_target_y += 16;
		} if (Gdx.input.isKeyPressed(Keys.S)) {
			ship_entity.speed_target_y -= 16;
		}
		
		
		// Graphics
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(ship_texture, ship_entity.position_x, ship_entity.position_y);
		batch.end();
		
		
		// Physics
		ship_entity.update();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		ship_texture.dispose();
	}
}
