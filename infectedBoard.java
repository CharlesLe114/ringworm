public class infectedBoard extends board {
    final int[] shiftx = {-1, -1, -1, 0, 1, 1, 1, 0};
    final int[] shifty = {-1, 0, 1, 1, 1, 0, -1, -1};
    int[][] check = new int[21][21];

    infectedBoard(int[][] grid) {
        super(grid);
    }

    private void increaseCell(int x, int y) {
        grid[x][y]++;
    }

    private void resetCheck() {
        for (int i=0; i<21; i++)
            for (int j=0; j<21; j++) check[i][j]=0;
    }

    private boolean ambientCellisTrue(int x, int y) {
        int i;
        for (i = 0; i < 8; i++) {
            if ((x + shiftx[i]) == 5 || (x + shiftx[i]) < 0 || (y + shifty[i] == 5) || (y + shifty[i] < 0)) continue;
            if (check[x + shiftx[i]][y + shifty[i]] == 1) break;
        }
        return i == 8;
    }

    private void setStatus(int x, int y) {
        for (int i = 0; i < 8; i++) {
            if ((x + shiftx[i]) ==5 || (x + shiftx[i]) < 0 || (y + shifty[i] == 5) || (y + shifty[i] < 0)) continue;
            int k=getStatus(x + shiftx[i], y + shifty[i]);
            //if (getStatus(x + shiftx[i], y + shifty[i]) == 1)
            if (k==1)  {
                //increaseCell(x+shiftx[i],y+shifty[i]);
                check[x + shiftx[i]][y + shifty[i]] = 1;
            }
        }
    }

    private void spreadCell(int x, int y) {
        for (int i = 0; i < 8; i++) {
            if ((x + shiftx[i]) ==5 || (x + shiftx[i]) < 0 || (y + shifty[i] == 5) || (y + shifty[i] < 0)) continue;
            int k = getStatus(x + shiftx[i], y + shifty[i]);
            if (k == 0 && ambientCellisTrue(x + shiftx[i], y + shifty[i])) {
                grid[x + shiftx[i]][y + shifty[i]] = 1;
                check[x+shiftx[i]][y+shifty[i]]=2;
                setStatus(x + shiftx[i], y + shifty[i]);
                break;
            }
        }
    }

    public void gameProc() {
        int size = grid.length;
        resetCheck();
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (check[i][j]==2) continue;
                if (getStatus(i,j) ==1){
                    if (grid[i][j]==6) grid[i][j]=-4; else increaseCell(i,j);
                    if (check[i][j]==0)
                        spreadCell(i,j);
                }
               else if (getStatus(i, j) == 2) increaseCell(i, j);
                //if (getStatus(i, j) == 3) grid[i][j] = 0;
            }
        print();
    }
}

