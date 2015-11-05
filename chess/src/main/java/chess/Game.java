package chess;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import chess.algebra.Lexer;
import chess.algebra.Parser;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class Game {

	private final static String WHITE_PROMPT = "White to move ... ";
	private final static String BLACK_PROMPT = "Black to move ... ";
	
	private Lexer lexer;
	private Parser parser;
	
	private Player player1;
	private Player player2;
	
	private Board board;
	private Stack<Move> moves;

	private List<Piece> pieces;

	public Game() {
		super();
		
		lexer = new Lexer();
		parser = new Parser();
		
		board = new Board();
		setup(board);

	}

	public void play() {
		Scanner scanner = new Scanner(System.in).useDelimiter("\n");
		String prompt = WHITE_PROMPT;
		System.out.print(prompt);
		String input = scanner.nextLine();

		Move move = parser.parse(lexer.lex(input), Color.WHITE);

		while (!input.equals("quit")) {
			System.out.println(input);

			if (prompt.equals(WHITE_PROMPT)) {
				prompt = BLACK_PROMPT;
			} else {
				prompt = WHITE_PROMPT;
			}

			System.out.print(prompt);
			input = scanner.nextLine();
		}

		scanner.close();

	}

	private void setup(Board board) {
		String[] file = Board.algebratoArrayFile.keySet().toArray(new String[Board.algebratoArrayFile.size()]);

		for (int i = 0; i < file.length; i++) {
			board.put(new Pawn(Color.WHITE), new Square(file[i], 2));
			board.put(new Pawn(Color.BLACK), new Square(file[i], 7));
		}

		board.put(new Rook(Color.WHITE), new Square("a", 1));
		board.put(new Rook(Color.WHITE), new Square("h", 1));

		board.put(new Rook(Color.BLACK), new Square("a", 8));
		board.put(new Rook(Color.BLACK), new Square("h", 8));

		board.put(new Knight(Color.WHITE), new Square("b", 1));
		board.put(new Knight(Color.WHITE), new Square("g", 1));

		board.put(new Knight(Color.BLACK), new Square("b", 8));
		board.put(new Knight(Color.BLACK), new Square("g", 8));

		board.put(new Bishop(Color.WHITE), new Square("c", 1));
		board.put(new Bishop(Color.WHITE), new Square("f", 1));

		board.put(new Bishop(Color.BLACK), new Square("c", 8));
		board.put(new Bishop(Color.BLACK), new Square("f", 8));

		board.put(new Queen(Color.WHITE), new Square("d", 1));
		board.put(new Queen(Color.BLACK), new Square("d", 8));

		board.put(new King(Color.WHITE), new Square("e", 1));
		board.put(new King(Color.BLACK), new Square("e", 8));
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
