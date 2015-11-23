package chess.pgn;

import java.util.ArrayList;
import java.util.List;

import chess.UnrecognizedTokenException;

/**
 * @see http://www6.chessclub.com/help/PGN-spec A Numeric Annotation Glyph
 *      ("NAG", see below) is a token ...
 *
 */
public class NagTokenLexer implements TokenLexer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see chess.pgn.TokenLexer#lex(java.util.List)
	 */
	@Override
	public List<Token> lex(List<Token> input)
			throws UnrecognizedTokenException, InvalidPGNException {

		if (input.isEmpty()) {
			throw new IllegalArgumentException("input is empty");
		}

		List<Token> result = new ArrayList<Token>();

		for (int i = 0; i < input.size(); i++) {

			Token token = input.get(i);

			if (token.getType().equals(Type.DOLLAR_SIGN)) {

				// loop until non digit
				int j = 0;
				for (j = i + 1; j < input.size(); j++) {

					token = input.get(j);
					if (token.getType().equals(Type.DIGIT)) {
						continue;
					} else {
						result.add(getNagToken(input.subList(i, j)));
						i = j - 1;
						break;
					}
				}

			} else {

				result.add(token);
			}

		}

		return result;
	}

	private Token getNagToken(List<Token> tokens) {

		StringBuilder stringBuilder = new StringBuilder();

		for (Token token : tokens) {

			stringBuilder.append(token.getValue());
		}

		return new Token(Type.NAG, stringBuilder.toString());
	}
}