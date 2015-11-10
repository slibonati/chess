package chess.game.rule;

import java.util.ArrayList;
import java.util.List;

import chess.game.Board;
import chess.game.BoundaryException;
import chess.game.MoveContext;
import chess.game.Square;
import chess.game.pieces.Piece;

public class KnightMovementRule implements Rule {

	private Piece piece;

	public KnightMovementRule(Piece piece) {
		this.piece = piece;
	}

	@Override
	public boolean isCompliant(MoveContext moveContext) {

		Square to = moveContext.getMove().getTo();

		if (moveContext.getBoard().isOccupied(to)) {
			return false;
		}

		List<Square> allowable = getAllowableSquares(to, moveContext.getBoard());
		if (allowable.contains(to)) {
			return true;
		}

		return false;

	}

	private List<Square> getAllowableSquares(Square square, Board board) {

		List<Square> allowable = new ArrayList<Square>();

		List<Square> potential = new ArrayList<Square>();

		Integer r;
		String f;
		Square to;

		// example d4
		try {

			r = board.incrementRankBy(square.getRank(), 2);

			f = board.incrementFileBy(square.getFile(), 1);
			to = new Square(f, r); // e6

			allowable.add(to);

			f = board.decrementFileBy(square.getFile(), 1);
			to = new Square(f, r); // c6

			allowable.add(to);

			r = board.incrementRankBy(square.getRank(), 1);

			f = board.decrementFileBy(square.getFile(), 2);
			to = new Square(f, r); // b5

			allowable.add(to);

			r = board.incrementRankBy(square.getRank(), 1);

			f = board.incrementFileBy(square.getFile(), 2);
			to = new Square(f, r); // f5

			allowable.add(to);

			r = board.decrementRankBy(square.getRank(), 1);

			f = board.decrementFileBy(square.getFile(), 2);
			to = new Square(f, r); // b3

			allowable.add(to);

			f = board.incrementFileBy(square.getFile(), 2);
			to = new Square(f, r); // f3

			allowable.add(to);

			r = board.decrementRankBy(square.getRank(), 2);

			f = board.decrementFileBy(square.getFile(), 1);
			to = new Square(f, r); // c2

			f = board.incrementFileBy(square.getFile(), 1);
			to = new Square(f, r); // e2

		} catch (BoundaryException e) {

		}

		for (Square s : potential) {
			allowable.add(s);
		}

		return allowable;

	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	@Override
	public String getMessage() {

		return "knight moves in an L pattern";
	}
}