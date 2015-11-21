package chess.game.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import chess.game.Board;
import chess.game.Color;
import chess.game.Move;
import chess.game.MoveContext;
import chess.game.Player;
import chess.game.Square;

public class BishopTest {

	private Bishop bishop;
	private Board board;
	private Player player;
	private Move move;
	private MoveContext moveContext;

	@Before
	public void before() {
		board = new Board();

		Square current = new Square("d", 5);

		bishop = new Bishop(current, Color.WHITE);

		moveContext = new MoveContext(board, null, null);

		board.put(bishop, current);
	}

	@Test
	public void testReachable() {

		List<Square> squares = bishop.reachable(moveContext);

		assertEquals(13, squares.size());

		assertTrue(squares.contains(new Square("e", 6)));
		assertTrue(squares.contains(new Square("f", 7)));
		assertTrue(squares.contains(new Square("g", 8)));
		assertTrue(squares.contains(new Square("c", 6)));
		assertTrue(squares.contains(new Square("b", 7)));

		assertTrue(squares.contains(new Square("a", 8)));
		assertTrue(squares.contains(new Square("c", 4)));
		assertTrue(squares.contains(new Square("b", 3)));
		assertTrue(squares.contains(new Square("a", 2)));
		assertTrue(squares.contains(new Square("e", 4)));
		assertTrue(squares.contains(new Square("f", 3)));
		assertTrue(squares.contains(new Square("g", 2)));
		assertTrue(squares.contains(new Square("h", 1)));

	}

}
