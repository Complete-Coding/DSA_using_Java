
/**
 * There is an integer array nums sorted in ascending
 * order (with distinct values).
 *
 * Prior to being passed to your function, nums is
 * possibly rotated at an unknown pivot index
 * k (1 <= k < nums.length) such that the resulting
 * array is [nums[k], nums[k+1], ..., nums[n-1],
 * nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated
 * at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation
 * and an integer target, return the index of
 * target if it is in nums, or -1 if it is not in
 * nums.
 *
 * You must write an algorithm with O(log n) runtime
 * complexity.
 *
 *
 * Example 1: 0,1,2,3,4,5,6
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 *
 *
 * Constraints:
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -104 <= target <= 104
 */
class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("Found at:"
                + search.search(nums, 3));
    }

    int search(int[] nums, int target) {
        int beg = 0, end = nums.length - 1;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            if (nums[mid] > nums[end])
                beg = mid + 1;
            else
                end = mid - 1;
        }
        int shift = end + 1;

        beg = 0;
        end = nums.length - 1;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            int realMid = (mid + shift) % nums.length;
            if (nums[realMid] == target)
                return realMid;
            else if (nums[realMid] < target)
                beg = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}
