package in.knowledgegate.dsa.sorting.problems;

/**
 * Given an integer array nums sorted in
 * non-decreasing order, return an array of the
 * squares of each number sorted in non-decreasing
 * order.
 *
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes
 * [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 * Example 2:
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 */
public class SquaresOfSortedArray {
  public int[] sortedSquares(int[] nums) {
    int beg = 0, end = nums.length - 1;
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int sq1 = (int) Math.pow(nums[beg], 2);
      int sq2 = (int) Math.pow(nums[end], 2);
      if (sq1 >= sq2) {
        result[nums.length - 1 - i] = sq1;
        beg++;
      } else {
        result[nums.length - 1 - i] = sq2;
        end--;
      }
    }
    return result;
  }
}
