package chess.game.rule;

import java.util.List;

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

		List<Square> allowable = piece.reachable(moveContext);
		if (allowable.contains(moveContext.getMove().getTo())) {
			return true;
		}

		return false;
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