package chess.game.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.game.Board;
import chess.game.BoundaryException;
import chess.game.Color;
import chess.game.MoveContext;
import chess.game.Square;
import chess.game.rule.KnightMovementRule;

public class Knight extends Piece {

	public Knight() {
		super();
		this.rules.add(new KnightMovementRule(this));
	}

	public Knight(Color color) {
		super(color);
	}

	public Knight(Square square, Color color) {
		super(square, color);
	}

	@Override
	public String toString() {
		return "N[" + color + "]";
	}
	
	@Override
	public String toAlgebraicRepresentation() {
		return "N";
	}



	@Override
	public String toDetailedString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Square> reachable(MoveContext moveContext) {
		
		List<Square> allowable = new ArrayList<Square>();

		//List<Square> potential = new ArrayList<Square>();

		Integer r;
		String f;
		Square to;
		Board board = moveContext.getBoard(); 

		// example d4

		try {
			r = board.incrementRankBy(current.getRank(), 2);
			f = board.incrementFileBy(current.getFile(), 1);

			to = new Square(f, r); // e6

			allowable.add(to);

		} catch (BoundaryException e) {

		}

		try {

			r = board.incrementRankBy(current.getRank(), 1);
			f = board.incrementFileBy(current.getFile(), 2);

			to = new Square(f, r); // f5

			allowable.add(to);

		} catch (BoundaryException e) {

		}

		try {
			r = board.incrementRankBy(current.getRank(), 2);
			f = board.decrementFileBy(current.getFile(), 1);

			to = new Square(f, r); // c6

			allowable.add(to);
		} catch (BoundaryException e) {

		}

		try {
			r = board.incrementRankBy(current.getRank(), 1);
			f = board.decrementFileBy(current.getFile(), 2);

			to = new Square(f, r); // b5

			allowable.add(to);
		} catch (BoundaryException e) {

		}

		try {

			r = board.decrementRankBy(current.getRank(), 1);
			f = board.decrementFileBy(current.getFile(), 2);
			to = new Square(f, r); // b3

			allowable.add(to);
		} catch (BoundaryException e) {

		}

		try {
			r = board.decrementRankBy(current.getRank(), 1);
			f = board.incrementFileBy(current.getFile(), 2);

			to = new Square(f, r); // f3

			allowable.add(to);

		} catch (BoundaryException e) {

		}

		try {
			r = board.decrementRankBy(current.getRank(), 2);
			f = board.incrementFileBy(current.getFile(), 1);

			to = new Square(f, r); // e2

			allowable.add(to);
		} catch (BoundaryException e) {

		}

		try {
			r = board.decrementRankBy(current.getRank(), 2);
			f = board.decrementFileBy(current.getFile(), 1);

			to = new Square(f, r); // c2

			allowable.add(to);

		} catch (BoundaryException e) {

		}

		/*
		 * for (Square s : potential) {
			allowable.add(s);
		}
		*/

		return allowable;
	}

}
