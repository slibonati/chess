package chess.game;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import chess.Color;
import chess.game.pieces.Piece;

public class Board {

	private Piece[][] board;

	public static Map<String, Integer> fileToIndex;
	public static List<String> files;

	public Board() {
		super();

		fileToIndex = new LinkedHashMap<String, Integer>();

		fileToIndex.put("a", 0);
		fileToIndex.put("b", 1);
		fileToIndex.put("c", 2);
		fileToIndex.put("d", 3);
		fileToIndex.put("e", 4);
		fileToIndex.put("f", 5);
		fileToIndex.put("g", 6);
		fileToIndex.put("h", 7);

		files = new ArrayList<String>(fileToIndex.keySet());
		
		board = new Piece[8][8];

	}

	public void put(Piece piece, Square square) {

		board[fileToIndex.get(square.getFile())][square.getRank() - 1] = piece;
	};

	public Piece get(Square square) {

		return board[fileToIndex.get(square.getFile())][square.getRank() - 1];
	};

	public void clear(Square square) {

		board[fileToIndex.get(square.getFile())][square.getRank() - 1] = null;
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

	public String incrementFileBy(String file, Integer addend) throws BoundaryException {
		Integer index = fileToIndex.get(file);

		if (index == null) {
			throw new BoundaryException(file + " is out of bounds");
		}
		String f;
		try {
			f = files.get(index + addend);
		} catch (IndexOutOfBoundsException e) {
			throw new BoundaryException(file + " incremented by " + addend + " is out of bounds");
		}

		return f;
	}
	
	public Integer incrementRankBy(Integer rank, Integer addend) throws BoundaryException {
	
		if (rank < 1 || rank > 8 ) {
			throw new BoundaryException(rank + " is out of bounds");
		}
		Integer r;
		
			r = rank + addend;
		if (r > 8) {
			throw new BoundaryException(rank + " incremented by " + addend + " is out of bounds");
		}

		return r;
	}

	public String decrementFileBy(String file, Integer subtrahend) throws BoundaryException {

		Integer index = fileToIndex.get(file);
		if (index == null) {
			throw new BoundaryException(file + " is out of bounds");
		}
		String f;
		try {
			f = files.get(index - subtrahend);
		} catch (IndexOutOfBoundsException e) {
			throw new BoundaryException(file + " decremented by " + subtrahend + " is out of bounds");
		}

		return f;
	}
	
	public Integer decrementRankBy(Integer rank, Integer subtrahend) throws BoundaryException {
		
		if (rank < 1 || rank > 8 ) {
			throw new BoundaryException(rank + " is out of bounds");
		}
		Integer r;
		
		r = rank - subtrahend;
		if (r < 1) {
			throw new BoundaryException(rank + " decremented by " + subtrahend + " is out of bounds");
		}

		return r;
	}

	String getPreviousFile(String file) {
		return null;
	}

	String getNextFile(String file) {
		return null;
	}
}
