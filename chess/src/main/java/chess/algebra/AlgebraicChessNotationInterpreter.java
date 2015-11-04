package chess.algebra;

import java.util.Arrays;
import java.util.List;

public class AlgebraicChessNotationInterpreter {

	public AlgebraicChessNotationMove interpret(String move) throws InvalidAlgebraicChessNotationException {

		String[] moveAsStringArray = move.split("");

		AlgebraicChessNotationMove algebraicChessNotationMove = new AlgebraicChessNotationMove();
		// Nc6

		if (move.length() == 3) {

			if (isValidRank(moveAsStringArray[2])) {
				algebraicChessNotationMove.setRank(moveAsStringArray[2]);
			} else {
				throw new InvalidAlgebraicChessNotationException("invalid algebraic chess notation: " + move);
			}

			if (isValidFile(moveAsStringArray[1])) {
				algebraicChessNotationMove.setFile(moveAsStringArray[1]);
			} else {
				throw new InvalidAlgebraicChessNotationException("invalid algebraic chess notation: " + move);
			}

			if (isValidPiece(moveAsStringArray[0])) {
				algebraicChessNotationMove.setPiece(moveAsStringArray[0]);
			} else {
				throw new InvalidAlgebraicChessNotationException("invalid algebraic chess notation: " + move);
			}

		}
		else {
			throw new InvalidAlgebraicChessNotationException("invalid algebraic chess notation: " + move);
		}

		return algebraicChessNotationMove;
	}

	private boolean isValidRank(final String rank) {

		char r = rank.charAt(0);

		if (!Character.isDigit(r)) {
			return false;
		}
		if (Character.getNumericValue(r) < 1 || Character.getNumericValue(r) > 8) {
			return false;
		}
		return true;

	}

	private boolean isValidFile(final String file) {

		char f = file.charAt(0);

		if (!Character.isLetter(f)) {
			return false;
		}
		if (f < 'a' || f > 'h') {
			return false;
		}
		return true;

	}

	private boolean isValidPiece(final String piece) {

		List<String> pieces = Arrays.asList(new String[] { "K", "Q", "N", "B", "R" });

		if (!Character.isLetter(piece.charAt(0))) {
			return false;
		}
		if (!pieces.contains(piece)) {
			return false;
		}
		return true;

	}

}
