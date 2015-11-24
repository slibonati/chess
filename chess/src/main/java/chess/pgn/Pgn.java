package chess.pgn;

/**
 * A PGN game is composed of two sections. The first is the tag pair section and
 * the second is the movetext section.
 *
 */
public class Pgn {
	/*
	 * The tag pair section is composed of a series of zero or more tag pairs.
	 */
	private TagPairSection tagPairSection;
	/*
	 * The movetext section is composed of chess moves, move number indications,
	 * optional annotations, and a single concluding game termination marker.
	 */
	private MovetextSection movetextSection;

	public Pgn() {
		tagPairSection = new TagPairSection();
		movetextSection = new MovetextSection();

	}

	public TagPairSection getTagPairSection() {
		return tagPairSection;
	}

	public void setTagPairSection(TagPairSection tagPairSection) {
		this.tagPairSection = tagPairSection;
	}

	public MovetextSection getMovetextSection() {
		return movetextSection;
	}

	public void setMovetextSection(MovetextSection movetextSection) {
		this.movetextSection = movetextSection;
	}

}
