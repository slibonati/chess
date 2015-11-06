package chess.game.rule;

import chess.Move;
import chess.game.Board;

public class WrongTurnRule implements Rule {

	public WrongTurnRule() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isCompliant(Move move, Board board) {
	
		return false;
	}

}
