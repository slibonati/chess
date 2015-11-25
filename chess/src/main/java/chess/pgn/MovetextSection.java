package chess.pgn;

import java.util.ArrayList;
import java.util.List;

public class MovetextSection {
	
	private List<Token> moves;
	private List<MoveNumberIndication> moveNumberIndications;
	/*
	 * Each movetext section has exactly one game termination marker; the marker
	 * always occurs as the last element in the movetext.
	 */
	private Token gameTerminationMarker;

	public MovetextSection() {
		moves = new ArrayList<Token>();
		moveNumberIndications = new ArrayList<MoveNumberIndication>();
	}

	public List<Token> getMoves() {
		return moves;
	}

	public void setMoves(List<Token> moves) {
		this.moves = moves;
	}

	public List<MoveNumberIndication> getMoveNumberIndications() {
		return moveNumberIndications;
	}

	public void setMoveNumberIndications(List<MoveNumberIndication> moveNumberIndications) {
		this.moveNumberIndications = moveNumberIndications;
	}

	public Token getGameTerminationMarker() {
		return gameTerminationMarker;
	}

	public void setGameTerminationMarker(Token gameTerminationMarker) {
		this.gameTerminationMarker = gameTerminationMarker;
	}

	@Override
	public String toString() {
		return "MovetextSection [moves=" + moves + ", moveNumberIndications=" + moveNumberIndications
				+ ", gameTerminationMarker=" + gameTerminationMarker + "]";
	}	
	
}
