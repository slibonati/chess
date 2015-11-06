package chess.pieces;

import chess.Color;
import chess.Square;

public class Piece {
	
	protected Square square;
	protected Color color;
	
	public Piece(Color color) {
		super();
		this.color = color;
	}
	
	
	public Piece(Square square, Color color) {
		super();
		this.square = square;
		this.color = color;
	}


	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	
	
}
