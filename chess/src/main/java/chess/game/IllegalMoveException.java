package chess.game;

public class IllegalMoveException extends Exception {

	private static final long serialVersionUID = 2198266838631688845L;

	public IllegalMoveException() {
		super("Illegal move");
	}

	public IllegalMoveException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public IllegalMoveException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public IllegalMoveException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IllegalMoveException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
