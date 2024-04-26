
/**
 * You have n coins and you want to build a staircase
 * with these coins. The staircase consists of k
 * rows where the ith row has exactly i coins.
 * The last row of the staircase may be incomplete.
 *
 * Given the integer n, return the number of
 * complete rows of the staircase you will build.
 *
 * Example 1:
 * Input: n = 5
 * Output: 2
 * Explanation: Because the 3rd row is incomplete,
 * we return 2.
 *
 * Example 2:
 * Input: n = 8
 * Output: 3
 * Explanation: Because the 4th row is incomplete,
 * we return 3.
 *
 * Constraints:
 * 1 <= n <= 231 - 1
 */
class ArrangingCoins {
    public static void main(String[] args) {
        ArrangingCoins arrange = new ArrangingCoins();
        System.out.println("No of stairs:"
                + arrange.arrangeCoins(5));
    }

    private int arrangeCoins(int n) {
        long begin = 0;
        long end = (int) Math.sqrt(2 * (long) n); // Adjust the initial end value
        while (begin <= end) {
          long mid = (begin + end) / 2;
          long coinsUsed = (mid * (mid + 1)) / 2;
          if (coinsUsed == n)
            return (int) mid;
          if (coinsUsed < n) {
            begin = mid + 1;
          } else {
            end = mid - 1;
          }
        }
        return (int) end;
    }
}
