class Solution {
  private final String[][] SYMBOLS = new String[][]{
      {"I", "1"},
      {"V", "5"},
      {"X", "10"},
      {"L", "50"},
      {"C", "100"},
      {"D", "500"},
      {"M", "1000"},
  };

  private int getSymbolValue(char symbol) {
      for (String[] row: SYMBOLS) {
          if (row[0].equals(symbol + "")) {
              return Integer.parseInt(row[1]);
          }
      }
      return 0;
  }

  public int romanToInt(String s) {
      int result = 0;
      for (int i = 0; i < s.length(); i++) {
          char current = s.charAt(i);
          int currValue = getSymbolValue(current);

          if (i + 1 < s.length()) {
              char next = s.charAt(i+1);
              int nextVal = getSymbolValue(next);
              if (nextVal <= currValue) {
                  result += currValue;
              } else {
                  result += (nextVal - currValue);
                  i++;
              }
          } else {
              result += currValue;
          }
      }
      return result;
  }
}