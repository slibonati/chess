package chess.game;

public class MoveContext {

	private Board board;
	private Player player;
	private Move move;
	
	
	
	public MoveContext(Board board, Player player, Move move) {
		super();
		this.board = board;
		this.player = player;
		this.move = move;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Move getMove() {
		return move;
	}
	public void setMove(Move move) {
		this.move = move;
	}

	
	

}
