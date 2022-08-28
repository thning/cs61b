public class OffByN implements CharacterComparator {
    private int n;

    public OffByN(int n) {
        this.n = n;
    }
    @Override
    public boolean equalChars(char c1, char c2) {
        int diff = c1 - c2;
        return (diff == n) || (diff == -n);
    }

}
