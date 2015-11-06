package chess.game;

import java.util.HashMap;
import java.util.Map;

import chess.Color;
import chess.Square;
import chess.game.pieces.Piece;

public class Board {

	private Piece[][] board;

	public static Map<String, Integer> fileToIndex = new HashMap<String, Integer>();

	public Board() {
		super();

		fileToIndex.put("a", 0);
		fileToIndex.put("b", 1);
		fileToIndex.put("c", 2);
		fileToIndex.put("d", 3);
		fileToIndex.put("e", 4);
		fileToIndex.put("f", 5);
		fileToIndex.put("g", 6);
		fileToIndex.put("h", 7);

		board = new Piece[8][8];

	}

	public void put(Piece piece, Square square) {

		board[fileToIndex.get(square.getFile())][square.getRank() - 1] = piece;
	};

	public boolean isOccupied(Square square) {

		return board[fileToIndex.get(square.getFile())][square.getRank() - 1] != null;
	};

	public boolean isEmpty(Square square) {

		return board[fileToIndex.get(square.getFile())][square.getRank() - 1] == null;
	};

	public void show() {

		for (int file = board.length - 1; file >= 0; file--) {

			for (int rank = 0; rank <= board.length - 1; rank++) {
				System.out.print(" | ");
				if (board[rank][file] == null) { // empty
					System.out.print("    ");
					if (rank == board.length - 1) {
						System.out.print(" | ");
					}

				} else {
					System.out.print(board[rank][file]);

					if (rank == board.length - 1) {
						System.out.print(" | ");
					}
				}
			}
			System.out.println("");
			// System.out.println("-----------------------------------------------------------");
		}
	}

	public Color getColor(Square square) {
		if ((square.getRank() % 2) == (fileToIndex.get(square.getFile()) % 2)) {
			return Color.WHITE;
		} else {
			return Color.BLACK;
		}
	}
}
