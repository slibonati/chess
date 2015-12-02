package chess.game;

public class Move {

	private Color color;
	private String piece;
	private String promote;
	private Square to;
	private boolean capture;
	private boolean castle;
	private boolean check;
	private boolean checkmate;
	private Square disambiguity;
	
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

	public Move(Color color, String piece, Square to, boolean castle) {
		super();
		this.color = color;
		this.piece = piece;
		this.to = to;
		this.castle = castle;
	}

	public Move(Color color, String piece, String promote, Square to) {
		super();
		this.color = color;
		this.piece = piece;
		this.promote = promote;
		this.to = to;
	}

	public Move(Color color, String piece, Square to, Square disambiguity) {
		super();
		this.color = color;
		this.piece = piece;
		this.to = to;
		this.disambiguity = disambiguity;
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

	public boolean isCapture() {
		return capture;
	}

	public void setCapture(boolean capture) {
		this.capture = capture;
	}
	
	

	public boolean isCastle() {
		return castle;
	}

	public void setCastle(boolean castle) {
		this.castle = castle;
	}
	
	
	public Square getDisambiguity() {
		return disambiguity;
	}

	public void setDisambiguity(Square disambiguity) {
		this.disambiguity = disambiguity;
	}

	
	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
	
	

	public boolean isCheckmate() {
		return checkmate;
	}

	public void setCheckmate(boolean checkmate) {
		this.checkmate = checkmate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (capture ? 1231 : 1237);
		result = prime * result + (castle ? 1231 : 1237);
		result = prime * result + (check ? 1231 : 1237);
		result = prime * result + (checkmate ? 1231 : 1237);
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((disambiguity == null) ? 0 : disambiguity.hashCode());
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
		if (capture != other.capture)
			return false;
		if (castle != other.castle)
			return false;
		if (check != other.check)
			return false;
		if (checkmate != other.checkmate)
			return false;
		if (color != other.color)
			return false;
		if (disambiguity == null) {
			if (other.disambiguity != null)
				return false;
		} else if (!disambiguity.equals(other.disambiguity))
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
		return "Move [color=" + color + ", piece=" + piece + ", promote=" + promote + ", to=" + to + ", capture="
				+ capture + ", castle=" + castle + ", check=" + check + ", checkmate=" + checkmate + ", disambiguity="
				+ disambiguity + "]";
	}


	

}