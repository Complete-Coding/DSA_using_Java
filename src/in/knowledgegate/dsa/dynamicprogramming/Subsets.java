package in.knowledgegate.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * SAME PROBLEM IS SOLVED IN BACKTRACKING ALSO
 * <p>
 * Given an integer array nums of unique elements,
 * return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate
 * subsets. Return the solution in any order.
 * <p>
 * Example 1: Input: nums = [1,2,3] Output:
 * [[],[1],[2],[1,2],[3],[1,3],[2,3], [1,2,3]]
 * <p>
 * Example 2: Input: nums = [0] Output: [[],[0]]
 * <p>
 * Constraints: 1 <= nums.length <= 10 -10 <=
 * nums[i] <= 10 All the numbers of nums are
 * unique.
 */
public class Subsets {
  public static void main(String[] args) {
    Subsets subsets = new Subsets();
    int[] nums = new int[]{1, 2, 3, 4};
    System.out.println("PowerSet is:" +
        subsets.subsets(nums));
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());

    for (int num : nums) {
      int length = res.size();
      for (int i = 0; i < length; i++) {
        List<Integer> copy =
            new ArrayList<>(res.get(i));
        copy.add(num);
        res.add(copy);
      }
    }
    return res;
  }
}
