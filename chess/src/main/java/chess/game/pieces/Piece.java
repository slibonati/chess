package chess.game.pieces;

import java.util.List;

import chess.Color;
import chess.Square;
import chess.game.rule.Rule;

public class Piece {

	protected List<Rule> rules;

	protected Square square;
	protected Color color;
	
	
	public Piece() {
		super();
	}

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
