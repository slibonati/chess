package chess.algebra.matcher;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import chess.algebra.Token;
import chess.algebra.Type;
import chess.game.Color;
import chess.game.Move;
import chess.game.Square;

public class PieceMoveMatcherTest {

	private PieceMoveMatcher pieceMoveMatcher = new PieceMoveMatcher();
	private List<Token> input = new ArrayList<Token>();

	@Test
	public void testMatchNe2() throws Exception {
		// Ne2
		input.clear();
		input.add(new Token(Type.PIECE, "N"));
		input.add(new Token(Type.FILE, "e"));
		input.add(new Token(Type.RANK, "2"));

		Move expected = new Move(Color.WHITE, "N", new Square("e", 2));

		assertEquals(expected, pieceMoveMatcher.match(input, Color.WHITE));
	}
	
	@Test
	public void testMatchNce2() throws Exception {
		// Nce2
		input.clear();
		input.add(new Token(Type.PIECE, "N"));
		input.add(new Token(Type.FILE, "c"));
		input.add(new Token(Type.FILE, "e"));
		input.add(new Token(Type.RANK, "2"));

		Move expected = new Move(Color.WHITE, "N", new Square("e", 2), new Square("c", null));

		assertEquals(expected, pieceMoveMatcher.match(input, Color.WHITE));
	}
	
	@Test
	public void testMatchNg1e2() throws Exception {
		// Ng1e2
		input.clear();
		input.add(new Token(Type.PIECE, "N"));
		input.add(new Token(Type.FILE, "g"));
		input.add(new Token(Type.RANK, "1"));
		input.add(new Token(Type.FILE, "e"));
		input.add(new Token(Type.RANK, "2"));

		Move expected = new Move(Color.WHITE, "N", new Square("e", 2), new Square("g", 1));

		assertEquals(expected, pieceMoveMatcher.match(input, Color.WHITE));
	}

}
