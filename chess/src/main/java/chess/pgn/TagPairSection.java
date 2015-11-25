package chess.pgn;

import java.util.ArrayList;
import java.util.List;

public class TagPairSection {

	private List<TagPair> tagPairs;

	public TagPairSection() {
		super();
		tagPairs = new ArrayList<TagPair>();

	}

	public void add(TagPair tagPair) {
		tagPairs.add(tagPair);
	}

	public List<TagPair> getTagPairs() {
		return tagPairs;
	}

	public void setTagPairs(List<TagPair> tagPairs) {
		this.tagPairs = tagPairs;
	}

	@Override
	public String toString() {
		return "TagPairSection [tagPairs=" + tagPairs + "]";
	}
	
	
}
