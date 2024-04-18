
/**
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers. Given a string s, return true if it is a palindrome, or false
 * otherwise.
 * <p>
 * Example 1: Input: s = "A man, a plan, a canal: Panama" Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * <p>
 * Example 2: Input: s = "race a car" Output: false Explanation: "raceacar" is
 * not a palindrome.
 * <p>
 * Example 3: Input: s = " " Output: true Explanation: s is an empty string ""
 * after removing non-alphanumeric characters. Since an empty string reads the
 * same forward and backward, it is a palindrome.
 * <p>
 * <p>
 * Constraints: 1 <= s.length <= 2 * 105 s consists only of printable ASCII
 * characters.
 */
class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int beg = 0, end = s.length() - 1;
        while (beg < end) {
            int left = validChar(s.charAt(beg));
            int right = validChar(s.charAt(end));
            if (left == -1) {
                beg++;
            } else if (right == -1) {
                end--;
            } else if (left != right) {
                return false;
            } else {
                beg++;
                end--;
            }

        }
        return true;
    }

    private int validChar(char c) {
        if (c >= '0' && c <= '9')
            return c;
        if (c >= 'a' && c <= 'z')
            return c;
        if (c >= 'A' && c <= 'Z')
            return c - 'A' + 'a';
        return -1;
    }
}
