class Solution {
  public String reverseVowels(String s) {
    char[] letters = s.toCharArray();
    int i = 0, j = s.length() - 1;

    while (i < j) {
      // increment till i reaches a vowel
      while (i < j && !isVowel(letters[i])) i++;

      // decrement till j reaches a vowel
      while (i < j && !isVowel(letters[j])) j--;

      if (i < j) {
        char temp = letters[i];
        letters[i] = letters[j];
        letters[j] = temp;
        i++;
        j--;
      }
    }
    return new String(letters);
  }

  private boolean isVowel(char c) {
    final String VOWELS = "aeiouAEIOU";
    return VOWELS.indexOf(c) != -1;
  }
}