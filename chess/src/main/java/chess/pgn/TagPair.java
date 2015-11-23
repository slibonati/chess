package chess.pgn;

/**
 * A tag pair is composed of four consecutive tokens: a left bracket token, a
 * symbol token, a string token, and a right bracket token. 
 *
 */
public class TagPair {
	
	private Token leftBracketToken;
	private Token symbolToken;
	private Token stringToken;
	private Token rightBracketToken;
	
	public TagPair() {
		// TODO Auto-generated constructor stub
	}

	public Token getLeftBracketToken() {
		return leftBracketToken;
	}

	public void setLeftBracketToken(Token leftBracketToken) {
		this.leftBracketToken = leftBracketToken;
	}

	public Token getSymbolToken() {
		return symbolToken;
	}

	public void setSymbolToken(Token symbolToken) {
		this.symbolToken = symbolToken;
	}

	public Token getStringToken() {
		return stringToken;
	}

	public void setStringToken(Token stringToken) {
		this.stringToken = stringToken;
	}

	public Token getRightBracketToken() {
		return rightBracketToken;
	}

	public void setRightBracketToken(Token rightBracketToken) {
		this.rightBracketToken = rightBracketToken;
	}

	@Override
	public String toString() {
		return "TagPair [leftBracketToken=" + leftBracketToken
				+ ", symbolToken=" + symbolToken + ", stringToken="
				+ stringToken + ", rightBracketToken=" + rightBracketToken
				+ "]";
	}
	
	
	
}
