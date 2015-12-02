package chess.pgn;

import java.util.ArrayList;
import java.util.List;

import chess.UnrecognizedTokenException;

/**
 * @see http://www6.chessclub.com/help/PGN-spec
 *
 */
public class Lexer {

	private List<TokenLexer> tokenLexers;

	public Lexer() {
		super();

		tokenLexers = new ArrayList<TokenLexer>();
		tokenLexers.add(new CommentTokenLexer());
		tokenLexers.add(new StringTokenLexer());
		tokenLexers.add(new SymbolTokenLexer());
		tokenLexers.add(new NagTokenLexer());
		

	}

	public List<Token> lex(String input) throws UnrecognizedTokenException,
			InvalidPGNException {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("input is empty");
		}

		List<Token> result = new ArrayList<Token>();
		int size = 0;
		int pos = 0;
		for (char c : input.toCharArray()) {
			size = result.size();
			if (isPeriod(c)) {
				result.add(new Token(Type.PERIOD, String.valueOf(c)));
				continue;
			}
			if (isAsterisk(c)) {
				result.add(new Token(Type.ASTERISK, String.valueOf(c)));
				continue;
			}
			if (isLeftBracket(c)) {
				result.add(new Token(Type.LEFT_BRACKET, String.valueOf(c)));
				continue;
			}
			if (isRightBracket(c)) {
				result.add(new Token(Type.RIGHT_BRACKET, String.valueOf(c)));
				continue;
			}
			if (isLeftBrace(c)) {
				result.add(new Token(Type.LEFT_BRACE, String.valueOf(c)));
				continue;
			}
			
			if (isRightBrace(c)) {
				result.add(new Token(Type.RIGHT_BRACE, String.valueOf(c)));
				continue;
			}
			if (isLeftParen(c)) {
				result.add(new Token(Type.LEFT_PAREN, String.valueOf(c)));
				continue;
			}
			if (isRightParen(c)) {
				result.add(new Token(Type.RIGHT_PAREN, String.valueOf(c)));
				continue;
			}
			if (isLeftAngle(c)) {
				result.add(new Token(Type.LEFT_ANGLE, String.valueOf(c)));
				continue;
			}
			if (isRightAngle(c)) {
				result.add(new Token(Type.RIGHT_ANGLE, String.valueOf(c)));
				continue;
			}

			if (isDollarSign(c)) {
				result.add(new Token(Type.DOLLAR_SIGN, String.valueOf(c)));
				continue;
			}

			if (isWhiteSpace(c)) {
				result.add(new Token(Type.WHITE_SPACE, String.valueOf(c)));
				continue;
			}

			if (isQuote(c)) {
				result.add(new Token(Type.QUOTE, String.valueOf(c)));
				continue;
			}
			if (isDigit(c)) {
				result.add(new Token(Type.DIGIT, String.valueOf(c)));
				continue;
			}

			if (isDigit(c)) {
				result.add(new Token(Type.DIGIT, String.valueOf(c)));
				continue;
			}

			if (isLetter(c)) {
				result.add(new Token(Type.LETTER, String.valueOf(c)));
				continue;
			}

			if (isUnderscore(c)) {
				result.add(new Token(Type.UNDERSCORE, String.valueOf(c)));
				continue;
			}
			if (isPlus(c)) {
				result.add(new Token(Type.PLUS, String.valueOf(c)));
				continue;
			}
			if (isHash(c)) {
				result.add(new Token(Type.HASH, String.valueOf(c)));
				continue;
			}

			if (isEqual(c)) {
				result.add(new Token(Type.EQUAL, String.valueOf(c)));
				continue;
			}

			if (isColon(c)) {
				result.add(new Token(Type.COLON, String.valueOf(c)));
				continue;
			}

			if (isHyphen(c)) {
				result.add(new Token(Type.HYPHEN, String.valueOf(c)));
				continue;
			}
			
			if (isPrintingCharacter(c)) {
				result.add(new Token(Type.PRINTING_CHAR, String.valueOf(c)));
				continue;
			}
			
			if (result.size() == size) { // result did not increase by 1
				throw new UnrecognizedTokenException(" unrecognized token: " + String.valueOf(c) + " at position: " + pos);
			}
			pos++;
		}

		for (TokenLexer tokenLexer : tokenLexers) {
			result = tokenLexer.lex(result);
		}

		return result;

	}

	private boolean isPeriod(final char input) {
		return input == '.';
	}

	private boolean isAsterisk(final char input) {
		return input == '*';
	}

	private boolean isLeftBracket(final char input) {
		return input == '[';
	}

	private boolean isRightBracket(final char input) {
		return input == ']';
	}

	private boolean isLeftParen(final char input) {
		return input == '(';
	}

	private boolean isRightParen(final char input) {
		return input == ')';
	}
	
	private boolean isLeftBrace(final char input) {
		return input == '{';
	}

	private boolean isRightBrace(final char input) {
		return input == '}';
	}

	private boolean isLeftAngle(final char input) {
		return input == '<';
	}

	private boolean isRightAngle(final char input) {
		return input == '>';
	}

	private boolean isDollarSign(final char input) {
		return input == '$';
	}

	private boolean isQuote(final char input) {
		return input == '"';
	}

	private boolean isWhiteSpace(final char input) {
		return input == ' ' || input == '\n' || input == '\t' || input == '\r';
	}

	private boolean isDigit(final char input) {
		return Character.isDigit(input);
	}

	private boolean isLetter(final char input) {
		return Character.isLetter(input);
	}

	private boolean isPlus(final char input) {
		return input == '+';
	}

	private boolean isHash(final char input) {
		return input == '#';
	}

	private boolean isEqual(final char input) {
		return input == '_';
	}

	private boolean isColon(final char input) {
		return input == ':';
	}

	private boolean isHyphen(final char input) {
		return input == '-';
	}

	private boolean isUnderscore(final char input) {
		return input == '_';
	}

	private boolean isPrintingCharacter(final char ch) {
		return ch >= 32 && ch < 127;
	}

}