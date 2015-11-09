package chess.game.rule;

import chess.game.MoveContext;

public interface Rule {

	public boolean isCompliant(MoveContext moveContext);

	public String getMessage();

}
