package chess.game.rule;

import java.util.List;

import chess.game.MoveContext;
import chess.game.Square;
import chess.game.pieces.Piece;

public class PawnMovementRule implements Rule {

	private Piece piece;

	public PawnMovementRule(Piece piece) {
		super();
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

		return "Pawns move straight forward one current, if that current is vacant. If it has not yet moved, a pawn also has the option of moving two squares straight forward, provided both squares are vacant.";
	}

}
