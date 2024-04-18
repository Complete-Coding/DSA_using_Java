
/**
 * Given an integer num, return a string representing
 * its hexadecimal representation. For negative
 * integers, two’s complement method is used.
 *
 * All the letters in the answer string should be
 * lowercase characters, and there should not be
 * any leading zeros in the answer except for the
 * zero itself.
 *
 * Note: You are not allowed to use any built-in
 * library method to directly solve this problem.
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
class ConvertNumberToHexadecimal {
    public static void main(String[] args) {
        ConvertNumberToHexadecimal converter = new ConvertNumberToHexadecimal();
        System.out.println("Output is: "
                + converter.toHex(156));
    }

    public String toHex(int num) {
        char[] hex = new char[] { '0', '1', '2',
                '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int rem = num % 16;
            sb.insert(0, hex[rem]);
            num /= 16;
        }
        return sb.toString();
    }
}
