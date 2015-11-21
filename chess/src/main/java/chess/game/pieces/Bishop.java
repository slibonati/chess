package chess.game.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.game.Board;
import chess.game.BoundaryException;
import chess.game.Color;
import chess.game.MoveContext;
import chess.game.Square;

public class Bishop extends Piece {

	public Bishop(Color color) {
		super(color);
	}

	public Bishop(Square current, Color color) {
		super(current, color);
	}

	@Override
	public String toString() {
		return "B[" + color + "]";
	}

	@Override
	public String toDetailedString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toAlgebraicRepresentation() {
		return "B";
	}

	@Override
	public List<Square> reachable(MoveContext moveContext) {

		List<Square> allowable = new ArrayList<Square>();
		Board board = moveContext.getBoard();

		Integer r = 0;
		String f = "";

		for (int i = 0; i < 8; i++) {

			// example d5

			try {
				f = board.incrementFileBy(current.getFile(), i + 1);
				r = board.incrementRankBy(current.getRank(), i + 1);
				// e6, f7, g8
				allowable.add(new Square(f, r));
			} catch (BoundaryException e) {

			}
			try {
				f = board.decrementFileBy(current.getFile(), i + 1);
				r = board.incrementRankBy(current.getRank(), i + 1);
				// c6, b7, a8
				allowable.add(new Square(f, r));
			} catch (BoundaryException e) {

			}
			try {
				f = board.decrementFileBy(current.getFile(), i + 1);
				r = board.decrementRankBy(current.getRank(), i + 1);
				// c4, b3, a2
				allowable.add(new Square(f, r));
			} catch (BoundaryException e) {

			}
			try {
				f = board.incrementFileBy(current.getFile(), i + 1);
				r = board.decrementRankBy(current.getRank(), i + 1);

				// e4, f3, g2, h1
				allowable.add(new Square(f, r));
			} catch (BoundaryException e) {

			}

		}

		return allowable;
	}
}
