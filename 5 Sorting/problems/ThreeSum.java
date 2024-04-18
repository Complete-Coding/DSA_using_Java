
import java.util.*;

/**
 * Given an integer array nums, return all the
 * triplets [nums[i], nums[j], nums[k]] such that
 * i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain
 * duplicate triplets.
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Example 2:
 * Input: nums = []
 * Output: []
 *
 * Example 3:
 * Input: nums = [0]
 * Output: []
 *
 * Constraints:
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
class ThreeSum {
  public static void main(String[] args) {
    ThreeSum threeSum = new ThreeSum();
    int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
    System.out.println("Possible Triplets:" +
        threeSum.threeSum(nums));
  }

  public Set<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    Set<List<Integer>> res = new HashSet<>();
    for (int i = 0; i < nums.length - 2; i++) {
      int beg = i + 1;
      int end = nums.length - 1;
      while (beg < end) {
        int sum = nums[i] + nums[beg] + nums[end];
        if (sum == 0) {
          res.add(Arrays.asList(nums[i],
              nums[beg], nums[end]));
          beg++;
          end--;
        } else if (sum < 0) {
          beg++;
        } else {
          end--;
        }
      }
    }

    return res;
  }
}
