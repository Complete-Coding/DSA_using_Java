class Solution {
  public int titleToNumber(String columnTitle) {
    int result = 0;
    int len = columnTitle.length();
    for (int i = len - 1, pow = 0; i >= 0; i--, pow++) {
      char c = columnTitle.charAt(i);
      int digit = c - 'A' + 1;
      result += digit * Math.pow(26, pow);
    }
    return result; 
  }
}