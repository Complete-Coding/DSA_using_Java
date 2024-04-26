import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> cardi = getCardinalityMap(nums);
        // Space: O(1), Time: O(n)
        for (Map.Entry<Integer, Integer> entry : cardi.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // Space: O(n), Time: O(n)
    private Map<Integer, Integer> getCardinalityMap(int[] nums) {
        Map<Integer, Integer> cardi = new HashMap<>();
        for (int num: nums) {
            if (!cardi.containsKey(num)) {
                cardi.put(num, 1);
            } else {
                int currCount = cardi.get(num);
                cardi.put(num, currCount + 1);
            }
        }
        return cardi;
    }
}