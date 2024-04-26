import java.util.*;

class Solution {
  public List<List<Integer>> generate(int numRows) {
      if (numRows == 1) {
          List<List<Integer>> result = new ArrayList<>();
          List<Integer> firstRow = new ArrayList<>();
          firstRow.add(1);
          result.add(firstRow);
          return result;
      }

      List<List<Integer>> previousRows = generate(numRows - 1);
      List<Integer> lastRow = previousRows.get(numRows - 2);
      List<Integer> newRow = new ArrayList<>();
      newRow.add(1);

      for(int i = 1; i < numRows - 1; i++) {
          newRow.add(lastRow.get(i-1) + lastRow.get(i));
      }
      newRow.add(1);
      previousRows.add(newRow);
      return previousRows;
  }
}