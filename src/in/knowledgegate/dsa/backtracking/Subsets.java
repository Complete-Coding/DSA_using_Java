package in.knowledgegate.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * SAME PROBLEM IS SOLVED IN DP ALSO
 * <p>
 * Given an integer array nums of unique elements,
 * return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate
 * subsets. Return the solution in any order.
 * <p>
 * Example 1: Input: nums = [1,2,3] Output:
 * [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
    int[] nums = new int[]{};
    System.out.println("PowerSet is :" +
        subsets.subsets(nums));
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    for (int i = 0; i <= nums.length; i++) {
      backtrack(output, i, 0, new ArrayList<>(),
          nums);
    }
    return output;
  }

  private void backtrack(List<List<Integer>> output,
    int length, int beg, List<Integer> curr,
    int[] nums) {

    if (curr.size() == length) {
      output.add(new ArrayList<>(curr));
      return;
    }

    for (int i = beg; i < nums.length; i++) {
      curr.add(nums[i]);
      backtrack(output, length, i + 1, curr,
          nums);
      curr.remove(curr.size() - 1);
    }
  }
}
