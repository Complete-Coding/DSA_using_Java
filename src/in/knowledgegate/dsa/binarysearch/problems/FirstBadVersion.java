package in.knowledgegate.dsa.binarysearch.problems;

/**
 * You are a product manager and currently leading
 * a team to develop a new product. Unfortunately,
 * the latest version of your product fails the
 * quality check. Since each version is developed based
 * on the previous version, all the versions after
 * a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and
 * you want to find out the first bad one, which
 * causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version)
 * which returns whether version is bad. Implement
 * a function to find the first bad version. You
 * should minimize the number of calls to the API.
 *
 *
 * Example 1:
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 *
 * Example 2:
 * Input: n = 1, bad = 1
 * Output: 1
 *
 * Constraints:
 * 1 <= bad <= n <= 231 - 1
 */
public class FirstBadVersion {
    static int badVersion;
    static int TOTAL_VERSION = 500;

    public static void main(String[] args) {
        FirstBadVersion versionChecker =
            new FirstBadVersion();
        badVersion = 412;
        System.out.println("\nbad version is:"
            + versionChecker.firstBadVersionLinearSearch(TOTAL_VERSION));
        System.out.println("\nbad version is:"
            + versionChecker.firstBadVersion(TOTAL_VERSION));
    }

    public int firstBadVersion(int n) {
        int beg = 1, end = n;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            if (isBadVersion(mid)) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return end + 1;
    }

    public int firstBadVersionLinearSearch(int n) {
        for (int i = 1; i < n; i++) {
            if (isBadVersion(i)) return i;
        }
        return -1;
    }

    private boolean isBadVersion(int version) {
        System.out.print(".");
        return version - badVersion >= 0;
    }
}
