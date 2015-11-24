package chess.pgn;

import java.util.ArrayList;
import java.util.List;

/**
 * A move number indication is composed of one or more adjacent digits (an
 * integer token) followed by zero or more periods. The integer portion of the
 * indication gives the move number of the immediately following white move (if
 * present) and also the immediately following black move (if present).
 *
 */
public class MoveNumberIndication {

	private List<Token> integers;
	//private List<Token> periods; 
	private List<Token> moves;
	

	public MoveNumberIndication() {
		super();
		integers = new ArrayList<Token>();
		//periods = new ArrayList<Token>();
		moves = new ArrayList<Token>();
	}

	public List<Token> getIntegers() {
		return integers;
	}

	public void setIntegers(List<Token> integers) {
		this.integers = integers;
	}
/*
	public List<Token> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Token> periods) {
		this.periods = periods;
	}
*/

	public List<Token> getMoves() {
		return moves;
	}

	public void setMoves(List<Token> moves) {
		this.moves = moves;
	}

	@Override
	public String toString() {
		return "MoveNumberIndication [integers=" + integers + ", moves=" + moves + "]";
	}
	

}
