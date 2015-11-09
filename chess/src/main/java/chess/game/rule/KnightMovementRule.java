package chess.game.rule;

import chess.game.MoveContext;

public class KnightMovementRule implements Rule {

	public KnightMovementRule() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isCompliant(MoveContext moveContext) {

		if (moveContext.getBoard().isOccupied(moveContext.getMove().getTo())) {
			return false;
		}

		return true;

	}

	@Override
	public String getMessage() {

		return "knight moves in an L pattern";
	}

}
