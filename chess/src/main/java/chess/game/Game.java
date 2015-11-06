package chess.game;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import chess.Color;
import chess.Move;
import chess.Square;
import chess.algebra.Lexer;
import chess.algebra.Parser;
import chess.algebra.UnrecognizableNotationException;
import chess.algebra.UnrecognizedTokenException;
import chess.game.pieces.Bishop;
import chess.game.pieces.King;
import chess.game.pieces.Knight;
import chess.game.pieces.Pawn;
import chess.game.pieces.Piece;
import chess.game.pieces.Queen;
import chess.game.pieces.Rook;

public class Game {

	private final static String WHITE_PROMPT = "White to play ... ";
	private final static String BLACK_PROMPT = "Black to play ... ";

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
		player1 = new Player(board);
		player2 = new Player(board);
		board = new Board();
		setup(board);
	}

	public void play() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in).useDelimiter("\n");

		String prompt = WHITE_PROMPT;
		System.out.print(prompt);
		String input = scanner.nextLine();

		try {
			Move move = parser.parse(lexer.lex(input), Color.WHITE);
			
		
			// is move legal ? 
			// need the board, the move
			// if illegal, report, else push to stack and move, prompt
			
			
		} catch (UnrecognizedTokenException e) {
			System.out.println(e.getMessage());
		} catch (UnrecognizableNotationException e) {
			System.out.println(e.getMessage());
		}

		while (!input.equals("quit")) {
			System.out.println(input);

			if (prompt.equals(WHITE_PROMPT)) {
				prompt = BLACK_PROMPT;
			} else {
				prompt = WHITE_PROMPT;
			}

			System.out.print(prompt);
			input = scanner.nextLine();

			try {
				Move move = parser.parse(lexer.lex(input), Color.WHITE);
			} catch (UnrecognizedTokenException e) {
				System.out.println(e.getMessage());
			} catch (UnrecognizableNotationException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	private void setup(Board board) {
		String[] file = Board.fileToIndex.keySet().toArray(new String[Board.fileToIndex.size()]);
		Square square = null;
		for (int i = 0; i < file.length; i++) {
			square = new Square(file[i], 2);
			board.put(new Pawn(square, Color.WHITE), square);
			square = new Square(file[i], 7);
			board.put(new Pawn(square, Color.BLACK), square);
		}
		square = new Square("a", 1);
		board.put(new Rook(square, Color.WHITE), square);
		square = new Square("h", 1);
		board.put(new Rook(square, Color.WHITE), square);
		square = new Square("a", 8);
		board.put(new Rook(square, Color.BLACK), square);
		square = new Square("h", 8);
		board.put(new Rook(square, Color.BLACK), square);
		square = new Square("b", 1);
		board.put(new Knight(square, Color.WHITE), square);
		square = new Square("g", 1);
		board.put(new Knight(square, Color.WHITE), square);
		square = new Square("b", 8);
		board.put(new Knight(square, Color.BLACK), square);
		square = new Square("g", 8);
		board.put(new Knight(square, Color.BLACK), square);
		square = new Square("c", 1);
		board.put(new Bishop(square, Color.WHITE), square);
		square = new Square("f", 1);
		board.put(new Bishop(square, Color.WHITE), square);
		square = new Square("c", 8);
		board.put(new Bishop(square, Color.BLACK), square);
		square = new Square("f", 8);
		board.put(new Bishop(square, Color.BLACK), square);
		square = new Square("d", 1);
		board.put(new Queen(square, Color.WHITE), square);
		square = new Square("d", 8);
		board.put(new Queen(square, Color.BLACK), square);
		square = new Square("e", 1);
		board.put(new King(square, Color.WHITE), square);
		square = new Square("e", 8);
		board.put(new King(square, Color.BLACK), square);
	}
	/*
	private List<Piece> getCandidatePiece(Board board, Move move) {
		
	}
	*/

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
