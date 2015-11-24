package chess.pgn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Ignore;
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
	@Ignore
	public void testParseFischerStein1967() throws Exception {

		String file = FileUtils.readFileToString(new File("./src/test/resources/fischer_stein_1967.pgn"));

		assertNotNull(file);
		List<Token> tokens = lexer.lex(file);
		assertFalse(tokens.isEmpty());

		Pgn pgn = parser.parse(tokens);
		assertNotNull(pgn);
		assertNotNull(pgn.getTagPairSection());

		assertEquals(Integer.valueOf(12), Integer.valueOf(pgn.getTagPairSection().getTagPairs().size()));
		assertEquals(Integer.valueOf(56),
				Integer.valueOf(pgn.getMovetextSection().getMoveNumberIndications().size()));
		assertEquals(Integer.valueOf(111), Integer.valueOf(pgn.getMovetextSection().getMoves().size()));
		assertEquals("1-0", pgn.getMovetextSection().getGameTerminationMarker().getValue());
	}

	@Test

	public void testParseGameOfTheCentury() throws Exception {

		String file = FileUtils.readFileToString(new File("./src/test/resources/game_of_the_century.pgn"));

		assertNotNull(file);
		List<Token> tokens = lexer.lex(file);
		assertFalse(tokens.isEmpty());
		
		Pgn pgn = parser.parse(tokens);
		assertNotNull(pgn);
		assertNotNull(pgn.getTagPairSection());

		assertEquals(Integer.valueOf(8), Integer.valueOf(pgn.getTagPairSection().getTagPairs().size()));
		assertEquals(Integer.valueOf(48),
				Integer.valueOf(pgn.getMovetextSection().getMoveNumberIndications().size()));
		assertEquals(Integer.valueOf(82), Integer.valueOf(pgn.getMovetextSection().getMoves().size()));
		assertEquals("0-1", pgn.getMovetextSection().getGameTerminationMarker().getValue());
	}

}
