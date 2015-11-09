package chess.game.rule;

import chess.game.MoveContext;

public class WrongTurnRule implements Rule {

	public WrongTurnRule() {
	}

	@Override
	public boolean isCompliant(MoveContext moveContext) {
		return moveContext.getMove().getColor() == moveContext.getPlayer().getColor();
	}

	@Override
	public String getMessage() {
		return "wrong turn";
	}

}
