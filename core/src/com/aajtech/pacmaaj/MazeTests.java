package com.aajtech.pacmaaj;

import static org.junit.Assert.*;

import org.junit.Test;

import com.aajtech.pacmaaj.Maze.Cell;

public class MazeTests {

	@Test
	public void testMazeOk() {
		String mazeText =
				",------------.,------------.\n" +
				"|oooooooooooo||oooooooooooo|\n" +
				"|o,--.o,---.o||o,---.o,--.o|\n" +
				"|O|  |o|   |o||o|   |o|  |O|\n" +
				"|o`--'o`---'o`'o`---'o`--'o|\n" +
				"|oooooooooooooooooooooooooo|\n" +
				"|o,--.o,.o,------.o,.o,--.o|\n" +
				"|o`--'o||o`--.,--'o||o`--'o|\n" +
				"|oooooo||oooo||oooo||oooooo|\n" +
				"`----.o|`--. || ,--'|o,----'\n" +
				"     |o|,--' `' `--.|o|     \n" +
				"     |o||  p       ||o|     \n" +
				"     |o||b,--  --. ||o|     \n" +
				"-----'o`' |      | `'o`-----\n" +
				"      o   | i  c |   o      \n" +
				"-----.o,. `------' ,.o,-----\n" +
				"     |o||          ||o|     \n" +
				"     |o|| ,------. ||o|     \n" +
				",----'o`' `--.,--' `'o`----.\n" +
				"|oooooooooooo||oooooooooooo|\n" +
				"|o,--.o,---.o||o,---.o,--.o|\n" +
				"|o`-.|o`---'o`'o`---'o|,-'o|\n" +
				"|Ooo||ooooooo Pooooooo||ooO|\n" +
				"`-.o||o,.o,------.o,.o||o,-'\n" +
				",-'o`'o||o`--.,--'o||o`'o`-.\n" +
				"|oooooo||oooo||oooo||oooooo|\n" +
				"|o,----'`--.o||o,--'`----.o|\n" +
				"|o`--------'o`'o`--------'o|\n" +
				"|oooooooooooooooooooooooooo|\n" +
				"`--------------------------'";
		
		Maze maze = Maze.fromText(mazeText);
		
		assertEquals(30, maze.getRowCount());
		assertEquals(28, maze.getColumnCount());
		assertEquals(Cell.PACMAN, maze.getCell(22, 14));
		assertEquals(Cell.BLINKY, maze.getCell(12, 9));
		assertEquals(Cell.PINKY, maze.getCell(11, 11));
		assertEquals(Cell.INKY, maze.getCell(14, 12));
		assertEquals(Cell.CLYDE, maze.getCell(14, 15));
		assertEquals(Cell.BIG_PILL, maze.getCell(3, 1));
		assertEquals(Cell.BIG_PILL, maze.getCell(3, 26));
		assertEquals(Cell.BIG_PILL, maze.getCell(22, 1));
		assertEquals(Cell.BIG_PILL, maze.getCell(22, 26));
		assertEquals(Cell.PILL, maze.getCell(1, 5));
		assertEquals(Cell.PILL, maze.getCell(22, 12));
		assertEquals(Cell.PILL, maze.getCell(28, 15));
		assertEquals(Cell.WALL_RB, maze.getCell(12, 10));
		assertEquals(Cell.WALL_LR, maze.getCell(12, 11));
		assertEquals(Cell.WALL_LB, maze.getCell(12, 17));
		assertEquals(Cell.WALL_TB, maze.getCell(13, 10));
		assertEquals(Cell.WALL_RT, maze.getCell(15, 10));
		assertEquals(Cell.WALL_LT, maze.getCell(15, 17));
		assertNull(maze.getCell(14, 0));
		assertNull(maze.getCell(14, 27));
	}

	@Test
	public void testInvalidChar() {
		String mazeText =
				",------------.,------------.\n" +
				"|oooooooooooo||oooooooooooo|\n" +
				"|o,--.o,---.o||o,---.o,--.o|\n" +
				"|O|  |o|   |o||o|   |o|  |O|\n" +
				"|o`--'o`---'o`'o`---'o`--'o|\n" +
				"|oooooooooooooooooooooooooo|\n" +
				"|o,--.o,.o,------.o,.o,--.o|\n" +
				"|o`--'o||o`--.,--'o||o`--'o|\n" +
				"|oooooo||oooo||oooo||oooooo|\n" +
				"`----.o|`--. || ,--'|o,----'\n" +
				"     |o|,--' `' `--.|o|     \n" +
				"     |o||  p       ||o|     \n" +
				"     |o||b,--  --. ||o|     \n" +
				"-----'o`' |   A  | `'o`-----\n" +
				"      o   | i  c |   o      \n" +
				"-----.o,. `------' ,.o,-----\n" +
				"     |o||          ||o|     \n" +
				"     |o|| ,------. ||o|     \n" +
				",----'o`' `--.,--' `'o`----.\n" +
				"|oooooooooooo||oooooooooooo|\n" +
				"|o,--.o,---.o||o,---.o,--.o|\n" +
				"|o`-.|o`---'o`'o`---'o|,-'o|\n" +
				"|Ooo||ooooooo Pooooooo||ooO|\n" +
				"`-.o||o,.o,------.o,.o||o,-'\n" +
				",-'o`'o||o`--.,--'o||o`'o`-.\n" +
				"|oooooo||oooo||oooo||oooooo|\n" +
				"|o,----'`--.o||o,--'`----.o|\n" +
				"|o`--------'o`'o`--------'o|\n" +
				"|oooooooooooooooooooooooooo|\n" +
				"`--------------------------'";
		
		try {
			Maze.fromText(mazeText);
			fail("IllegalArgumentException expected");
		} catch (IllegalArgumentException expected) {
			assertEquals("Invalid character: A(65) at row 13  and column 14", expected.getMessage());
		}
	}

	@Test
	public void testInvalidColumnCount() {
		String mazeText =
				",------------.,------------.\n" +
				"|oooooooooooo||oooooooooooo|\n" +
				"|o,--.o,---.o||o,---.o,--.o|\n" +
				"|O|  |o|   |o||o|   |o|  |O|\n" +
				"|o`--'o`---'o`'o`---'o`--'o|\n" +
				"|oooooooooooooooooooooooooo|\n" +
				"|o,--.o,.o,------.o,.o,--.o|\n" +
				"|o`--'o||o`--.,--'o||o`--'o|\n" +
				"|oooooo||oooo||oooo||oooooo|\n" +
				"`----.o|`--. || ,--'|o,----'\n" +
				"     |o|,--' `' `--.|o|     \n" +
				"     |o||  p       ||o|     \n" +
				"     |o||b,--  --. ||o|     \n" +
				"-----'o`' |      | `'o`-----\n" +
				"      o   | i  c |   o      \n" +
				"-----.o,. `------' ,.o,-----\n" +
				"     |o||          ||o|     \n" +
				"     |o|| ,------. ||o|     \n" +
				",----'o`' `--.,--' `'o`----.\n" +
				"|oooooooooooo||ooooooooooo|\n" +
				"|o,--.o,---.o||o,---.o,--.o|\n" +
				"|o`-.|o`---'o`'o`---'o|,-'o|\n" +
				"|Ooo||ooooooo Pooooooo||ooO|\n" +
				"`-.o||o,.o,------.o,.o||o,-'\n" +
				",-'o`'o||o`--.,--'o||o`'o`-.\n" +
				"|oooooo||oooo||oooo||oooooo|\n" +
				"|o,----'`--.o||o,--'`----.o|\n" +
				"|o`--------'o`'o`--------'o|\n" +
				"|oooooooooooooooooooooooooo|\n" +
				"`--------------------------'";
		
		try {
			Maze.fromText(mazeText);
			fail("IllegalArgumentException expected");
		} catch (IllegalArgumentException expected) {
			assertEquals("Expected column size is 28 at row 19", expected.getMessage());
		}
	}


	@Test
	public void testInvalidColumnCountAtLastLine() {
		String mazeText =
				",------------.,------------.\n" +
				"|oooooooooooo||oooooooooooo|\n" +
				"|o,--.o,---.o||o,---.o,--.o|\n" +
				"|O|  |o|   |o||o|   |o|  |O|\n" +
				"|o`--'o`---'o`'o`---'o`--'o|\n" +
				"|oooooooooooooooooooooooooo|\n" +
				"|o,--.o,.o,------.o,.o,--.o|\n" +
				"|o`--'o||o`--.,--'o||o`--'o|\n" +
				"|oooooo||oooo||oooo||oooooo|\n" +
				"`----.o|`--. || ,--'|o,----'\n" +
				"     |o|,--' `' `--.|o|     \n" +
				"     |o||  p       ||o|     \n" +
				"     |o||b,--  --. ||o|     \n" +
				"-----'o`' |      | `'o`-----\n" +
				"      o   | i  c |   o      \n" +
				"-----.o,. `------' ,.o,-----\n" +
				"     |o||          ||o|     \n" +
				"     |o|| ,------. ||o|     \n" +
				",----'o`' `--.,--' `'o`----.\n" +
				"|oooooooooooo||oooooooooooo|\n" +
				"|o,--.o,---.o||o,---.o,--.o|\n" +
				"|o`-.|o`---'o`'o`---'o|,-'o|\n" +
				"|Ooo||ooooooo Pooooooo||ooO|\n" +
				"`-.o||o,.o,------.o,.o||o,-'\n" +
				",-'o`'o||o`--.,--'o||o`'o`-.\n" +
				"|oooooo||oooo||oooo||oooooo|\n" +
				"|o,----'`--.o||o,--'`----.o|\n" +
				"|o`--------'o`'o`--------'o|\n" +
				"|oooooooooooooooooooooooooo|\n" +
				"`-------------------------'";
		
		try {
			Maze.fromText(mazeText);
			fail("IllegalArgumentException expected");
		} catch (IllegalArgumentException expected) {
			assertEquals("Expected column size is 28 at row 29", expected.getMessage());
		}
	}
}
