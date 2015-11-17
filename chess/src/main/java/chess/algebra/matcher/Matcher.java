package chess.algebra.matcher;

import java.util.List;

import chess.algebra.UnrecognizableNotationException;
import chess.game.Color;
import chess.game.Move;
import chess.algebra.Token;

public interface Matcher {

	public Move match(List<Token> input,  Color color) throws UnrecognizableNotationException;

	public void setNext(Matcher matcher);
}
