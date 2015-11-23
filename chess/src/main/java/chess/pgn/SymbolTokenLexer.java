package chess.pgn;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import chess.UnrecognizedTokenException;

/**
 * @see http://www6.chessclub.com/help/PGN-spec A symbol token starts with a
 *      letter or digit character ...
 *
 */
public class SymbolTokenLexer implements TokenLexer {

	private EnumSet<Type> symbolContinuationCharacters = EnumSet.of(
			Type.LETTER, Type.DIGIT, Type.UNDERSCORE, Type.PLUS, Type.HASH,
			Type.EQUAL, Type.COLON, Type.HYPHEN);

	/* (non-Javadoc)
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

			if (token.getType().equals(Type.LETTER)
					|| token.getType().equals(Type.DIGIT)) {

				// loop until non symbol continuation character
				int j = 0;
				for (j = i + 1; j < input.size(); j++) {

					token = input.get(j);
					if (symbolContinuationCharacters.contains(token.getType())) {
						continue;
					} else {
						result.add(getSymbolToken(input.subList(i, j)));
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

	private Token getSymbolToken(List<Token> tokens) {

		StringBuilder stringBuilder = new StringBuilder();
		Type type = null;
		int digitCount = 0;
		
		for (Token token : tokens) {
			if (token.getType().equals(Type.DIGIT)) {
				digitCount++;
			}
			stringBuilder.append(token.getValue());
		}

		type = (tokens.size() == digitCount) ? Type.INTEGER : Type.SYMBOL ;	
		
		
		return new Token(type, stringBuilder.toString());
	}
}