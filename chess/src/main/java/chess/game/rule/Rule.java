package chess.game.rule;

import chess.Board;
import chess.Move;

public interface Rule {

	public boolean isCompliant(Move move, Board board);

}
