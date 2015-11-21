package chess.pgn;

import java.io.File;

public class PgnReader {

	public PgnReader() {
		
	}
	
	public Pgn read(File file) {
		
		// read entire file in as a string 
		// lexical analysis into list of tokens using tokens defined at http://www6.chessclub.com/help/PGN-spec
		// parse tokens into properties of pgn object ? 
		
		// example [Event "Rosenwald Memorial Tournament"]
		
		// list of tokens : 
		// LEFT_BRACKET , [
		// SYMBOL, Event
		// STRING , "Rosenwald Memorial Tournament"
		// RIGHT_BRACKET, ]
		
		
		return null;
	}

}
