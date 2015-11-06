package chess.game.rule;

import chess.Move;
import chess.game.Board;

public class OccupiedSquareRule implements Rule {

	public OccupiedSquareRule() {

	}

	@Override
	public boolean isCompliant(Move move, Board board) {
		return board.isEmpty(move.getTo());
	}

}
