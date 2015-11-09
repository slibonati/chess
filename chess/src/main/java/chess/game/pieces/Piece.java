package chess.game.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.Color;
import chess.game.Square;
import chess.game.rule.Rule;

public abstract class Piece {

	protected List<Square> reachableSquares = new ArrayList<Square>();
	protected List<Rule> rules = new ArrayList<Rule>();

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
	
	
	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	public abstract List<Square> getReachableSquares();

	
	public abstract String toDetailedString();
	
	

}
