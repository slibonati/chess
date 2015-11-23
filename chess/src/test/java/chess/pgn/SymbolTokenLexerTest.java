package chess.pgn;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SymbolTokenLexerTest {

	private SymbolTokenLexer symbolTokenLexer;

	@Before
	public void before() {
		symbolTokenLexer = new SymbolTokenLexer();
	}

	@Test
	public void testLexSymbol() throws Exception {

		List<Token> tokens = new ArrayList<Token>();

		tokens.add(new Token(Type.LETTER, "S"));
		tokens.add(new Token(Type.LETTER, "i"));
		tokens.add(new Token(Type.LETTER, "t"));
		tokens.add(new Token(Type.LETTER, "e"));
		tokens.add(new Token(Type.WHITE_SPACE, " "));

		List<Token> result = symbolTokenLexer.lex(tokens);

		List<Token> expected = new ArrayList<Token>();
		
		expected.add(new Token(Type.SYMBOL, "Site"));
		expected.add(new Token(Type.WHITE_SPACE, " "));

		assertEquals(expected, result);

	}

	@Test
	public void testLexNoSymbol() throws Exception {
		List<Token> tokens = new ArrayList<Token>();

		tokens.add(new Token(Type.LEFT_BRACKET, "["));
		tokens.add(new Token(Type.RIGHT_BRACKET, "]"));

		List<Token> result = symbolTokenLexer.lex(tokens);

		assertEquals(tokens, result);
	}

	@Test
	public void testLexInteger() throws Exception {
		List<Token> tokens = new ArrayList<Token>();

		
		tokens.add(new Token(Type.DIGIT, "5"));
		tokens.add(new Token(Type.DIGIT, "6"));
		tokens.add(new Token(Type.PERIOD, "."));
	

		List<Token> result = symbolTokenLexer.lex(tokens);

		List<Token> expected = new ArrayList<Token>();
	
		expected.add(new Token(Type.INTEGER, "56"));
		expected.add(new Token(Type.PERIOD, "."));

		assertEquals(expected, result);
	}

}
