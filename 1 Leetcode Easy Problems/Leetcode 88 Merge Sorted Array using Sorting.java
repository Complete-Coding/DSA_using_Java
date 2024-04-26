import java.util.*;

class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
      // O(n)
      for (int i = 0; i < n; i++) {
          nums1[m+i] = nums2[i];
      }
      // O((m+n) * log(m+n))
      Arrays.sort(nums1);
  }
}