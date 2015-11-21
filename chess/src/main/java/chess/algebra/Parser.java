package chess.algebra;

import java.util.List;

import chess.algebra.matcher.LongCastleMatcher;
import chess.algebra.matcher.Matcher;
import chess.algebra.matcher.PawnMoveMatcher;
import chess.algebra.matcher.PieceMoveMatcher;
import chess.algebra.matcher.PromoteMatcher;
import chess.algebra.matcher.ShortCastleMatcher;
import chess.game.Color;
import chess.game.Move;
import chess.algebra.Token;

public class Parser {

	private Matcher matcher;

	public Parser() {
		super();

		PromoteMatcher promoteMatcher = new PromoteMatcher();
		LongCastleMatcher longCastleMatcher = new LongCastleMatcher();
		ShortCastleMatcher shortCastleMatcher = new ShortCastleMatcher();
		PieceMoveMatcher pieceMoveMatcher = new PieceMoveMatcher();
		PawnMoveMatcher pawnMoveMatcher = new PawnMoveMatcher();

		promoteMatcher.setNext(longCastleMatcher);
		longCastleMatcher.setNext(shortCastleMatcher);
		shortCastleMatcher.setNext(pieceMoveMatcher);
		pieceMoveMatcher.setNext(pawnMoveMatcher);

		matcher = promoteMatcher;

	}

	public Move parse(List<Token> input, Color color) throws UnrecognizableNotationException {
		return matcher.match(input, color);
	}

}