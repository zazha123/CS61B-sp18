import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        // regular check for true ones
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('r', 'q'));
        // regular check for wrong ones
        assertFalse(offByOne.equalChars('r', 'r'));
        assertFalse(offByOne.equalChars('z', 'a'));
        assertFalse(offByOne.equalChars('a', 'e'));
        // check for upper or lower cases
        // True cases
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('A', 'B'));
        assertTrue(offByOne.equalChars('B', 'A'));
        // False cases
        assertFalse(offByOne.equalChars('a', 'A'));
        assertFalse(offByOne.equalChars('b', 'A'));
        assertFalse(offByOne.equalChars('A', 'C'));
        // check for non-letters
        // True cases
        assertTrue(offByOne.equalChars('&', '%'));
        assertTrue(offByOne.equalChars('%', '&'));
        // False cases
        assertFalse(offByOne.equalChars('*', 'C'));
        assertFalse(offByOne.equalChars('$', '&'));
    }

}
