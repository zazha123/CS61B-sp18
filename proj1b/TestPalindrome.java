import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String word1 = "racecar";
        String word2 = "sifhsoifhso";
        assertTrue(palindrome.isPalindrome(word1));
        assertFalse(palindrome.isPalindrome(word2));
    }

    @Test
    public void testIsPalindrome2() {
        CharacterComparator obo = new OffByOne();
        String word1 = "osifhofish";
        String word2 = "";
        String word3 = "abab";
        assertTrue(palindrome.isPalindrome(word2, obo));
        assertTrue(palindrome.isPalindrome(word3, obo));
        assertFalse(palindrome.isPalindrome(word1, obo));        
    }
}
