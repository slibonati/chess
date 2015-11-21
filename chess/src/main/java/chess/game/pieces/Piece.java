package chess.game.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.game.Color;
import chess.game.MoveContext;
import chess.game.Square;
import chess.game.rule.Rule;

public abstract class Piece {

	protected List<Rule> rules = new ArrayList<Rule>();

	protected Square current;
	protected Color color;

	public Piece() {
		super();
	}

	public Piece(Color color) {
		super();
		this.color = color;
	}

	public Piece(Square current, Color color) {
		super();
		this.current = current;
		this.color = color;
	}

	public Square getCurrent() {
		return current;
	}

	public void setCurrent(Square square) {
		this.current = square;
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

	/**
	 * Computes reachable destination squares based on current position ignoring occupancy
	 * @param moveContext
	 * @return allowable destination squares
	 */
	public abstract List<Square> reachable(MoveContext moveContext);
	
	public abstract String toDetailedString();
	
	public abstract String toAlgebraicRepresentation();
	
	

}
