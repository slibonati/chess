package chess.pgn;

import java.util.ArrayList;
import java.util.List;

public class MovetextSection {
	
	private List<String> moves;
	private List<MoveNumberIndication> moveNumberIndications;
	/*
	 * Each movetext section has exactly one game termination marker; the marker
	 * always occurs as the last element in the movetext.
	 */
	private String gameTerminationMarker;

	public MovetextSection() {
		moves = new ArrayList<String>();
		moveNumberIndications = new ArrayList<MoveNumberIndication>();
	}

	public List<String> getMoves() {
		return moves;
	}

	public void setMoves(List<String> moves) {
		this.moves = moves;
	}

	public List<MoveNumberIndication> getMoveNumberIndications() {
		return moveNumberIndications;
	}

	public void setMoveNumberIndications(List<MoveNumberIndication> moveNumberIndications) {
		this.moveNumberIndications = moveNumberIndications;
	}

	public String getGameTerminationMarker() {
		return gameTerminationMarker;
	}

	public void setGameTerminationMarker(String gameTerminationMarker) {
		this.gameTerminationMarker = gameTerminationMarker;
	}
	
	
}
