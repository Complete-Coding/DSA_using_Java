class Solution {
  public String convertToTitle(int columnNumber) {
    StringBuilder result = new StringBuilder();
    while (columnNumber > 0) {
      columnNumber--;
      int rem = columnNumber % 26;
      char c = (char) ('A' + rem);
      result.insert(0, c);
      columnNumber /= 26;
    }
    return result.toString();
  }
}