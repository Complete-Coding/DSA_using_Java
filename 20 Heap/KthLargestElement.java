
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k,
 * return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the
 * sorted order, not the kth distinct element.
 *
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 *
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 * Constraints:
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 */
class KthLargestElement {
  public static void main(String[] args) {
    KthLargestElement kthLargest = new KthLargestElement();
    int[] nums = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
    System.out.println("Kth largest is:" +
        kthLargest.findKthLargest(nums, 6));
  }

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> kLargest = new PriorityQueue<>();
    for (int num : nums) {
      kLargest.add(num);
      if (kLargest.size() > k) {
        kLargest.poll();
      }
    }

    return kLargest.peek();
  }
}
