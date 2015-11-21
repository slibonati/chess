package chess.pgn;

import java.util.ArrayList;
import java.util.List;

import chess.UnrecognizedTokenException;

/**
 * @see http://www6.chessclub.com/help/PGN-spec 
 * A string token is a sequence of zero or more printing characters ...
 *
 */
public class StringTokenLexer {

	public List<Token> lex(List<Token> input)
			throws UnrecognizedTokenException, InvalidPGNException {

		if (input.isEmpty()) {
			throw new IllegalArgumentException("input is empty");
		}

		List<Token> result = new ArrayList<Token>();

		for (int i = 0; i < input.size(); i++) {

			Token token = input.get(i);

			// TODO implement string token rules
			
			if (token.getType().equals(Type.QUOTE)) {
				
				boolean found = false;
				for (int j = i + 1; j < input.size(); j++) { // find the next quote

					token = input.get(j);
					if (token.getType().equals(Type.QUOTE)) {

						result.add(getStringToken(input.subList(i, j + 1)));
						found = true;
						i = j;
						break;
					}
					
				}
				
				if (!found) {
					throw new InvalidPGNException(
							"unmatched quote starting at position " + i);
				}

			} else {

				result.add(token);
			}

		}

		return result;
	}

	private Token getStringToken(List<Token> tokens) {

		StringBuilder stringBuilder = new StringBuilder();

		for (Token token : tokens) {
			stringBuilder.append(token.getValue());
		}

		return new Token(Type.STRING, stringBuilder.toString());
	}
}