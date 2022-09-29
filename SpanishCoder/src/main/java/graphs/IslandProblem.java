package graphs;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class IslandProblem {
    Integer maxIsland = 0;
    public int numIslands(char[][] grid) {
        if(grid==null) return 0;
        Set<MatrixPair> pairSet = new HashSet<>();

        int ROWS = grid.length;
        int COLS = grid[0].length;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                dfsIsland(ROWS, COLS, grid, pairSet, i, j);
            }
        }
        return maxIsland;
    }

    private boolean dfsIsland(int R, int C, char[][] grid, Set<MatrixPair> pairSet, int r, int c) {
        MatrixPair elem = new MatrixPair(r, c);
        if(pairSet.contains(elem) ||
                r==R || r<0 ||
                c == C || c<0 || grid[r][c] == '0') {
            return false;
        } else {
            pairSet.add(elem);
            if (!dfsIsland(R, C, grid, pairSet, r, c-1) &&
                    !dfsIsland(R, C, grid, pairSet, r, c+1) &&
                    !dfsIsland(R, C, grid, pairSet, r-1, c) &&
                    !dfsIsland(R, C, grid, pairSet, r+1, c)) {
                maxIsland++;
            }
        }
        return true;
    }

    @Test
    public void tes01() {
        char[][] grid = {
              {'1','1','0','0','0'},
              {'1','1','0','0','0'},
              {'0','0','1','0','0'},
              {'0','0','0','1','1'}
            };
        int actual =numIslands(grid);
        assertTrue(actual==3);
    }

    @Test
    public void tes02() {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        int actual =numIslands(grid);
        assertTrue(actual==1);
    }
    
    //

}
