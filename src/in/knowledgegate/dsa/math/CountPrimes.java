package in.knowledgegate.dsa.math;

/**
 * Given an integer n, return the number of prime
 * numbers that are strictly less than n.
 *
 * Example 1:
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less
 * than 10, they are 2, 3, 5, 7
 *
 * Example 2:
 * Input: n = 0
 * Output: 0
 *
 * Example 3:
 * Input: n = 1
 * Output: 0
 *
 * Constraints:
 * 0 <= n <= 5 * 106
 */
public class CountPrimes {
    public static void main(String[] args) {
        CountPrimes counter = new CountPrimes();
        System.out.println("No of prime are:"
            + counter.countPrimes(100));
    }

    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int countPrime = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                countPrime++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return countPrime;
    }
}
