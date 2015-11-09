package chess.algebra.matcher;

import java.util.List;

import chess.Color;
import chess.algebra.Token;
import chess.algebra.UnrecognizableNotationException;
import chess.game.Move;

public interface Matcher {

	public Move match(List<Token> input,  Color color) throws UnrecognizableNotationException;

	public void setNext(Matcher matcher);
}
