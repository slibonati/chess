package chess.algebra;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlgebraicChessNotationInterpreterTest {

	private AlgebraicChessNotationInterpreter algebraicChessNotationInterpreter;

	@Before
	public void before() {
		algebraicChessNotationInterpreter = new AlgebraicChessNotationInterpreter();
	}

	@Test(expected = InvalidAlgebraicChessNotationException.class)
	public void testInterpretGarbage() throws Exception {

		algebraicChessNotationInterpreter.interpret("fdhnerqjhnterqajntrjn");
	}

	@Test
	public void testInterpretNf3() throws Exception {

		AlgebraicChessNotationMove Nf3 = new AlgebraicChessNotationMove();

		Nf3.setFile("f");
		Nf3.setPiece("N");
		Nf3.setRank("3");

		Assert.assertEquals(Nf3, algebraicChessNotationInterpreter.interpret("Nf3"));
	}

}
