
/**
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order. You must write an algorithm with O(log n) runtime
 * complexity.
 * <p>
 * <p>
 * Example 1: Input: nums = [1,3,5,6], target = 5 Output: 2
 * <p>
 * Example 2: Input: nums = [1,3,5,6], target = 2 Output: 1
 * <p>
 * Example 3: Input: nums = [1,3,5,6], target = 7 Output: 4
 * <p>
 * <p>
 * Constraints: 1 <= nums.length <= 104 -104 <= nums[i] <= 104 nums contains
 * distinct values sorted in ascending order. -104 <= target <= 104
 */
class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int beg = 0, end = nums.length - 1;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return end + 1;
    }
}
