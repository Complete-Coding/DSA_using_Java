package in.knowledgegate.dsa.dfs;

/**
 * While your players are waiting for a game,
 * you've developed a solitaire game for the
 * players to pass the time with.
 * The player is given an NxM board of tiles from
 * 0 to 9 like this:
 *   4   4   4   4
 *   5   5   5   4
 *   2   5   7   5
 * The player selects one of these tiles, and that
 * tile will disappear, along with any tiles with
 * the same number that are connected with that tile
 * (up, down, left, or right), and any tiles with the
 * same number connected with those, and so on. For
 * example, if the 4 in the upper left corner is
 * selected, these five tiles disappear
 *  >4< >4< >4< >4<
 *   5   5   5  >4<
 *   2   5   7   5
 * If the 5 just below it is selected, these four
 * tiles disappear. Note that tiles are not
 * connected diagonally.
 *   4   4   4   4
 *  >5< >5< >5<  4
 *   2  >5<  7   5
 * Write a function that, given a grid of tiles
 * and a selected row and column of a tile,
 * returns how many tiles will disappear.
 * grid1 = [[4, 4, 4, 4],
 *          [5, 5, 5, 4],
 *          [2, 5, 7, 5]]
 * disappear(grid1, 0, 0)  => 5
 * disappear(grid1, 1, 1)  => 4
 * disappear(grid1, 1, 0)  => 4
 * This is the grid from above.
 *
 * Additional Inputs
 * grid2 = [[0, 3, 3, 3, 3, 3, 3],
 *          [0, 1, 1, 1, 1, 1, 3],
 *          [0, 2, 2, 0, 2, 1, 4],
 *          [0, 1, 2, 2, 2, 1, 3],
 *          [0, 1, 1, 1, 1, 1, 3],
 *          [0, 0, 0, 0, 0, 0, 0]]
 *
 * grid3 = [[0]]
 *
 * grid4 = [[1, 1, 1],
 *          [1, 1, 1],
 *          [1, 1, 1]]
 *
 * All Test Cases
 * disappear(grid1, 0, 0)  => 5
 * disappear(grid1, 1, 1)  => 4
 * disappear(grid1, 1, 0)  => 4
 * disappear(grid2, 0, 0)  => 12
 * disappear(grid2, 3, 0)  => 12
 * disappear(grid2, 1, 1)  => 13
 * disappear(grid2, 2, 2)  => 6
 * disappear(grid2, 0, 3)  => 7
 * disappear(grid3, 0, 0)  => 1
 * disappear(grid4, 0, 0)  => 9
 *
 * N - Width of the grid
 * M - Height of the grid
 *
 * Clarifications
 * - All values are between 0 and 9
 * - The grid will not be empty
 * - The input board is immutable. If the
 * candidate suggests modifying the board you
 * should suggest they make a deep copy of the board
 * instead. This does not constitute handholding.
 * - The input row and column will always be on
 * the board.
 */
public class Solitaire {
  public int disappear(int[][] grid, int x,
                       int y) {
    if (grid.length <= 0) return 0;
    int[][] newGrid =
        new int[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        newGrid[i][j] = grid[i][j];
      }
    }
    return disappear(newGrid, x, y, newGrid[x][y]);
  }
  public int disappear(int[][] grid, int x,
                       int y, int num) {
    if (x >= grid.length || y >= grid[0].length ||
        x < 0 || y < 0 || grid[x][y] != num ||
        grid[x][y] == -1) return 0;

    grid[x][y] = -1;
    return 1 + disappear(grid, x, y + 1, num)
        + disappear(grid, x + 1, y, num)
        + disappear(grid, x - 1, y, num)
        + disappear(grid, x, y - 1, num);
  }

  public static void main(String[] args) {
    int[][] grid1 =
       {{4, 4, 4, 4},
        {5, 5, 5, 4},
        {2, 5, 7, 5}};
    int[][] grid2 = {{0, 3, 3, 3, 3, 3, 3},
        {0, 1, 1, 1, 1, 1, 3},
        {0, 2, 2, 0, 2, 1, 4},
        {0, 1, 2, 2, 2, 1, 3},
        {0, 1, 1, 1, 1, 1, 3},
        {0, 0, 0, 0, 0, 0, 0}};
    int[][] grid3 = {{0}};
    int[][] grid4 = {{1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}};

    Solitaire solitaire = new Solitaire();
    System.out.println(solitaire.disappear(grid1, 0 , 0));
    System.out.println(solitaire.disappear(grid1, 1 , 0));
    System.out.println(solitaire.disappear(grid1, 2 , 0));
    System.out.println(solitaire.disappear(grid1, 2 , 2));

    System.out.println(solitaire.disappear(grid2, 0 , 0));
    System.out.println(solitaire.disappear(grid2, 0 , 1));
    System.out.println(solitaire.disappear(grid2, 1 , 1));
    System.out.println(solitaire.disappear(grid2, 2 , 1));
    System.out.println(solitaire.disappear(grid2, 0 , 0));

    System.out.println(solitaire.disappear(grid3, 0 , 0));

    System.out.println(solitaire.disappear(grid4, 0 , 0));
  }
}
