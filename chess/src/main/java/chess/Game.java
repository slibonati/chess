package chess;

import java.util.List;
import java.util.Stack;

import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class Game {

	public Board board;
	private Stack<Move> moves;

	private List<Piece> pieces;

	public Game() {
		super();
		board = new Board();
		setup(board);
	}

	private void setup(Board board) {
		
		for (int i = 0; i < board.getFile().length; i++) {
			board.put(new Pawn(Color.WHITE), new Square(board.getFile()[i], 2));
			board.put(new Pawn(Color.BLACK), new Square(board.getFile()[i], 7));
		}

		board.put(new Rook(Color.WHITE), new Square('a', 1));
		board.put(new Rook(Color.WHITE), new Square('h', 1));

		board.put(new Rook(Color.BLACK), new Square('a', 8));
		board.put(new Rook(Color.BLACK), new Square('h', 8));

		board.put(new Knight(Color.WHITE), new Square('b', 1));
		board.put(new Knight(Color.WHITE), new Square('g', 1));

		board.put(new Knight(Color.BLACK), new Square('b', 8));
		board.put(new Knight(Color.BLACK), new Square('g', 8));

		board.put(new Bishop(Color.WHITE), new Square('c', 1));
		board.put(new Bishop(Color.WHITE), new Square('f', 1));

		board.put(new Bishop(Color.BLACK), new Square('c', 8));
		board.put(new Bishop(Color.BLACK), new Square('f', 8));

		board.put(new Queen(Color.WHITE), new Square('d', 1));
		board.put(new Queen(Color.BLACK), new Square('d', 8));

		board.put(new King(Color.WHITE), new Square('e', 1));
		board.put(new King(Color.BLACK), new Square('e', 8));
	}

	public void move(Move move) {

	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
