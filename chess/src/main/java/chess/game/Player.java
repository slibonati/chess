package chess.game;

import chess.Color;

public class Player {

	private Color color;
	private String name;
	private Board board;

	public Player() {
		super();
	}

	public Player(Color color) {
		super();
		this.color = color;
	}

	public Player(Board board) {
		super();
		this.board = board;
	}

	public Player(Color color, Board board) {
		super();
		this.color = color;
		this.board = board;
	}

	public Player(Color color, String name, Board board) {
		super();
		this.color = color;
		this.name = name;
		this.board = board;
	}

	public void move(Move move) throws IllegalMoveException {

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
