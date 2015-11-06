package chess;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.game.Board;

public class BoardTest {
	
	private Board board = new Board();
	@Test
	public void test() {
		assertEquals(Color.BLACK, board.getColor(new Square("a", 1)));
		assertEquals(Color.WHITE, board.getColor(new Square("e", 4)));
		assertEquals(Color.BLACK, board.getColor(new Square("h", 18)));
		assertEquals(Color.WHITE, board.getColor(new Square("d", 5)));
	}

}
