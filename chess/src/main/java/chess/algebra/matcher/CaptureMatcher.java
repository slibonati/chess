package chess.algebra.matcher;

import java.util.List;

import chess.algebra.Token;
import chess.algebra.Type;
import chess.algebra.UnrecognizableNotationException;
import chess.game.Color;
import chess.game.Move;
import chess.game.Square;

public class CaptureMatcher implements Matcher {

	private Matcher next;

	@Override
	public Move match(List<Token> input, Color color) throws UnrecognizableNotationException {
		
		// exd4
		if (input.size() == 4 && input.get(0).getType() == Type.FILE && input.get(1).getType() == Type.CAPTURE
				&& input.get(2).getType() == Type.FILE && input.get(3).getType() == Type.RANK) {

			Move move = new Move(color, "",
					new Square(input.get(2).getValue(), Integer.valueOf(input.get(3).getValue())),
					new Square(input.get(0).getValue(), null));

			move.setCapture(true);

			return move;

		}
		
		//Nfxd5
		if (input.size() == 5 && input.get(0).getType() == Type.PIECE && input.get(1).getType() == Type.FILE && input.get(2).getType() == Type.CAPTURE
				&& input.get(3).getType() == Type.FILE && input.get(4).getType() == Type.RANK) {
			
			Square fileDisambiguity = new Square(input.get(1).getValue(), null);
			Move move = new Move(color, input.get(0).getValue(),
					new Square(input.get(3).getValue(), Integer.valueOf(input.get(4).getValue())) , fileDisambiguity);
			move.setCapture(true);
			return move;

		}

		// Qxf4

		if (input.size() == 4 && input.get(0).getType() == Type.PIECE && input.get(1).getType() == Type.CAPTURE
				&& input.get(2).getType() == Type.FILE && input.get(3).getType() == Type.RANK) {

			Move move = new Move(color, input.get(0).getValue(),
					new Square(input.get(2).getValue(), Integer.valueOf(input.get(3).getValue())));
			move.setCapture(true);
			;
			return move;

		}
		// Bxb5+
		if (input.size() == 5 && input.get(0).getType() == Type.PIECE && input.get(1).getType() == Type.CAPTURE
				&& input.get(2).getType() == Type.FILE && input.get(3).getType() == Type.RANK
				&& input.get(4).getType() == Type.CHECK) {

			Move move = new Move(color, input.get(0).getValue(),
					new Square(input.get(2).getValue(), Integer.valueOf(input.get(3).getValue())));
			move.setCapture(true);
			move.setCheck(true);
			return move;
		}
	
		if (next == null) {
			throw new UnrecognizableNotationException("Invalid algebraic chess notation: " + getValue(input));
		}
		return next.match(input, color);
	}

	@Override
	public void setNext(Matcher matcher) {
		this.next = matcher;
	}
}
