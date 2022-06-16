package in.knowledgegate.dsa.array;

/**
 * You are given an n x n grid where you have
 * placed some 1 x 1 x 1 cubes. Each value v = grid[i][j]
 * represents a tower of v cubes placed on top
 * of cell (i, j).
 *
 * After placing these cubes, you have decided to
 * glue any directly adjacent cubes to each other,
 * forming several irregular 3D shapes.
 *
 * Return the total surface area of the resulting
 * shapes.
 *
 * Note: The bottom face of each shape counts
 * toward its surface area.
 *
 * Example 1:
 * Input: grid = [[1,2],
 *                [3,4]]
 * Output: 34 = 4 + 7 + 10 + 13 = 34
 *
 * Example 2:
 * Input: grid = [[1,1,1],
 *                [1,0,1],
 *                [1,1,1]]
 * Output: 32
 *
 * Example 3:
 * Input: grid = [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 46
 *
 * Constraints:
 * n == grid.length == grid[i].length
 * 1 <= n <= 50
 * 0 <= grid[i][j] <= 50
 */
public class SurfaceAreaOf3DShapes {
    public static void main(String[] args) {
        SurfaceAreaOf3DShapes shapes =
            new SurfaceAreaOf3DShapes();
        int[][] grid = new int[][]{{1,2},{3,4}};
        System.out.println("Area is:" + shapes.surfaceArea(grid));
    }

    public int surfaceArea(int[][] grid) {
        int total = 0;
        int size = grid.length;
        for (int i = 0 ; i< size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 0) continue;
                int areaGained =
                    4 * grid[i][j] + 2;
                int areaLost = 0;
                if (i - 1 >= 0) {
                    areaLost += Math.min(grid[i][j], grid[i-1][j]);
                }
                if (i + 1 < size) {
                    areaLost += Math.min(grid[i][j], grid[i+1][j]);
                }
                if (j - 1 >= 0) {
                    areaLost += Math.min(grid[i][j], grid[i][j-1]);
                }
                if (j + 1 < size) {
                    areaLost += Math.min(grid[i][j], grid[i][j+1]);
                }
                total += areaGained - areaLost;
            }
        }

        return total;
    }
}









