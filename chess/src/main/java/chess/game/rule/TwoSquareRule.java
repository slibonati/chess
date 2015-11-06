package chess.game.rule;

import chess.Color;
import chess.Move;
import chess.Square;
import chess.game.Board;
import chess.game.pieces.Piece;

public class TwoSquareRule implements Rule {

	private Piece piece;

	public TwoSquareRule(Piece piece) {
		super();
		this.piece = piece;
	}

	@Override
	public boolean isCompliant(Move move, Board board) {

		if (piece.getColor() == Color.WHITE) {
			if (piece.getSquare().getRank() == 2 && board.isEmpty(move.getTo())
					&& board.isEmpty(new Square(move.getTo().getFile(), move.getTo().getRank() - 1))) {
				return true;
			}

		} else {
			if (piece.getSquare().getRank() == 7 && board.isEmpty(move.getTo())
					&& board.isEmpty(new Square(move.getTo().getFile(), move.getTo().getRank() - 1))) {
				return true;
			}
		}

		return false;

	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

}
