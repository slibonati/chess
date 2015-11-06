package chess;

import chess.game.Board;

public class Move {

	private Color color;
	private String piece;
	private String promote;
	private Square to;
	boolean capture;

	public Move() {
		super();
	}

	public Move(String piece, Square to) {
		super();
		this.piece = piece;
		this.to = to;
	}

	public Move(Color color, String piece, Square to) {
		super();
		this.color = color;
		this.piece = piece;
		this.to = to;
	}

	public Move(Color color, String piece, String promote, Square to) {
		super();
		this.color = color;
		this.piece = piece;
		this.promote = promote;
		this.to = to;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getPiece() {
		return piece;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}

	public Square getTo() {
		return to;
	}

	public void setTo(Square to) {
		this.to = to;
	}

	public String getPromote() {
		return promote;
	}

	public void setPromote(String promote) {
		this.promote = promote;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((piece == null) ? 0 : piece.hashCode());
		result = prime * result + ((promote == null) ? 0 : promote.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Move other = (Move) obj;
		if (color != other.color)
			return false;
		if (piece == null) {
			if (other.piece != null)
				return false;
		} else if (!piece.equals(other.piece))
			return false;
		if (promote == null) {
			if (other.promote != null)
				return false;
		} else if (!promote.equals(other.promote))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Move [color=" + color + ", piece=" + piece + ", promote=" + promote + ", to=" + to + "]";
	}

}