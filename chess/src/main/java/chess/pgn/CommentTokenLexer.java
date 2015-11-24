package chess.pgn;

import java.util.ArrayList;
import java.util.List;

import chess.UnrecognizedTokenException;

/**
 * @see http://www6.chessclub.com/help/PGN-spec Comment text may appear in PGN
 *      data. There are two kinds of comments. The first kind is the
 *      "rest of line" comment; this comment type starts with a semicolon
 *      character and continues to the end of the line. The second kind starts
 *      with a left brace character and continues to the next right brace
 *      character. ...
 *
 */
public class CommentTokenLexer implements TokenLexer {

	public List<Token> lex(List<Token> input) throws UnrecognizedTokenException, InvalidPGNException {

		if (input.isEmpty()) {
			throw new IllegalArgumentException("input is empty");
		}

		List<Token> result = new ArrayList<Token>();

		for (int i = 0; i < input.size(); i++) {

			Token token = input.get(i);


			if (token.getType().equals(Type.LEFT_BRACE)) {

				boolean found = false;
				for (int j = i + 1; j < input.size(); j++) { // find the next brace
																

					token = input.get(j);
					if (token.getType().equals(Type.RIGHT_BRACE)) {

						result.add(getCommentToken(input.subList(i, j + 1)));
						found = true;
						i = j;
						break;
					}

				}

				if (!found) {
					throw new InvalidPGNException("unmatched left brace starting at position " + i);
				}

			} else {

				result.add(token);
			}

		}

		return result;
	}

	private Token getCommentToken(List<Token> tokens) {

		StringBuilder stringBuilder = new StringBuilder();

		for (Token token : tokens) {
			stringBuilder.append(token.getValue());
		}

		return new Token(Type.COMMENT, stringBuilder.toString());
	}
}