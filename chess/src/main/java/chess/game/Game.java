package chess.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import chess.algebra.Lexer;
import chess.algebra.Parser;
import chess.game.pieces.Bishop;
import chess.game.pieces.King;
import chess.game.pieces.Knight;
import chess.game.pieces.Pawn;
import chess.game.pieces.Piece;
import chess.game.pieces.Queen;
import chess.game.pieces.Rook;
import chess.game.rule.OccupiedSquareRule;
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
		rules.add(new OccupiedSquareRule());

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

			List<Piece> pieces = board.find(move.getColor(), move.getPiece());
			List<Piece> candidates = new ArrayList<Piece>();

			for (Piece p : pieces) {
				List<Square> allowable = p.reachable(new MoveContext(board, turn, move));
				if (allowable.contains(move.getTo())) {
					candidates.add(p);
				}
			}
			if (candidates.isEmpty()) {
				throw new IllegalMoveException();
			}
			if (candidates.size() > 1) {
				throw new AmbiguityException();
			}
			Piece piece = candidates.get(0);

			List<Rule> rules = new ArrayList<Rule>();
			rules.addAll(this.rules);
			rules.addAll(piece.getRules());

			for (Rule rule : rules) {
				if (!rule.isCompliant(new MoveContext(board, turn, move))) {
					throw new IllegalMoveException(rule.getMessage());
				}
			}
			
			if (move.isCastle()) {
				//castle(piece, move, board);
			} else {
				move(piece, move, board);
			}
			
			
			board.show();

			turn = turn.equals(player1) ? player2 : player1;

		} catch (Exception e) {
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

	private void move(Piece piece, Move move, Board board) {

		board.clear(piece.getCurrent());
		board.put(piece, move.getTo());
		piece.setCurrent(move.getTo());
		moves.push(move);

		if (piece instanceof Pawn) {
			if (Math.abs(move.getTo().getRank() - piece.getCurrent().getRank()) == 2) {
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