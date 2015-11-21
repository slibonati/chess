package chess;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.game.Board;
import chess.game.BoundaryException;
import chess.game.Color;
import chess.game.Square;

public class BoardTest {
	
	private Board board = new Board();
	@Test
	public void testcolor() {
		assertEquals(Color.BLACK, board.getColor(new Square("a", 1)));
		assertEquals(Color.WHITE, board.getColor(new Square("e", 4)));
		assertEquals(Color.BLACK, board.getColor(new Square("h", 18)));
		assertEquals(Color.WHITE, board.getColor(new Square("d", 5)));
	}
	
	
	@Test
	public void testIncrementFileBy() throws Exception {
		
		assertEquals("c", board.incrementFileBy("a", 2));
	}
	
	@Test(expected=BoundaryException.class)
	public void testIncrementFileByBoundaryException() throws Exception {
		
		board.incrementFileBy("h", 1);
	}
	
	@Test
	public void testDecrementFileBy() throws Exception {
		
		assertEquals("c", board.decrementFileBy("f", 3));
	}
	
	@Test(expected=BoundaryException.class)
	public void testDecrementFileByBoundaryException() throws Exception {
		
		board.decrementFileBy("b", 3);
	}
	

	@Test
	public void testIncrementRankBy() throws Exception {
		
		assertEquals(Integer.valueOf(3), board.incrementRankBy(1, 2));
	}
	
	@Test(expected=BoundaryException.class)
	public void testIncrementRankByBoundaryException() throws Exception {
		
		board.incrementRankBy(8, 1);
	}
	
	@Test
	public void testDecrementRankBy() throws Exception {
		
		assertEquals(Integer.valueOf(4), board.decrementRankBy(7, 3));
	}
	
	@Test(expected=BoundaryException.class)
	public void testDecrementRankByBoundaryException() throws Exception {
		
		board.decrementRankBy(1, 3);
	}
	
}
