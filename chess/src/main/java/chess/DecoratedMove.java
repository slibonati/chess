package chess;

import chess.game.pieces.Piece;

public class DecoratedMove {

	private Piece piece;
	private Move move;

	public DecoratedMove(Move move) {
		this.move = move;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

}
