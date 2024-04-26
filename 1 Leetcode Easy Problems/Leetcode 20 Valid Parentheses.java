
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid. An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order.
 * <p>
 * <p>
 * Example 1: Input: s = "()" Output: true
 * <p>
 * Example 2: Input: s = "()[]{}" Output: true
 * <p>
 * Example 3: Input: s = "(]" Output: false
 * <p>
 * Constraints: 1 <= s.length <= 104 s consists of parentheses only '()[]{}'.
 */
class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if (stack.isEmpty() || '{' != stack.pop()) {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || '[' != stack.pop()) {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || '(' != stack.pop()) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}
