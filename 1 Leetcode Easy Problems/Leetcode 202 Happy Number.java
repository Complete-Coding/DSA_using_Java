import java.util.*;

class Solution {
  public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    while (n != 1) {
      if (set.contains(n)) {
        return false;
      }
      set.add(n);
      n = sumOfSquareOfDigits(n);
    }
    return true;
  }

  private int sumOfSquareOfDigits(int num) {
    int result = 0;
    while (num > 0) {
      int rem = num % 10;
      result += rem * rem;
      num /= 10;
    }
    return result;
  }
}