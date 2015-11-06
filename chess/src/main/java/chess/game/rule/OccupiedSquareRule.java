package chess.game.rule;

import chess.Board;
import chess.Move;

public class OccupiedSquareRule implements Rule {

	public OccupiedSquareRule() {

	}

	@Override
	public boolean isCompliant(Move move, Board board) {
		return board.isEmpty(move.getTo());
	}

}
