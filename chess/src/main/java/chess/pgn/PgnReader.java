package chess.pgn;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class PgnReader {

	private Lexer lexer;
	private Parser parser;

	public PgnReader() {
		lexer = new Lexer();
		parser = new Parser();
	}

	public Pgn read(File file) throws Exception {

		return parser.parse(lexer.lex(FileUtils.readFileToString(file)));
	}

}
