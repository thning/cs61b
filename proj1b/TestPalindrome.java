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
        assertFalse(palindrome.isPalindrome("Noon"));
        assertTrue(palindrome.isPalindrome("NooN"));
        assertTrue(palindrome.isPalindrome("'dd'"));
        assertFalse(palindrome.isPalindrome(",kk."));
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertFalse(palindrome.isPalindrome("mike"));
        assertFalse(palindrome.isPalindrome("curry"));
        assertFalse(palindrome.isPalindrome("curry", offByOne));
        assertTrue(palindrome.isPalindrome("&%", offByOne));
        assertFalse(palindrome.isPalindrome("?^^%", offByOne));
        assertTrue(palindrome.isPalindrome("ACDB", offByOne));
        assertFalse(palindrome.isPalindrome("Acdb", offByOne));
        assertTrue(palindrome.isPalindrome("asdfgfdsa"));
        assertFalse(palindrome.isPalindrome("asdfwgebgea"));
    }
    // } Uncomment this class once you've created your Palindrome class. 
}
