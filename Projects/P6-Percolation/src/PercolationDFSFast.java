import java.util.ArrayList;
import java.util.Arrays;

public class PercolationDFSFast extends PercolationDFS {

    /**
     * Initialize a grid so that all cells are blocked.
     *
     * @param n is the size of the simulated (square) grid
     */
    public PercolationDFSFast(int n) {
        super(n);
    }

    @Override
    public void updateOnOpen(int row, int col) {
        boolean callDFS = false;
        if (row == 0) {
            callDFS = true;
        }
        int[] rowDelta = {-1,1,0,0};
        int[] colDelta = {0,0,-1,1};
        for(int k = 0; k < rowDelta.length; k++){
            int r = row + rowDelta[k];
            int c = col + colDelta[k];
            if (inBounds(r,c) && myGrid[r][c] == FULL){
                callDFS = true;
            }
        }
        if (callDFS) {
            dfs(row, col);
        }
    }
}
