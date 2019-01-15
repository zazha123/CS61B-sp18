public class Palindrome {
    /* 
    * return a Deque of Character of word
    * The Deque is the same order of the word.
    */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> L = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i += 1) {
            char iChar = word.charAt(i);
            L.addLast(iChar);
        }
        return L;
    }

    /* 
    * return true if the word is a Palindrome
    * otherwise return false
    */
    public boolean isPalindrome(String word) {
        Palindrome palindrome = new Palindrome();
        Deque<Character> L = palindrome.wordToDeque(word);
        for (int i = 0; i < L.size() / 2; i += 1) {
            if (L.removeFirst() != L.removeLast()) {
                return false; 
            }
        }
        return true;
    }

     public boolean isPalindrome(String word, CharacterComparator cc) {
        Palindrome palindrome = new Palindrome();
        Deque<Character> L = palindrome.wordToDeque(word);
        for (int i = 0; i < L.size() / 2; i += 1) {
            if (!cc.equalChars(L.removeFirst(), L.removeLast())) {
                return false; 
            }
        }
        return true;
    }
}