package chess.game.rule;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import chess.game.Board;
import chess.game.Color;
import chess.game.Move;
import chess.game.MoveContext;
import chess.game.Player;
import chess.game.Square;
import chess.game.pieces.Knight;
import chess.game.pieces.Pawn;

public class KnightMovementRuleTest {

	private Board board;
	private Move move;
	private Player player;
	private Knight knight;
	private KnightMovementRule knightMovementRule;
	private MoveContext moveContext;

	@Before
	public void before() {

		board = new Board();
		move = new Move();
		knight = new Knight(new Square("d", 4), Color.WHITE);
		player = new Player(Color.WHITE);
		knightMovementRule = new KnightMovementRule(knight);
		moveContext = new MoveContext(board, player, move);
	}

	@Test
	public void testIsCompliant() {

		move.setColor(Color.WHITE);
		move.setPiece("N");
		move.setTo(new Square("e", 6));

		assertTrue(knightMovementRule.isCompliant(moveContext));
	}

	@Test
	public void testIsNotCompliant() {

		move.setColor(Color.WHITE);
		move.setPiece("N");
		move.setTo(new Square("e", 5));

		assertFalse(knightMovementRule.isCompliant(moveContext));
	}
	
	@Test
	public void testIsNotCompliantSquareOccupied() {
		
		board.put(new Pawn(Color.BLACK), new Square("e", 6));
		
		move.setColor(Color.WHITE);
		move.setPiece("N");
		move.setTo(new Square("e", 5));

		assertFalse(knightMovementRule.isCompliant(moveContext));
	}
	
	
}
