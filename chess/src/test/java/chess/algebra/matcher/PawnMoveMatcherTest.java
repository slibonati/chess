package chess.algebra.matcher;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import chess.Color;
import chess.Move;
import chess.Square;
import chess.algebra.Token;
import chess.algebra.Type;
import chess.algebra.UnrecognizableNotationException;

public class PawnMoveMatcherTest {

	private PawnMoveMatcher pawnMoveMatcher = new PawnMoveMatcher();
	private List<Token> input = new ArrayList<Token>();

	@Test
	public void testMatch() throws Exception {

		input.add(new Token(Type.FILE, "e"));
		input.add(new Token(Type.RANK, "4"));

		Move expected = new Move(Color.WHITE, "", new Square("e", 4));

		assertEquals(expected, pawnMoveMatcher.match(input, Color.WHITE));
	}

}
