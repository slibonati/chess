package chess;

public class Move {

	private Color color;
	private String piece;
	private String promote;
	private Square to;

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

}