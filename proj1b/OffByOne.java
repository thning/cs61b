public class OffByOne implements CharacterComparator {
	@Override
	public boolean equalChars(char c1, char c2) {
		int diff = c1 - c2;
		return (diff == 1) || (diff == -1);
	}
}
