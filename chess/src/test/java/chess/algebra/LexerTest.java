package chess.algebra;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LexerTest {

	private Lexer lexer = new Lexer();
	private List<Token> result = new ArrayList<Token>();

	@Test
	public void testLexGameofTheCentury() throws Exception {

		// 1. Nf3 Nf6
		result.add(new Token(Type.PIECE, "N"));
		result.add(new Token(Type.FILE, "f"));
		result.add(new Token(Type.RANK, "3"));
		assertEquals(result, lexer.lex("Nf3"));

		result.clear();
		result.add(new Token(Type.PIECE, "N"));
		result.add(new Token(Type.FILE, "f"));
		result.add(new Token(Type.RANK, "6"));
		assertEquals(result, lexer.lex("Nf6"));

		// 2. c4 g6
		result.clear();
		result.add(new Token(Type.FILE, "c"));
		result.add(new Token(Type.RANK, "4"));
		assertEquals(result, lexer.lex("c4"));

		result.clear();
		result.add(new Token(Type.FILE, "g"));
		result.add(new Token(Type.RANK, "6"));
		assertEquals(result, lexer.lex("g6"));

		// 3. Nc3 Bg7
		result.clear();
		result.add(new Token(Type.PIECE, "N"));
		result.add(new Token(Type.FILE, "c"));
		result.add(new Token(Type.RANK, "3"));
		assertEquals(result, lexer.lex("Nc3"));

		result.clear();
		result.add(new Token(Type.PIECE, "B"));
		result.add(new Token(Type.FILE, "g"));
		result.add(new Token(Type.RANK, "7"));
		assertEquals(result, lexer.lex("Bg7"));

		// 4. d4 0-0
		result.clear();
		result.add(new Token(Type.FILE, "d"));
		result.add(new Token(Type.RANK, "4"));
		assertEquals(result, lexer.lex("d4"));

		result.clear();
		result.add(new Token(Type.CASTLE, "0"));
		result.add(new Token(Type.DASH, "-"));
		result.add(new Token(Type.CASTLE, "0"));
		assertEquals(result, lexer.lex("0-0"));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentException() throws Exception {

		lexer.lex("");
	}
	
	@Test(expected = UnrecognizedTokenException.class)
	public void testUnrecognizedTokenException() throws Exception {

		lexer.lex("^");
	}

}
