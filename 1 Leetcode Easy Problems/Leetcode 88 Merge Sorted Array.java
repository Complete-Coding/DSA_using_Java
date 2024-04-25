class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
      int i = m-1;
      int j = n-1;
      int k = nums1.length - 1;

      // O(m+n)
      while (j >= 0) {
          if (i >= 0 && nums1[i] > nums2[j]) {
              nums1[k] = nums1[i];
              i--;
              k--;
          } else {
              nums1[k] = nums2[j];
              j--;
              k--;
          }
      }
  }
}