
public class gamePlay {
    public static void main(String[] args) {
        int [][]grid=new int[5][5];
        grid[3][3]=1;
        board game1=new infectedBoard(grid);
        int genNum = 18;
        System.out.println("Generation Num: "+ 0 + "--------------------------------------------------------------------------------------------------------");
        game1.print();
        for (int i=1; i<=genNum; i++){
            System.out.println("Generation Num: "+ i + "--------------------------------------------------------------------------------------------------------");
            game1.gameProc();
        }

    }
}
