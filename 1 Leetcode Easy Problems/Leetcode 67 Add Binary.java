class Solution {
  public String addBinary(String a, String b) {
      StringBuilder sb = new StringBuilder();
      int maxLength = Math.max(a.length(), b.length());

      int carry = 0;
      for (int i = 0; i < maxLength; i++) {
          int aIndex = (a.length() - 1) - i;
          int bIndex = (b.length() - 1) - i;
          char aChar = aIndex >= 0 ? a.charAt(aIndex) : '0';
          char bChar = bIndex >= 0 ? b.charAt(bIndex) : '0';
          int aVal = aChar - '0';
          int bVal = bChar - '0';

          int sum = aVal + bVal + carry;
          int res = sum % 2;
          carry = sum / 2;
          sb.append(res);
      }

      if (carry == 1) {
          sb.append(carry);
      }

      return sb.reverse().toString();
  }
}