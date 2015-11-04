package chess;

import java.util.Scanner;

public class Main {

	private final static String WHITE_PROMPT = "White to move ... ";
	private final static String BLACK_PROMPT = "Black to move ... ";

	public static void main(String[] args) {

		Game game = new Game();
		// game.getBoard().show();

		Scanner scanner = new Scanner(System.in).useDelimiter("\n");
		String prompt = WHITE_PROMPT;
		System.out.print(prompt);
		String input = scanner.nextLine();
		
		
		// interpret algebra
		// you know the player, the piece, from and to
		// create a move
		// determine legality
		
		while (!input.equals("quit")) {
			System.out.println(input);

			if (prompt.equals(WHITE_PROMPT)) {
				prompt = BLACK_PROMPT;
			} else {
				prompt = WHITE_PROMPT;
			}

			System.out.print(prompt);
			input = scanner.nextLine();
		}

		scanner.close();

	}

}
