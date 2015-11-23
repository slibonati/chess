package chess.algebra;

import java.util.ArrayList;
import java.util.List;

import chess.UnrecognizedTokenException;
import chess.algebra.Token;

public class Lexer {

	private final List<String> pieces;

	public Lexer() {
		super();
		pieces = new ArrayList<String>();
		pieces.add("K");
		pieces.add("Q");
		pieces.add("N");
		pieces.add("B");
		pieces.add("R");
	}

	public List<Token> lex(String input) throws UnrecognizedTokenException {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("input is empty");
		}

		List<Token> result = new ArrayList<Token>();
		int size = 0;
		for (char c : input.toCharArray()) {
			
			size = result.size();
			if (isPiece(c)) {
				result.add(new Token(Type.PIECE, String.valueOf(c)));
				continue;
			}
			if (isRank(c)) {
				result.add(new Token(Type.RANK, String.valueOf(c)));
				continue;
			}
			if (isFile(c)) {
				result.add(new Token(Type.FILE, String.valueOf(c)));
				continue;
			}
			if (isTakes(c)) {
				result.add(new Token(Type.TAKES, String.valueOf(c)));
			}
			if (isCheck(c)) {
				result.add(new Token(Type.CHECK, String.valueOf(c)));
				continue;
			}
			if (isCheckmate(c)) {
				result.add(new Token(Type.CHECKMATE, String.valueOf(c)));
				continue;
			}
			if (isCastle(c)) {
				result.add(new Token(Type.CASTLE, String.valueOf(c)));
				continue;
			}
			if (isPromote(c)) {
				result.add(new Token(Type.PROMOTE, String.valueOf(c)));
				continue;
			}
			if (isDash(c)) {
				result.add(new Token(Type.DASH, String.valueOf(c)));
				continue;
			}
			
			if (result.size() == size) { // result did not increase by 1
				throw new UnrecognizedTokenException(String.valueOf(c) + " unrecognized from " + "'" + input +"'");
			}
		}
		
		return result;
	}

	private boolean isRank(final char input) {

		if (!Character.isDigit(input)) {
			return false;
		}
		Integer value = Integer.valueOf(String.valueOf(input));
		return (value >= 1 && value <= 8);
	}

	private boolean isFile(final char input) {
		if (!Character.isLetter(input)) {
			return false;
		}
		return (input >= 'a' && input <= 'h');
	}

	private boolean isPiece(final char input) {
		return pieces.contains(String.valueOf(input));
	}

	private boolean isTakes(final char input) {
		return input == 'x';
	}

	private boolean isCheck(final char input) {
		return input == '+';
	}

	private boolean isCheckmate(final char input) {
		return input == '#';
	}

	private boolean isCastle(final char input) {
		return input == '0';
	}

	private boolean isPromote(final char input) {
		return input == '=';
	}

	private boolean isDash(final char input) {
		return input == '-';
	}
	
}
