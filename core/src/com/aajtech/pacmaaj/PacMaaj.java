package com.aajtech.pacmaaj;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PacMaaj extends ApplicationAdapter {
	private Maze maze;
	private SpriteBatch batch;

	@Override
	public void create() {
		Gdx.graphics.setDisplayMode(420, 450, false);
		batch = new SpriteBatch();
		maze = Maze.fromText(Gdx.files.internal("maze.txt").readString());
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		maze.render(batch);
		batch.end();
	}
}
