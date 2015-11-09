package chess.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import chess.Color;
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
import chess.game.rule.Rule;
import chess.game.rule.WrongTurnRule;

public class Game {

	private Map<Color, String> colorToPrompt = new HashMap<Color, String>();

	private Lexer lexer;
	private Parser parser;

	private Player player1;
	private Player player2;
	private Player turn;

	private Board board;
	private Stack<Move> moves = new Stack<Move>();

	protected List<Rule> rules = new ArrayList<Rule>();

	public Game() {
		super();

		lexer = new Lexer();
		parser = new Parser();
		player1 = new Player(Color.WHITE, board);
		player2 = new Player(Color.BLACK, board);
		turn = player1;

		colorToPrompt.put(Color.WHITE, "White to play ... ");
		colorToPrompt.put(Color.BLACK, "Black to play ... ");

		rules.add(new WrongTurnRule());

		board = new Board();
		setup(board);
	}

	public void play() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in).useDelimiter("\n");

		String prompt = colorToPrompt.get(turn.getColor());
		System.out.print(prompt);
		String input = scanner.nextLine();
		turn(input);

		while (!input.equals("quit")) {

			prompt = colorToPrompt.get(turn.getColor());

			System.out.print(prompt);
			input = scanner.nextLine();
			if (input.equals("quit")) {
				continue;
			}
			turn(input);
		}

	}

	private void turn(final String input) {
		try {
			Move move = parser.parse(lexer.lex(input), turn.getColor());

			List<Square> candidates = getFromSquareCandidates(move);
			Piece piece = getPiece(candidates, board);

			if (piece == null) {
				throw new IllegalMoveException();
			}

			List<Rule> rules = new ArrayList<Rule>();
			rules.addAll(this.rules);
			rules.addAll(piece.getRules());

			for (Rule rule : rules) {
				if (!rule.isCompliant(new MoveContext(board, turn, move))) {
					throw new IllegalMoveException(rule.getMessage());
				}
			}

			move(piece, move, board);
			board.show();

			turn = turn.equals(player1) ? player2 : player1;

		} catch (UnrecognizedTokenException e) {
			System.out.println(e.getMessage());
		} catch (UnrecognizableNotationException e) {
			System.out.println(e.getMessage());
		} catch (IllegalMoveException e) {
			System.out.println(e.getMessage());
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

	private List<Square> getFromSquareCandidates(Move move) {

		List<Square> from = new ArrayList<Square>();

		if (move.getPiece().equals("")) {
			if (move.isCapture()) {

			} else {
				if (move.getColor().equals(Color.WHITE)) {

					from.add(new Square(move.getTo().getFile(), move.getTo().getRank() - 1));
					from.add(new Square(move.getTo().getFile(), move.getTo().getRank() - 2));
				}
				if (move.getColor().equals(Color.BLACK)) {
					from.add(new Square(move.getTo().getFile(), move.getTo().getRank() + 1));
					from.add(new Square(move.getTo().getFile(), move.getTo().getRank() + 2));
				}
			}
		}

		if (move.getPiece().equals("N")) {

		}

		return from;
	}

	private Piece getPiece(List<Square> candidates, Board board) {

		Piece piece = null;
		for (Square square : candidates) {
			piece = board.get(square);
			if (piece == null) {
				continue;
			}
		}
		return piece;
	}

	private void move(Piece piece, Move move, Board board) {

		board.clear(piece.getSquare());
		board.put(piece, move.getTo());
		piece.setSquare(move.getTo());
		moves.push(move);

		if (piece instanceof Pawn) {
			if (Math.abs(move.getTo().getRank() - piece.getSquare().getRank()) == 2) {
				((Pawn) piece).setMovedTwoSquares(true);
			}
		}
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
