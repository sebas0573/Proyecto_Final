package controlador;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class BFS {
    private static final int[] rowMovi = {-1, 1, 0, 0};
    private static final int[] colMovi = {0, 0, -1, 1};

    public boolean findPath(int[][] laberinto, int startX, int startY, List<int[]> path) {
        int rows = laberinto.length;
        int cols = laberinto[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            path.add(new int[]{x, y});

            if (x == rows - 1 && y == cols - 1) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = x + rowMovi[i];
                int newCol = y + colMovi[i];

                if (seguro(laberinto, newRow, newCol, visited)) {
                    queue.add(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        
        path.clear();
        return false;
    }

    private boolean seguro(int[][] maze, int row, int col, boolean[][] visited) {
        return row >= 0 && col >= 0 && row < maze.length && col < maze[0].length &&
               maze[row][col] == 0 && !visited[row][col];
    }
}
