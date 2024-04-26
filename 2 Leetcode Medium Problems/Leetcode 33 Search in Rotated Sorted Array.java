class Solution {
    public int search(int[] nums, int target) {
        int beg = 0, end = nums.length - 1;
        
        // First, find the smallest element's index (pivot index)
        while (beg < end) {
            int mid = (beg + end) / 2;
            if (nums[mid] > nums[end]) {
                beg = mid + 1;  // pivot must be to the right of mid
            } else {
                end = mid;      // pivot could be at mid, or to the left of mid
            }
        }
        // Now, beg == end == pivot index (smallest element index)
        int pivot = beg;

        // Reset beg and end for standard binary search, adjusted by pivot
        beg = 0;
        end = nums.length - 1;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            int realMid = (mid + pivot) % nums.length;  // Adjust mid to account for rotation

            if (nums[realMid] == target) {
                return realMid;
            } else if (nums[realMid] < target) {
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;        
    }
}
