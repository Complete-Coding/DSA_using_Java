package in.knowledgegate.dsa.recursion;

/**
 * Factorial
 * n! = n X (n-1) X ..... X 1
 * F(0) = 1
 * F(1) = 1
 * F(2) = 2
 * F(3) = 6 = 3 * 2
 * F(n) = n * F(n-1), n >= 1
 */
public class Factorial {
  public int fact(int n) {
    if (n == 0 || n == 1) return 1;
    return n * fact(n-1);
  }
}
