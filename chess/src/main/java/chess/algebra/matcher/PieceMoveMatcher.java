package chess.algebra.matcher;

import java.util.List;

import chess.algebra.Type;
import chess.algebra.UnrecognizableNotationException;
import chess.game.Color;
import chess.game.Move;
import chess.game.Square;
import chess.algebra.Token;

public class PieceMoveMatcher implements Matcher {

	private Matcher next;

	@Override
	public Move match(List<Token> input, Color color) throws UnrecognizableNotationException {
		// Nf3
		if (input.size() == 3 && input.get(0).getType() == Type.PIECE && input.get(1).getType() == Type.FILE
				&& input.get(2).getType() == Type.RANK) {

			Square square = new Square(input.get(1).getValue(), Integer.valueOf(input.get(2).getValue()));

			return new Move(color, input.get(0).getValue(), square);

		}
		// Ne6+
		if (input.size() == 4 && input.get(0).getType() == Type.PIECE && input.get(1).getType() == Type.FILE
				&& input.get(2).getType() == Type.RANK && input.get(3).getType() == Type.CHECK) {

			Square square = new Square(input.get(1).getValue(), Integer.valueOf(input.get(2).getValue()));
			Move move = new Move(color, input.get(0).getValue(), square);
			move.setCheck(true);
			return move;

		}
		
		// Rc2#
		if (input.size() == 4 && input.get(0).getType() == Type.PIECE && input.get(1).getType() == Type.FILE
				&& input.get(2).getType() == Type.RANK && input.get(3).getType() == Type.CHECKMATE) {

			Square square = new Square(input.get(1).getValue(), Integer.valueOf(input.get(2).getValue()));
			Move move = new Move(color, input.get(0).getValue(), square);
			move.setCheckmate(true);
			return move;
		} 
		
		// disambiguate file 
		if (input.size() == 4 && input.get(0).getType() == Type.PIECE && input.get(1).getType() == Type.FILE
				&& input.get(2).getType() == Type.FILE && input.get(3).getType() == Type.RANK) {

			Square square = new Square(input.get(2).getValue(), Integer.valueOf(input.get(3).getValue()));
			Square fileDisambiguity = new Square(input.get(1).getValue(), null);

			return new Move(color, input.get(0).getValue(), square, fileDisambiguity);

		}
		// disambiguate rank
		if (input.size() == 4 && input.get(0).getType() == Type.PIECE && input.get(1).getType() == Type.RANK
				&& input.get(2).getType() == Type.FILE && input.get(3).getType() == Type.RANK) {

			Square square = new Square(input.get(2).getValue(), Integer.valueOf(input.get(3).getValue()));
			Square rankDisambiguity = new Square(null, Integer.valueOf(input.get(1).getValue()));

			return new Move(color, input.get(0).getValue(), square, rankDisambiguity);

		}
		// disambiguate file and rank
		if (input.size() == 5 && input.get(0).getType() == Type.PIECE && input.get(1).getType() == Type.FILE && input.get(2).getType() == Type.RANK
				&& input.get(3).getType() == Type.FILE && input.get(4).getType() == Type.RANK) {

			Square square = new Square(input.get(3).getValue(), Integer.valueOf(input.get(4).getValue()));
			Square rankDisambiguity = new Square(input.get(1).getValue(), Integer.valueOf(input.get(2).getValue()));

			return new Move(color, input.get(0).getValue(), square, rankDisambiguity);
		}
		// Rfe8+
				if (input.size() == 5 && input.get(0).getType() == Type.PIECE && input.get(1).getType() == Type.FILE
						&& input.get(2).getType() == Type.FILE && input.get(3).getType() == Type.RANK && input.get(4).getType() == Type.CHECK) {

					Square square = new Square(input.get(2).getValue(), Integer.valueOf(input.get(3).getValue()));
					Square fileDisambiguity = new Square(input.get(1).getValue(), null);
					Move move = new Move(color, input.get(0).getValue(), square, fileDisambiguity);
					move.setCheck(true);
					return move;

				}
		
		if (next == null) {
			throw new UnrecognizableNotationException("Invalid algebraic chess notation: " + getValue(input));
		}
		return next.match(input, color);
		
	}

	@Override
	public void setNext(Matcher matcher) {
		this.next = matcher;
	}
}
