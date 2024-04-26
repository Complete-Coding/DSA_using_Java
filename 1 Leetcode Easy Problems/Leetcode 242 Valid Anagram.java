import java.util.HashMap;

class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    HashMap<Character, Integer> countMap = new HashMap<>();
    for (int i = 0 ; i < s.length(); i++) {
      char sChar = s.charAt(i);
      char tChar = t.charAt(i);

      countMap.put(sChar, countMap.getOrDefault(sChar, 0) + 1);
      countMap.put(tChar, countMap.getOrDefault(tChar, 0) - 1);
    }

    for (int value : countMap.values()) {
      if (value != 0) {
        return false;
      }
    }
    return true;
  }
}