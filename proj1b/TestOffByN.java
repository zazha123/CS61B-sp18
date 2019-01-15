import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator comparator = new OffByN(2);

    @Test
    public void testEqualChars() {
        assertTrue(comparator.equalChars('a', 'c'));
        assertTrue(comparator.equalChars('s', 'q'));
     
        assertFalse(comparator.equalChars('r', 'r'));
        assertFalse(comparator.equalChars('z', 'a'));
        assertFalse(comparator.equalChars('a', 'e'));
    }

}
