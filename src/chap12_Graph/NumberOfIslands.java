package chap12_Graph;

public class NumberOfIslands {

    public static void main(String[] args) {
        int[][] map1 = { {1, 1, 1, 1, 0},
                        {1, 1, 0, 1, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0} };
        System.out.println(numIslands(map1));

        int[][] map2 = {{1, 1, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 1} };
        System.out.println("numIslands(map2) = " + numIslands(map2));

    }

    public static int numIslands(int[][] grid) {

        int result = 0;

        if(grid == null)
            return result;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }

        return result;
    }

    public static void dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length
                || grid[i][j] != 1)
            return;

        grid[i][j] = 0;

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
