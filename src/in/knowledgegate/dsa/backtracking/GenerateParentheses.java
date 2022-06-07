package in.knowledgegate.dsa.backtracking;

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
public class GenerateParentheses {
  public static void main(String[] args) {
    GenerateParentheses generator =
        new GenerateParentheses();
    List<String> parentheses =
        generator.generateParenthesis(3);
    System.out.println("Generate output:");
    for (String parenthesis : parentheses) {
      System.out.print(" " + parenthesis);
    }
  }

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    backtrack(result, new StringBuilder(), 0, 0
        ,n);
    return result;
  }

  private void backtrack(List<String> result,
      StringBuilder cur, int open, int close,
                         int max) {
    if (cur.length() == max*2) {
      result.add(cur.toString());
      return;
    }

    if (open < max) {
      cur.append('(');
      backtrack(result, cur, open + 1, close,
          max);
      cur.deleteCharAt(cur.length() - 1);
    }
    if (close < open) {
      cur.append(')');
      backtrack(result, cur, open, close + 1,
          max);
      cur.deleteCharAt(cur.length() - 1);
    }
  }
}





