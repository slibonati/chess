package chess.algebra.matcher;

import java.util.List;

import chess.algebra.Token;
import chess.algebra.Type;
import chess.algebra.UnrecognizableNotationException;
import chess.game.Color;
import chess.game.Move;
import chess.game.Square;

public class PieceMoveMatcher implements Matcher {

	private Matcher next;

	@Override
	public Move match(List<Token> input, Color color) throws UnrecognizableNotationException {
		// Nf3
		if (input.size() == 3 && input.get(0).getType() == Type.PIECE && input.get(1).getType() == Type.FILE
				&& input.get(2).getType() == Type.RANK) {

			Square square = new Square(input.get(1).getValue(), Integer.valueOf(input.get(2).getValue()));

			return new Move(color, input.get(0).getValue(), square);

		} else {
			if (next == null) {
				throw new UnrecognizableNotationException("Invalid algebraic chess notation.");
			}
			return next.match(input, color);
		}
	}

	@Override
	public void setNext(Matcher matcher) {
		this.next = matcher;
	}
}
