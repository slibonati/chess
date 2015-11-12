
package chess.game.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.game.Board;
import chess.game.BoundaryException;
import chess.game.Color;
import chess.game.MoveContext;
import chess.game.Square;
import chess.game.rule.BackwardMovementRule;
import chess.game.rule.PawnMovementRule;

public class Pawn extends Piece {

	private boolean movedTwoSquares = false;

	public Pawn() {
		super();
		this.rules.add(new PawnMovementRule(this));
		this.rules.add(new BackwardMovementRule(this));
	}

	public Pawn(Color color) {
		super(color);
	}

	public Pawn(Square square, Color color) {
		super(square, color);
	}

	@Override
	public String toString() {
		return "P[" + color + "]";
	}

	public String toDetailedString() {
		return "Pawn [rules=" + rules + ", current=" + current + ", color=" + color + "]";
	}

	public boolean isMovedTwoSquares() {
		return movedTwoSquares;
	}

	public void setMovedTwoSquares(boolean movedTwoSquares) {
		this.movedTwoSquares = movedTwoSquares;
	}

	@Override
	public String toAlgebraicRepresentation() {
		return "";
	}

	@Override
	public List<Square> reachable(MoveContext moveContext) {

		List<Square> allowable = new ArrayList<Square>();
		Board board = moveContext.getBoard();

		try {
			if (moveContext.getMove().getColor().equals(Color.WHITE)) {
				if (this.isMovedTwoSquares()) {
					allowable.add(new Square(current.getFile(), board.incrementRankBy(current.getRank(), 1)));

				} else {
					allowable.add(new Square(current.getFile(), board.incrementRankBy(current.getRank(), 1)));
					allowable.add(new Square(current.getFile(), board.incrementRankBy(current.getRank(), 2)));
				}
			} else {
				if (this.isMovedTwoSquares()) {
					allowable.add(new Square(current.getFile(), board.decrementRankBy(current.getRank(), 1)));

				} else {
					allowable.add(new Square(current.getFile(), board.decrementRankBy(current.getRank(), 1)));
					allowable.add(new Square(current.getFile(), board.decrementRankBy(current.getRank(), 2)));
				}
			}

		} catch (BoundaryException e) {
		}

		return allowable;
	}
}