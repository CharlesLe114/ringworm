public abstract class board {

    protected int [][]grid;
    public board(int [][]grid){
        this.grid=grid;
    }

    public int getStatus(int x, int y){
        if (grid[x][y]==0) return 0;
        else if (grid[x][y]>0 && grid[x][y]<=6) return 1;
        else return 2;
    }

    public void print(){
        for (int []d:grid) {
            for (int c:d) {
                System.out.printf("%5d", c);
            }
            System.out.println();
        }
    }
    public abstract void gameProc();
}
