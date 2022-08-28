import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {

    // You must use this palindrome, and not instantiate)
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        OffByOne offByOne = new OffByOne();
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertFalse(palindrome.isPalindrome("mike"));
        assertFalse(palindrome.isPalindrome("curry"));
        assertFalse(palindrome.isPalindrome("curry", offByOne));
    }
    // } Uncomment this class once you've created your Palindrome class. 
}
