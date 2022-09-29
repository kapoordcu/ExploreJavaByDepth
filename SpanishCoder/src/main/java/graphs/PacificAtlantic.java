package graphs;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class PacificAtlantic {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> pacificAndAtlantic = new ArrayList<>();
        int ROWS = heights.length;
        int COLS = heights[0].length;
        Set<MatrixPair> pacific = new HashSet<>();
        Set<MatrixPair> atlantic = new HashSet<>();

        for (int c = 0; c < COLS; c++) {
            dfs(heights, 0, c, pacific, heights[0][c], ROWS, COLS);
            dfs(heights,ROWS - 1, c, atlantic, heights[ROWS - 1][c], ROWS, COLS);
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(heights, r, 0, pacific, heights[r][0], ROWS, COLS);
            dfs(heights,r,  COLS -1 , atlantic, heights[r][COLS-1], ROWS, COLS);
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                MatrixPair pair = new MatrixPair(i, j);
                if(pacific.contains(pair) && atlantic.contains(pair)) {
                    pacificAndAtlantic.add(List.of(pair.row, pair.col));
                }
            }
        }
        return pacificAndAtlantic;
    }

    private void dfs(int[][] heights, int r, int c, Set<MatrixPair> visited, int prevHeight, int ROWS, int COLS) {
        MatrixPair matrixPair = new MatrixPair(r, c);
        if(visited.contains(matrixPair) ||
                r < 0 || c < 0 || r == ROWS || c == COLS ||
                prevHeight > heights[r][c]) {
            return;
        }
        visited.add(matrixPair);

        dfs(heights, r+1, c, visited, heights[r][c], ROWS, COLS);
        dfs(heights, r-1, c, visited, heights[r][c], ROWS, COLS);
        dfs(heights, r, c+1, visited, heights[r][c], ROWS, COLS);
        dfs(heights, r, c-1, visited, heights[r][c], ROWS, COLS);
    }

    @Test
    public void tes01() {
        int[][] heights = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        List<List<Integer>> output = List.of(
                List.of(0,4),
                List.of(1,3),
                List.of(1,4),
                List.of(2,2),
                List.of(3,0),
                List.of(3,1),
                List.of(4,0)
        );
        List<List<Integer>> actual = pacificAtlantic(heights);
        assertTrue(actual.equals(output));
    }
}

class MatrixPair {
    int row;
    int col;

    public MatrixPair(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatrixPair that = (MatrixPair) o;
        return row == that.row && col == that.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}