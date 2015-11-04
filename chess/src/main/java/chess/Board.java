package chess;

import java.util.Arrays;

public class Board {

	private Piece[][] board = new Piece[8][8];

	public char[] file = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
	public int[] rank = { 1, 2, 3, 4, 5, 6, 7, 8 };

	public Boolean isOccupied(Square square) {
		return false;
	}

	public void put(Piece piece, Square square) {

		board[Arrays.binarySearch(file, square.getFile())][square.getRank() - 1] = piece;
	};

	public void show() {

		for (int y = board.length - 1; y >= 0; y--) {
			
			for (int x = 0; x <= board.length - 1; x++) {
				
				//System.out.print("y=" + y + ", x=" + x);
				if (board[x][y] == null) {
					System.out.print("empty, ");
				} else {
					System.out.print(board[x][y] + ", ");
				}
			
			}
			System.out.println();
		}
	}

	public char[] getFile() {
		return file;
	}

	public void setFile(char[] file) {
		this.file = file;
	}

	public int[] getRank() {
		return rank;
	}
}
