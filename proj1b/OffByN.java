public class OffByN implements CharacterComparator {
    
    private int nOff;
    
    public OffByN(int n) {
        nOff = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (x - y == nOff || y - x == nOff) {
            return true;
        }
        return false;
    }
}