package chess.game.rule;

import chess.game.MoveContext;
import chess.game.Square;
import chess.game.pieces.Pawn;
import chess.game.pieces.Piece;

public class PawnMovementRule implements Rule {

	private Piece piece;

	public PawnMovementRule(Piece piece) {
		super();
		this.piece = piece;
	}

	@Override
	public boolean isCompliant(MoveContext moveContext) {

		if (Math.abs(moveContext.getMove().getTo().getRank() - piece.getSquare().getRank()) == 2) {
			if (moveContext.getBoard().isEmpty(moveContext.getMove().getTo())
					&& moveContext.getBoard().isEmpty(new Square(moveContext.getMove().getTo().getFile(), moveContext.getMove().getTo().getRank() - 1))) {
				if (!((Pawn) piece).isMovedTwoSquares()) {
					return true;
				}
			}
		} else if (Math.abs(moveContext.getMove().getTo().getRank() - piece.getSquare().getRank()) == 1) {
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
		
		return "Pawns move straight forward one square, if that square is vacant. If it has not yet moved, a pawn also has the option of moving two squares straight forward, provided both squares are vacant.";
	}

}
