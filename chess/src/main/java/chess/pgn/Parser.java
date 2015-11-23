package chess.pgn;

import java.util.ArrayList;
import java.util.List;

public class Parser {

	public Parser() {

	}

	PgnGame parse(List<Token> tokens) throws InvalidTagPairException {

		PgnGame pgnGame = new PgnGame();

		for (int i = 0; i < tokens.size(); i++) {
			Token token = tokens.get(i);
			if (token.getType().equals(Type.LEFT_BRACKET)) {

				for (int j = i + 1; i < tokens.size(); j++) {
					
					token = tokens.get(j);
					
					if (token.getType().equals(Type.RIGHT_BRACKET)) {
						pgnGame.getTagPairSection().add(
								getTagPair(tokens.subList(i, j + 1)));
						i = j + 1;
						break;
					}	
				}
			}
		}

		return pgnGame;
	}

	private TagPair getTagPair(List<Token> tokens)
			throws InvalidTagPairException {

		TagPair tagPair = new TagPair();
		
		List<Token> stripped = stripWhiteSpace(tokens);

		try {

			if (stripped.get(0).getType().equals(Type.LEFT_BRACKET)
					&& stripped.get(1).getType().equals(Type.SYMBOL)
					&& stripped.get(2).getType().equals(Type.STRING)
					&& stripped.get(3).getType().equals(Type.RIGHT_BRACKET)) {

				tagPair.setLeftBracketToken(stripped.get(0));
				tagPair.setSymbolToken(stripped.get(1));
				tagPair.setStringToken(stripped.get(2));
				tagPair.setRightBracketToken(stripped.get(3));

			} else {
				throw new InvalidTagPairException();
			}

		} catch (Exception e) {
			throw new InvalidTagPairException(e);
		}
		return tagPair;

	}

	private List<Token> stripWhiteSpace(List<Token> tokens) {

		List<Token> stripped = new ArrayList<Token>();
		for (Token token : tokens) {
			if (!(token.getType().equals(Type.WHITE_SPACE))) {
				stripped.add(token);
			}
		}
		return stripped;
	}

}
