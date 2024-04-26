
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
class ConvertNumberToHexadecimal {
    public static void main(String[] args) {
        ConvertNumberToHexadecimal converter = new ConvertNumberToHexadecimal();
        System.out.println("Hex num is: "
                + converter.toHex(26));
    }

    public String toHex(int num) {
        if (num == 0)
            return "0";

        char[] mapping = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        StringBuilder result = new StringBuilder();

        // Process 32 bits, regardless of whether num is positive or negative
        for (int i = 0; i < 8; i++) {
            int endBits = num & 15;  // Get the last 4 bits
            result.insert(0, mapping[endBits]);  // Convert to hex and add to the front of the result
            num = num >>> 4;  // Logically shift right, filling with zeros (important for negative numbers)
        }

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }
}
