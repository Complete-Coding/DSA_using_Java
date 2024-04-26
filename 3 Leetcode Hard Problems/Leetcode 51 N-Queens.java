
import java.util.Scanner;

/**
 * The n-queens puzzle is the problem of placing
 * n queens on an n x n chessboard such that no
 * two queens attack each other.
 *
 * Given an integer n, return any one solution
 * to the n-queens puzzle. You may
 * return the answer in any order.
 *
 * Each solution contains a distinct board
 * configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and
 * an empty space, respectively.
 *
 * Example 1:
 * Input: n = 4
 * Output: [["..Q.","Q...","...Q",".Q.."]]
 *
 * Example 2:
 * Input: n = 1
 * Output: [["Q"]]
 *
 * Constraints:
 * 1 <= n <= 30
 */
class NQueen {
  private void printBoard(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        char out = board[i][j] == 1 ? 'Q' : '.';
        System.out.print(" " + out + " ");
      }
      System.out.println();
    }
  }

  private boolean isMoveSafe(int[][] board,
      int row, int col) {

    for (int j = 0; j < col; j++) {
      if (board[row][j] == 1) {
        return false;
      }
    }

    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    for (int i = row, j = col; j >= 0 && i < board.length; j--, i++) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    return true;
  }

  /**
   * This method is only responsible to put queen
   * in a specific column.
   */
  private boolean nQueen(int[][] board, int col) {
    if (col >= board.length) {
      return true;
    }

    for (int i = 0; i < board.length; i++) {
      if (isMoveSafe(board, i, col)) {
        board[i][col] = 1;
        if (nQueen(board, col + 1))
          return true;
        board[i][col] = 0;
      }
    }

    return false;
  }

  private void nQueen(int size) {
    int[][] board = new int[size][size];
    if (!nQueen(board, 0)) {
      System.out.println("Solution does not " +
          "exist");
    } else {
      printBoard(board);
    }
  }

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      NQueen nQueen = new NQueen();
      System.out.print("Enter size of board: ");
      int size = scanner.nextInt();
      nQueen.nQueen(size);
    }
  }
}
