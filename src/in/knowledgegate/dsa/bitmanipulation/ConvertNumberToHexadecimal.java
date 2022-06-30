package in.knowledgegate.dsa.bitmanipulation;

/**
 * Given an integer num, return a string
 * representing its hexadecimal representation.
 * For negative integers, two’s complement method
 * is used.
 *
 * All the letters in the answer string should be
 * lowercase characters, and there should not be
 * any leading zeros in the answer except for the
 * zero itself.
 *
 * Note: You are not allowed to use any built-in
 * library method to directly solve this problem.
 *
 *
 * Example 1:
 * Input: num = 26
 * Output: "1a"
 *
 * Example 2:
 * Input: num = -1
 * Output: "ffffffff"
 *
 * Constraints:
 * -231 <= num <= 231 - 1
 */
public class ConvertNumberToHexadecimal {
    public static void main(String[] args) {
        ConvertNumberToHexadecimal converter =
            new ConvertNumberToHexadecimal();
        System.out.println("Hex num is: "
            + converter.toHex(26));
    }

    public String toHex(int num) {
        char[] mapping = new char[]{'0', '1', '2'
            , '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f'};
        if (num == 0) return "0";
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int endBits = num & 15;
            result.insert(0, mapping[endBits]);
            num = num >> 4;
        }
        return result.toString();
    }
}
