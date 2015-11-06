package chess.game.rule;

import chess.Move;
import chess.game.Board;

public interface Rule {

	public boolean isCompliant(Move move, Board board);

}
