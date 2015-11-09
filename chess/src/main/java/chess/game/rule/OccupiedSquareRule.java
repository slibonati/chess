package chess.game.rule;

import chess.game.MoveContext;

public class OccupiedSquareRule implements Rule {

	public OccupiedSquareRule() {

	}

	@Override
	public boolean isCompliant(MoveContext moveContext) {
		return moveContext.getBoard().isEmpty(moveContext.getMove().getTo());
	}

	@Override
	public String getMessage() {
		return "square is occupied.";
	}

}
