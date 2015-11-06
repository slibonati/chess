package chess.game.pieces;

import java.util.List;

import chess.Color;
import chess.Square;
import chess.game.rule.BackwardMovementRule;

public class Pawn extends Piece {

	public Pawn() {
		super();
		rules.add(new BackwardMovementRule(this));
	}

	public Pawn(Color color) {
		super(color);
	}

	public Pawn(Square square, Color color) {
		super(square, color);
	}

	@Override
	public String toString() {
		return "P[" + color + "]";
	}

	@Override
	public List<Square> getReachableSquares() {
		// TODO Auto-generated method stub
		return null;
	}

}
