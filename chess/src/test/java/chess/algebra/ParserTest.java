package chess.algebra;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import chess.game.Color;
import chess.algebra.Token;

public class ParserTest {

	private Parser parser = new Parser();

	private List<Token> input = new ArrayList<Token>();

	@Test(expected = UnrecognizableNotationException.class)
	public void testUnrecognizableNotationException() throws Exception {

		input.add(new Token(Type.PIECE, "N"));
		parser.parse(input, Color.WHITE);

	}

}
