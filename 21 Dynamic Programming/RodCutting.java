
import java.util.HashMap;
import java.util.Map;

/**
 * Given a rod of length n inches and an array
 * of prices that includes prices of all pieces of
 * size smaller than n. Determine the maximum
 * value obtainable by cutting up the rod and
 * selling the pieces. For example, if the length
 * of the rod is 8 and the values of different pieces
 * are given as the following, then the maximum
 * obtainable value is 22 (by cutting in two
 * pieces of lengths 2 and 6)
 *
 * Example:
 * length | 1 2 3 4 5 6 7 8
 * --------------------------------------------
 * price | 1 5 8 9 10 17 17 20
 * And if the prices are as following, then the
 * maximum obtainable value is 24 (by cutting in
 * eight pieces of length 1)
 *
 */
class RodCutting {
  static int count = 0;

  public static void main(String[] args) {
    RodCutting rodCutting = new RodCutting();
    int price[] = new int[] { 1, 5, 8, 9, 10, 17, 17,
        20, 24 };
    int n = price.length;
    Map<Integer, Integer> maxProfit = new HashMap<>();
    System.out.println(
        "Maximum obtained value is "
            + rodCutting.cutRod(price, n, maxProfit));
    System.out.println("count is:" + count);
  }

  public int cutRod(int prices[], int length,
      Map<Integer, Integer> maxProfit) {
    if (length <= 0)
      return 0;
    if (maxProfit.containsKey(length)) {
      return maxProfit.get(length);
    }
    count++;
    int maxVal = Integer.MIN_VALUE;

    for (int i = 0; i < length; i++) {
      maxVal = Math.max(maxVal,
          prices[i] + cutRod(prices,
              length - i - 1, maxProfit));
    }

    maxProfit.put(length, maxVal);
    return maxVal;
  }
}
