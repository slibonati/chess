package chess.game;

import chess.Board;
import chess.Color;
import chess.Move;

public class Player {
	
	private Color color;
	private String name;
	private Board board;
	
	
	public Player(Board board) {
		super();
		this.board = board;
	}

	public void move(Move move) throws IllegalMoveException {
		if (move.isLegal(board)) {
			
		} else {
			throw new IllegalMoveException();
		}
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
