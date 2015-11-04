package chess;

public class Square {

	private int rank;
	private char file;

	public Square(char file, int rank) {
		super();
		this.file = file;
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public char getFile() {
		return file;
	}

	public void setFile(char file) {
		this.file = file;
	}

}
