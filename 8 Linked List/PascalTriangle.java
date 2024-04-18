
import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first
 * numRows of Pascal's triangle. In Pascal's
 * triangle, each number is the sum of the two
 * numbers directly above it as shown.
 *
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 * 1 5 10 10 5 1
 *
 * Example 1: Input: numRows = 5 Output:
 * [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * Example 2: Input: numRows = 1 Output: [[1]]
 * <p>
 * <p>
 * Constraints: 1 <= numRows <= 30
 */
class PascalTriangle {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> prev = new ArrayList<>();
    prev.add(1);
    result.add(prev);

    for (int i = 1; i < numRows; i++) {
      List<Integer> curr = new ArrayList<>();
      curr.add(1);
      for (int j = 1; j < prev.size(); j++) {
        int val = prev.get(j) + prev.get(j - 1);
        curr.add(val);
      }
      curr.add(1);
      result.add(curr);
      prev = curr;
    }
    return result;
  }
}
