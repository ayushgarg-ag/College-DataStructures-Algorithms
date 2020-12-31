public class PercolationUF implements IPercolate {
    private IUnionFind myFinder;
    private boolean[][] myGrid;
    private final int VTOP;
    private final int VBOTTOM;
    private int myOpenCount;

    public PercolationUF(IUnionFind finder, int size) {
        myGrid = new boolean[size][size];
        finder.initialize(size*size+2);
        myFinder = finder;
        VTOP = size*size;
        VBOTTOM = size*size + 1;
        myOpenCount = 0;
    }

    public boolean inBounds(int row, int col) {
        if (row < 0 || row >= myGrid.length) return false;
        if (col < 0 || col >= myGrid[0].length) return false;
        return true;
    }

    public int getIndex(int row, int col) {
        return row * myGrid.length + col;
    }

    @Override
    public boolean isOpen(int row, int col) {
        if (!inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        return myGrid[row][col];
    }

    @Override
    public boolean isFull(int row, int col) {
        if (!inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        return myFinder.connected(getIndex(row, col), VTOP);
    }

    @Override
    public boolean percolates() {
        return myFinder.connected(VBOTTOM, VTOP);
    }

    @Override
    public int numberOfOpenSites() {
        return myOpenCount;
    }

    @Override
    public void open(int row, int col) {
        if (!inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        if (myGrid[row][col]) {
            return;
        }
        myOpenCount++;
        myGrid[row][col] = true;
        if(row == 0) {
            myFinder.union(getIndex(row, col), VTOP);
        }
        if (row == myGrid.length - 1) {
            myFinder.union(getIndex(row, col), VBOTTOM);
        }

        int[] rowDelta = {-1,1,0,0};
        int[] colDelta = {0,0,-1,1};
        for(int k=0; k < rowDelta.length; k++){
            int r = row + rowDelta[k];
            int c = col + colDelta[k];
            if (inBounds(r,c) && myGrid[r][c] == true){
                myFinder.union(getIndex(row, col), getIndex(r, c));
            }
        }
    }
}
