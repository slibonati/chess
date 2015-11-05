package chess;

import java.util.HashMap;
import java.util.Map;

import chess.pieces.Piece;

public class Board {

	private Piece[][] board;

	public static Map<String, Integer> algebratoArrayFile = new HashMap<String, Integer>();

	public Board() {
		super();

		algebratoArrayFile.put("a", 0);
		algebratoArrayFile.put("b", 1);
		algebratoArrayFile.put("c", 2);
		algebratoArrayFile.put("d", 3);
		algebratoArrayFile.put("e", 4);
		algebratoArrayFile.put("f", 5);
		algebratoArrayFile.put("g", 6);
		algebratoArrayFile.put("h", 7);

		board = new Piece[8][8];

	}

	public void put(Piece piece, Square square) {

		board[algebratoArrayFile.get(square.getFile())][square.getRank() - 1] = piece;
	};

	public void show() {

		for (int y = board.length - 1; y >= 0; y--) {

			for (int x = 0; x <= board.length - 1; x++) {
				if (board[x][y] == null) {
					System.out.print("empty, ");
				} else {
					System.out.print(board[x][y] + ", ");
				}

			}
			System.out.println();
		}
	}
}
