package in.knowledgegate.dsa.sorting.problems;

import java.util.Arrays;

/**
 * Given an integer array nums, return the number of
 * elements that have both a strictly smaller and
 * a strictly greater element appear in nums.
 *
 * Example 1:
 * Input: nums = [11,7,2,15]
 * Output: 2
 * Explanation: The element 7 has the element 2 strictly
 * smaller than it and the element 11 strictly greater than it.
 * Element 11 has element 7 strictly smaller than it
 * and element 15 strictly greater than it.
 * In total there are 2 elements having both a strictly
 * smaller and a strictly greater element appear in nums.
 *
 *  Example 2:
 * Input: nums = [-3,3,3,90]
 * Output: 2
 * Explanation: The element 3 has the element -3
 * strictly smaller than it and the element 90
 * strictly greater than it.
 * Since there are two elements with the value 3,
 * in total there are 2 elements having both a strictly
 * smaller and a strictly greater element appear in nums.
 *
 * [1,1,1,2,2,3,4,5,5]
 *
 * Constraints:
 * 1 <= nums.length <= 100
 * -105 <= nums[i] <= 105
 */
public class CountElements {

  public static void main(String[] args) {
    CountElements elements = new CountElements();
    int[] nums = new int[]{1,1,1,1,1,1};
    System.out.println("output is:" + elements.countElements(nums));
  }

  public int countElements(int[] nums) {
    Arrays.sort(nums);
    int beg = -1, end = -1;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i + 1] > nums[i]) {
        beg = i + 1;
        break;
      }
    }
    for (int i = nums.length - 1; i > 0; i--) {
      if (nums[i-1] < nums[i]) {
        end = i - 1;
        break;
      }
    }
    return beg != -1 && end != -1 ? end - beg + 1
        : 0;
  }
}
