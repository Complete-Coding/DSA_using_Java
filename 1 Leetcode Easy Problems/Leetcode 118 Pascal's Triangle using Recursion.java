import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> genRow = generateRow(i+1);
            result.add(genRow);
        }
        return result;
    }

    private List<Integer> generateRow(int rowNumber) {
        if (rowNumber == 1) {
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            return firstRow;
        }

        List<Integer> currRow = new ArrayList<>();
        List<Integer> prevRow = generateRow(rowNumber - 1);

        currRow.add(1);
        for (int i = 1; i < rowNumber - 1; i++) {
            currRow.add(prevRow.get(i-1) + prevRow.get(i));
        }
        currRow.add(1);
        return currRow;
    }
}