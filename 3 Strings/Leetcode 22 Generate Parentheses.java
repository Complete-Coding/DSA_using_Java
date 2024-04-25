
import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function
 * to generate all combinations of well-formed
 * parentheses.
 *
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 *
 * Constraints:
 * 1 <= n <= 8
 */
class GenerateParentheses {

  public static void main(String[] args) {
    GenerateParentheses obj = new GenerateParentheses();
    System.out.println("Here is the result:");
    for (String combi : obj.generateParenthesis(3)) {
      System.out.print(combi + ", ");
    }
  }

  public List<String> generateParenthesis(int n) {
    List<String> combinations = new ArrayList<>();
    generateAllCombinations(new char[n * 2], 0,
        combinations);
    return combinations;
  }

  private void generateAllCombinations(char[] current,
      int pos, List<String> combinations) {
    if (pos == current.length) {
      if (isValid(current)) {
        combinations.add(new String(current));
      }
    } else {
      current[pos] = '(';
      generateAllCombinations(current, pos + 1,
          combinations);
      current[pos] = ')';
      generateAllCombinations(current, pos + 1,
          combinations);
    }
  }

  private boolean isValid(char[] current) {
    int counter = 0;
    for (int i = 0; i < current.length; i++) {
      if (current[i] == '(') {
        counter++;
      } else {
        counter--;
      }
      if (counter < 0)
        return false;
    }
    return counter == 0;
  }
}
