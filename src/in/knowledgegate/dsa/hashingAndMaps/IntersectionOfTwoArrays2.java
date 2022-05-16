package in.knowledgegate.dsa.hashingAndMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two integer arrays nums1 and nums2,return
 * an array of their intersection. Each element in
 * the result must appear as many times as it shows
 * in both arrays and you may return the result in
 * any order.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 *
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
public class IntersectionOfTwoArrays2 {
  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> cardi = new HashMap<>();
    for (int num : nums1) {
      cardi.put(num, cardi.getOrDefault(num, 0) + 1);
    }

    List<Integer> result = new ArrayList<>();
    for (int num : nums2) {
      int freq = cardi.getOrDefault(num, 0);
      if (freq > 0) {
        result.add(num);
        cardi.put(num, freq - 1);
      }
    }

    int[] inter = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      inter[i] = result.get(i);
    }
    return inter;
  }
}
