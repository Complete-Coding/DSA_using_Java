package in.knowledgegate.dsa.strings;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings. If there is no common prefix, return an empty string "".
 * <p>
 * Example 1: Input: strs = ["flower","flow","flight"] Output: "fl"
 * <p>
 * Example 2: Input: strs = ["dog","racecar","car"] Output: "" Explanation:
 * There is no common prefix among the input strings.
 * <p>
 * <p>
 * Constraints: 1 <= strs.length <= 200 0 <= strs[i].length <= 200 strs[i]
 * consists of only lower-case English letters.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return result;
                }
            }
            result += strs[0].charAt(i);
        }
        return result;
    }
}
