package chess.algebra;

import java.util.ArrayList;
import java.util.List;

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

	public List<Token> lex(String input) {

		List<Token> result = new ArrayList<Token>();

		for (char c : input.toCharArray()) {

			if (isPiece(c)) {
				result.add(new Token(Type.PIECE, String.valueOf(c)));
			}
			if (isRank(c)) {
				result.add(new Token(Type.RANK, String.valueOf(c)));
			}
			if (isFile(c)) {
				result.add(new Token(Type.FILE, String.valueOf(c)));
			}
			if (isTakes(c)) {
				result.add(new Token(Type.TAKES, String.valueOf(c)));
			}
			if (isCheck(c)) {
				result.add(new Token(Type.CHECK, String.valueOf(c)));
			}
			if (isCheckmate(c)) {
				result.add(new Token(Type.CHECKMATE, String.valueOf(c)));
			}
			if (isCastle(c)) {
				result.add(new Token(Type.CASTLE, String.valueOf(c)));
			}
			if (isPromote(c)) {
				result.add(new Token(Type.PROMOTE, String.valueOf(c)));
			}
			if (isDash(c)) {
				result.add(new Token(Type.DASH, String.valueOf(c)));
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
