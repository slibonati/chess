package chess.pgn;

public class PgnGame {
	
	private TagPairSection tagPairSection;
	private MovetextSection movetextSection;
	
	public PgnGame() {
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
