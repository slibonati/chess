package chess.pgn;

import java.util.ArrayList;
import java.util.List;

public class Parser {

	/**
	 * @param tokens
	 *            produced by Lexer
	 * @return Pgn
	 * @throws InvalidTagPairException
	 */
	Pgn parse(List<Token> tokens) throws InvalidTagPairException {

		Pgn pgn = new Pgn();

		for (int i = 0; i < tokens.size(); i++) {

			Token token = tokens.get(i);
			// find tag pair
			if (token.getType().equals(Type.LEFT_BRACKET)) {

				for (int j = i + 1; i < tokens.size(); j++) {

					token = tokens.get(j);

					if (token.getType().equals(Type.RIGHT_BRACKET)) {
						pgn.getTagPairSection().add(getTagPair(tokens.subList(i, j + 1)));
						i = j + 1;
						break;
					}
				}
			}
			// find move number indication
			if (token.getType().equals(Type.INTEGER)) {

				int j = 0;
				for (j = i + 1; j < tokens.size(); j++) {

					token = tokens.get(j);

					if (token.getType().equals(Type.PERIOD)
							|| token.getType().equals(Type.WHITE_SPACE) || token.getType().equals(Type.SYMBOL)) {

						continue; // consume

					} else {
						break;
					}
				}

				MoveNumberIndication moveNumberIndication = new MoveNumberIndication();

				// discarding white space and periods
				for (Token moveNumberIndicationToken : tokens.subList(i, j)) {
					if (moveNumberIndicationToken.getType().equals(Type.INTEGER)) {
						moveNumberIndication.getIntegers().add(moveNumberIndicationToken);
					}
					/*
					 * if (token.getType().equals(Type.PERIOD)) {
					 * moveNumberIndication.getPeriods().add(
					 * moveNumberIndicationToken); }
					 */
					if (moveNumberIndicationToken.getType().equals(Type.SYMBOL)) {
						moveNumberIndication.getMoves().add(moveNumberIndicationToken);
						
						pgn.getMovetextSection().getMoves().add(moveNumberIndicationToken);
					}
				}

				pgn.getMovetextSection().getMoveNumberIndications().add(moveNumberIndication);
				i = j - 1;
			}

		}
		
		Token gameTerminationMarker = pgn.getMovetextSection().getMoves().remove(pgn.getMovetextSection().getMoves().size() - 1);
		pgn.getMovetextSection().setGameTerminationMarker(gameTerminationMarker);
		
	
		return pgn;
	}

	private TagPair getTagPair(List<Token> tokens) throws InvalidTagPairException {

		TagPair tagPair = new TagPair();

		List<Token> stripped = stripWhiteSpace(tokens);

		try {

			if (stripped.get(0).getType().equals(Type.LEFT_BRACKET) && stripped.get(1).getType().equals(Type.SYMBOL)
					&& stripped.get(2).getType().equals(Type.STRING)
					&& stripped.get(3).getType().equals(Type.RIGHT_BRACKET)) {

				tagPair.setLeftBracketToken(stripped.get(0));
				tagPair.setSymbolToken(stripped.get(1));
				tagPair.setStringToken(stripped.get(2));
				tagPair.setRightBracketToken(stripped.get(3));

			} else {
				StringBuilder stringBuilder = new StringBuilder();
				for (Token token : tokens) {
					stringBuilder.append(token.getValue());
				}
				throw new InvalidTagPairException(stringBuilder.toString());
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
