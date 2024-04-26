
/**
 * Write an efficient algorithm that searches for
 * a value target in an m x n integer matrix.
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than
 * the last integer of the previous row.
 *
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]],
 * target = 3
 * Output: true
 *
 * Example 2:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],
 * [23,30,34,60]], target = 13
 * Output: false
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
class SearchIn2DMatrix {
    public static void main(String[] args) {
        SearchIn2DMatrix search = new SearchIn2DMatrix();
        int[][] nums = new int[][] { { 1, 3, 5, 7 },
                { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        System.out.println("Element status: "
                + search.searchMatrix(nums, 24));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int tot = m * n;
        int beg = 0;
        int end = tot - 1;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] < target)
                beg = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}
