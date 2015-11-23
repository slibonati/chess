package chess.pgn;

import java.util.List;

import chess.UnrecognizedTokenException;

public interface TokenLexer {

	public abstract List<Token> lex(List<Token> input)
			throws UnrecognizedTokenException, InvalidPGNException;

}