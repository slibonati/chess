package chess.game.rule;

import chess.game.Color;
import chess.game.MoveContext;
import chess.game.pieces.Piece;

public class BackwardMovementRule implements Rule {

	private Piece piece;

	public BackwardMovementRule(Piece piece) {
		super();
		this.piece = piece;
	}

	@Override
	public boolean isCompliant(MoveContext moveContext) {
		if (piece.getColor() == Color.WHITE) {
			return (moveContext.getMove().getTo().getRank() > piece.getCurrent().getRank());
		} else {
			return (moveContext.getMove().getTo().getRank() < piece.getCurrent().getRank());
		}

	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	@Override
	public String getMessage() {
		return "Pawns cannot move backwards.";
	}

	@Override
	public String toString() {
		return "BackwardMovementRule";
	}
}
