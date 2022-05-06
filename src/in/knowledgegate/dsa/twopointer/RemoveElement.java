package in.knowledgegate.dsa.twopointer;

/**
 * Given an integer array nums and an integer val,
 * remove all occurrences of val in nums in-place.
 * The relative order of the elements may be changed.
 *
 *
 * Do not allocate extra space for another array.
 * You must do this by modifying the input array
 * in-place with O(1) extra memory.
 *
 *
 * Example 1:
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2,
 * with the first two elements of nums being 2.
 * It does not matter what you leave beyond the
 * returned k (hence they are underscores).
 *
 * Example 2:
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5,
 * with the first five elements of nums containing
 * 0, 0, 1, 3, and 4.
 */
public class RemoveElement {
  public int removeElement(int[] nums, int val) {
    int insertLoc = 0;
    for (int i = 0; i < nums.length; i++) {
      if (val != nums[i]) {
        nums[insertLoc++] = nums[i];
      }
    }
    return insertLoc;
  }
}
