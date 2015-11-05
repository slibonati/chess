package chess;

public class Square {

	private Integer rank;
	private String file;

	public Square(String file, Integer rank) {
		super();
		this.file = file;
		this.rank = rank;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

}
