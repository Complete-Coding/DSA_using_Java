package in.knowledgegate.dsa.binarysearch.problems;

/**
 * You are given a sorted array consisting of only
 * integers where every element appears exactly
 * twice, except for one element which appears exactly once.
 *
 * Return the single element that appears only once.
 * Your solution must run in O(log n) time and O(1) space.
 *
 * Example 1:
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 *
 * Example 2:     0,1,2,3,4 ,5 ,6
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 */
public class SingleElementInASortedArray {
    public static void main(String[] args) {
        SingleElementInASortedArray finder =
            new SingleElementInASortedArray();
        int[] nums = new int[]{3,3,7,7,10,11,11};
        System.out.println("Duplicate is:"
            + finder.singleNonDuplicate(nums));
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((mid % 2 == 0 && nums[mid] == nums[mid+1]) ||
            (mid % 2 == 1 && nums[mid] == nums[mid -1])) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }
}



