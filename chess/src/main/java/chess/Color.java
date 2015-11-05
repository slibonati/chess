package chess;

public enum Color {
	BLACK, WHITE;

	@Override
	public String toString() {
		 return name().substring(0, 1).toLowerCase();
	}



}
