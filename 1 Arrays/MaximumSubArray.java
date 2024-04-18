
/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum. A subarray is
 * a contiguous part of an array.
 * <p>
 * Example 1 Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation:
 * [4,-1,2,1] has the largest sum = 6.
 * <p>
 * Example 2: Input: nums = [1] Output: 1
 * <p>
 * Example 3: Input: nums = [5,4,-1,7,8] Output: 23
 * <p>
 * <p>
 * Constraints: 1 <= nums.length <= 105 -104 <= nums[i] <= 104
 */
class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int maxEndingHere = nums[0], maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], nums[i] + maxEndingHere);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
}
