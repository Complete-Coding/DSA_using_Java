package in.knowledgegate.dsa.binarysearch.algos;

/**
 * implement Binary Search on sorted array
 * Example:
 * sortedArr: -8, -5, 0, 3, 7, 11, 15
 * Number to find: 7
 * Number to find: 1
 */
public class BinarySearch {
  public int search(int[] sortedArr, int target) {
    int beg = 0, end = sortedArr.length - 1;
    while (beg <= end) {
      int mid = beg + (end - beg) / 2;
      if (target == sortedArr[mid]) {
        return mid;
      } else if (target < sortedArr[mid]) {
        end = mid - 1;
      } else {
        beg = mid + 1;
      }
    }
    return -1;
  }
}
