class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] counts = new int[26];
    for (char c : magazine.toCharArray()) {
      int index = c - 'a';
      counts[index]++;
    }
    for (char c : ransomNote.toCharArray()) {
      int index = c - 'a';
      counts[index]--;
    }
    for (int count: counts) {
      if (count < 0) {
        return false;
      }
    }
    return true;
  }
}