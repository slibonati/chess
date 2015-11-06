package chess.game.rule;

import chess.Color;
import chess.Move;
import chess.game.Board;
import chess.game.pieces.Piece;

public class BackwardMovementRule implements Rule {

	private Piece piece;

	public BackwardMovementRule(Piece piece) {
		super();
		this.piece = piece;
	}

	@Override
	public boolean isCompliant(Move move, Board board) {
		if (piece.getColor() == Color.WHITE) {
			return (move.getTo().getRank() > piece.getSquare().getRank());
		} else {
			return (move.getTo().getRank() < piece.getSquare().getRank());
		}
		
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

}
