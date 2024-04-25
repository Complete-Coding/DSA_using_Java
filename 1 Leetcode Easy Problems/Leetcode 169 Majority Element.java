class Solution {
  public int majorityElement(int[] nums) {
      int majority = 0;

      for (int i = 0; i < 32; i++) {
          int bit = 1 << i;

          int count = 0;
          for (int num: nums) {
              if ((num & bit) != 0) {
                  count++;
              }
          }

          if (count > nums.length / 2) {
              majority |= bit;
          }
      }

      return majority;
  }
}