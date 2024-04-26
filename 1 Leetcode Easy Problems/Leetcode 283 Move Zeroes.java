
import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the
 * end of it while maintaining the relative order
 * of the non-zero elements.
 *
 * Note that you must do this in-place without making
 * a copy of the array.
 *
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 *
 * Constraints:
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 */
class MoveZeros {
    public static void main(String[] args) {
        MoveZeros zeros = new MoveZeros();
        int[] nums = new int[] { 0, 1, 0, 3, 12 };
        zeros.moveZeroes(nums);
        System.out.println("Output is:" + Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int prev = 0; // This will track the position to place the next non-zero element.
        for (int i = 0; i < nums.length; i++) {
          if (nums[i] != 0) {
            nums[prev] = nums[i]; // Place the non-zero element at the 'prev' position
            if (i != prev) { // Only set to zero if it's actually a move
              nums[i] = 0;
            }
            prev++; // Move the 'prev' position forward
          }
        }
      }
}
