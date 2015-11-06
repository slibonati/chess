package chess.algebra.matcher;

import java.util.List;

import chess.Color;
import chess.Move;
import chess.Square;
import chess.algebra.Token;
import chess.algebra.Type;
import chess.algebra.UnrecognizableNotationException;

public class PromoteMatcher implements Matcher {

	private Matcher next;

	@Override
	public Move match(List<Token> input, Color color) throws UnrecognizableNotationException {
		// e8=Q
		if (input.size() == 4 && input.get(0).getType() == Type.FILE && input.get(1).getType() == Type.RANK
				&& input.get(2).getType() == Type.PROMOTE && input.get(3).getType() == Type.PIECE) {

			Square square = new Square(input.get(0).getValue(), Integer.valueOf(input.get(1).getValue()));

			return new Move(color, "", input.get(3).getValue(), square);

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
