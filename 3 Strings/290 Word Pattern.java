import java.util.HashMap;

class Solution {
  public boolean wordPattern(String pattern, String s) {
    String[] words = s.split(" ");
    if (pattern.length() != words.length) {
      return false;
    }
    HashMap<Character, String> lToW = new HashMap<>();
    HashMap<String, Character> wToL = new HashMap<>();
    for (int i = 0 ; i < pattern.length(); i++) {
      char letter = pattern.charAt(i);
      String word = words[i];

      if (lToW.containsKey(letter)) {
        if (!lToW.get(letter).equals(word)) {
          return false;
        }
      } else {
        lToW.put(letter, word);
      }

      if (wToL.containsKey(word)) {
        if (wToL.get(word) != letter) {
          return false;
        }
      } else {
        wToL.put(word, letter);
      }  
    }
    return true;
  }
}