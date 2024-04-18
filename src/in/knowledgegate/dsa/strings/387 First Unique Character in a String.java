

import java.util.HashMap;

class FirstUniqueCharacter {
  public int firstUniqChar(String s) {
    HashMap<Character, Integer> countMap = new HashMap<>();
    // Filling characters into the map
    for (int i = 0 ; i < s.length(); i++) {
      char c = s.charAt(i);
      countMap.put(c, countMap.getOrDefault(c, 0) + 1);
    }

    // Checking count 1
    for (int i = 0 ; i < s.length(); i++) {
      char c = s.charAt(i);
      if (countMap.get(c) == 1) {
        return i;
      }
    }
    return -1;
  }
}
