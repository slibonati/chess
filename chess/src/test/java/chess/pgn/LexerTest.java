package chess.pgn;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

public class LexerTest {

	private Lexer lexer;

	@Before
	public void before() {
		lexer = new Lexer();
	}

	@Test
	public void testLex() throws Exception {

		String fischeStein1967 = FileUtils.readFileToString(new File("./src/test/resources/fischer_stein_1967.pgn"));

		assertNotNull(fischeStein1967);
		List<Token> tokens = lexer.lex(fischeStein1967);
		assertFalse(tokens.isEmpty());

		for (Token token : tokens) {
			System.out.println(token.getType());
		}

	}

}
