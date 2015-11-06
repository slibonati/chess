package chess.algebra.matcher;

import java.util.List;

import chess.Color;
import chess.Move;
import chess.Square;
import chess.algebra.Token;
import chess.algebra.Type;
import chess.algebra.UnrecognizableNotationException;

public class ShortCastleMatcher implements Matcher {

	private Matcher next;

	@Override
	public Move match(List<Token> input, Color color) throws UnrecognizableNotationException {
		// 0-0
		if (input.size() == 3 && input.get(0).getType() == Type.CASTLE && input.get(1).getType() == Type.DASH
				&& input.get(2).getType() == Type.CASTLE) {

			Square square = null;

			if (color.equals(Color.BLACK)) {
				square = new Square("g", 8);

			} else {
				square = new Square("g", 1);
			}
			return new Move(color, "K", square);

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
