package com.aajtech.pacmaaj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Maze {
	public enum Cell {
		PACMAN("pacman.png", 0),
		BLINKY("blinky.png", 0f),
		CLYDE("clyde.png", 0f),
		INKY("inky.png", 0f),
		PINKY("pinky.png", 0f),
		PILL("pill.png", 0),
		BIG_PILL("big_pill.png", 0),
		WALL_LR("wall.png", 0),
		WALL_TB("wall.png", 90f), 
		WALL_LB("corner.png", 0f),
		WALL_RB("corner.png", 90f),
		WALL_RT("corner.png", 180f),
		WALL_LT("corner.png", 270f);

		private final String texture;
		private final float rotation;

		private Cell(String texture, float rotation) {
			this.texture = texture;
			this.rotation = rotation;
		}

		public String getTexture() {
			return texture;
		}

		public float getRotation() {
			return rotation;
		}
	}

	public static Maze fromText(String text) {
		// TODO: El trabajo practico consiste en implementar este metodo.

		return new Maze(new Cell[0][0]);
	}

	private final Cell matrix[][];
	
	private Maze(Cell[][] matrix) {
		this.matrix = matrix;
	}

	public void render(SpriteBatch batch) {
		for (int row = 0; row < matrix.length; row++) {
			Cell currentRow[] = matrix[row];
			for (int column = 0; column < currentRow.length; column++) {
				Cell cell = currentRow[column];
				if (cell != null) {
					Texture img = new Texture(cell.getTexture());
					batch.draw(img,
							(column * 15f) + (15 - img.getWidth()) / 2f,
							Gdx.graphics.getHeight() - ((row + 1) * 15f)
									+ (15 - img.getHeight()) / 2f,
							img.getWidth() / 2f, img.getHeight() / 2f,
							(float) img.getWidth(), (float) img.getHeight(),
							1f, 1f, cell.getRotation(), 0, 0, img.getWidth(),
							img.getHeight(), false, false);
				}
			}
		}
	}

	public int getColumnCount() {
		return matrix[0].length;
	}

	public Object getRowCount() {
		return matrix.length;
	}

	public Cell getCell(int row, int column) {
		return matrix[row][column];
	}
}
