public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordsDeque = new LinkedListDeque();
        for(int i = 0; i < word.length(); i++) {
            wordsDeque.addLast(word.charAt(i));
        }
        return wordsDeque;
    }

    private boolean checkPalindrome(String word) { 
        if(word.length() < 2) {
            return true;
        }
        else {
            if(word.charAt(0) != word.charAt(word.length() - 1)){
                return false; 
            }
            else {
                return checkPalindrome(word.substring(1, word.length() - 1));
            }
        }
    }

    public boolean isPalindrome(String word) {
        return checkPalindrome(word);
        // for(int i = 0; i < word.length() / 2; i++) {
        //     if(word.charAt(i) != word.charAt(word.length()-1-i)){
        //         return false;
        //     }
        // }
        // return true;
    }

    public boolean isPalindrome(String word, OffByOne offByOne) {
        return checkOffByOne(word, offByOne);
    }

    private boolean checkOffByOne(String word, OffByOne offByOne) {
        if (word.length() < 2) {
            return true;
        } else {
            if (offByOne.equalChars(word.charAt(0), word.charAt(word.length() - 1))) {
                return checkOffByOne(word.substring(1, word.length() - 1), offByOne);
            } else {
                return false;
            }
        }
    }

}
