package chess.algebra.matcher;

import java.util.List;

import chess.algebra.UnrecognizableNotationException;
import chess.game.Color;
import chess.game.Move;
import chess.algebra.Token;

public interface Matcher {

	public Move match(List<Token> input,  Color color) throws UnrecognizableNotationException;

	public void setNext(Matcher matcher);
	
	public default String getValue(List<Token> input) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Token token : input) {
			stringBuilder.append(token.getValue());
		}
		return stringBuilder.toString();
	}
}
