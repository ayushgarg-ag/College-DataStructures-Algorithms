import java.util.*;

public class PercolationBFS extends PercolationDFSFast {
    /**
     * Initialize a grid so that all cells are blocked.
     *
     * @param n is the size of the simulated (square) grid
     */
    public PercolationBFS(int n) {
        super(n);
    }

    @Override
    public void dfs(int row, int col) {
        // out of bounds?
        if (! inBounds(row,col)) return;

        int[] rowDelta = {-1,1,0,0};
        int[] colDelta = {0,0,-1,1};

        Queue<int[]> q = new LinkedList<>();
        myGrid[row][col] = FULL;
        q.add(new int[]{row,col});

        while (q.size() != 0){
            int[] pos = q.remove();
            for(int k=0; k < rowDelta.length; k++){
                row = pos[0] + rowDelta[k];
                col = pos[1] + colDelta[k];
                if (inBounds(row,col) && myGrid[row][col] == OPEN && myGrid[row][col] != FULL){
                    q.add(new int[]{row,col});
                    myGrid[row][col] = FULL;
                }
            }
        }
    }
}
