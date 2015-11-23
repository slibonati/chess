package chess.pgn;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class NagTokenLexerTest {
	private NagTokenLexer nagTokenLexer;

	@Before
	public void before() {
		nagTokenLexer = new NagTokenLexer();
	}

	@Test
	public void testLexNag() throws Exception {

		List<Token> tokens = new ArrayList<Token>();

		tokens.add(new Token(Type.DOLLAR_SIGN, "$"));
		tokens.add(new Token(Type.DIGIT, "1"));
		tokens.add(new Token(Type.DIGIT, "0"));
		tokens.add(new Token(Type.WHITE_SPACE, " "));

		List<Token> result = nagTokenLexer.lex(tokens);

		List<Token> expected = new ArrayList<Token>();

		expected.add(new Token(Type.NAG, "$10"));
		expected.add(new Token(Type.WHITE_SPACE, " "));

		assertEquals(expected, result);
	}

	@Test
	public void testLexNoNag() throws Exception {
		List<Token> tokens = new ArrayList<Token>();

		tokens.add(new Token(Type.LEFT_BRACKET, "["));
		tokens.add(new Token(Type.RIGHT_BRACKET, "]"));

		List<Token> result = nagTokenLexer.lex(tokens);

		assertEquals(tokens, result);
	}

}
