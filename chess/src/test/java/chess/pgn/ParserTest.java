package chess.pgn;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {

	private Lexer lexer;
	private Parser parser;

	@Before
	public void before() {
		lexer = new Lexer();
		parser = new Parser();
	}

	@Test
	public void testParse() throws Exception {

		String fischeStein1967 = FileUtils.readFileToString(new File(
				"./src/test/resources/fischer_stein_1967.pgn"));

		assertNotNull(fischeStein1967);
		List<Token> tokens = lexer.lex(fischeStein1967);
		assertFalse(tokens.isEmpty());

		PgnGame pgnGame = parser.parse(tokens);
		assertNotNull(pgnGame);
		assertNotNull(pgnGame.getTagPairSection());
		assertTrue(pgnGame.getTagPairSection().getTagPairs().size() == 12);

	}

}
