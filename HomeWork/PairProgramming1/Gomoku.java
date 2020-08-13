import java.util.Scanner;

public class Gomoku implements Simulatable, Winnable, Playable, Printable {
    int count = 0;
    Position [] posA = new Position[150];
    Position [] posB = new Position[150];
    int nA, nB;
    boolean isExist;
    Player playerA;
    Player playerB;

    public void runGomoku() {
        initialize();
        if(count%2==0) {
            while (true) {
                playerA.getKeyboardInput();
                isExist = false;
                check(playerA.pos);
                if (isExist) {
                    continue;
                } else {
                    break;
                }
            }
            play(playerA, playerA.pos);
            printStatus();
            check3_3(playerA.pos);
            isFinished();

            count++;
        }
        else {
            while (true) {
                playerB.getKeyboardInput();
                isExist = false;
                check(playerB.pos);
                if (isExist) {
                    continue;
                } else {
                    break;
                }
            }
            play(playerB, playerB.pos);
            printStatus();
            check3_3(playerB.pos);
            isFinished();

            count++;
        }
    }

    private void check(Position pos) {
        for (int i = 0; i < posB.length; i++) {
            if (posB[i].x == pos.x && posB[i].y == pos.y) {
                isExist = true;
            }
        }
        for (int i = 0; i < posA.length; i++) {
            if (posA[i].x == pos.x && posA[i].y == pos.y) {
                isExist = true;
            }
        }
    }
    private void check3_3(Position pos) {
//        if(pos==playerA.pos)

    }

    @Override
    public void play(Player player, Position pos) {
        if(player == playerA) {

            posA[nA] = pos;
            nA++;
        } else {
            posB[nB] = pos;
            nB++;
        }


        }


    @Override
    public void printStatus() {
       
        int [][] show = new int[15][15];
        for(int i=0; i<15; i++)
            for(int j=0; j<15; j++)
                show[i][j]=0;

        for(int i = 0; i<posA.length;i++)
            for(int j = 0; j< 15; j ++)
                for(int k = 0; k<15 ; k++)
                    if(posA[i].x==k&&posA[i].y==j){
                        show[j][k]=1;
                    }

        for(int i = 0; i<posB.length;i++)
            for(int j = 0; j< 15; j ++)
                for(int k = 0; k<15 ; k++)
                    if(posB[i].x==k&&posB[i].y==j){
                        show[j][k]=2;
                    }
        for(int i=0; i<15; i++)
            for(int j=0; j<15; j++){
                if(show[i][j]==0)
                    System.out.print(" "+0);
                else if(show[i][j]==1)
                    System.out.print(" "+1);
                else if(show[i][j]==2)
                    System.out.print(" "+2);
            }



    }

    @Override
    public void initialize() {
        Scanner scanner = new Scanner(System.in);
        playerA = new Player(scanner.nextLine());
        playerB = new Player(scanner.nextLine());
    }

    @Override
    public void isFinished() {


    }

    @Override
    public void reset() {

    }

    @Override
    public Player getWinner() {
        return null;
    }

    public void store(String name, Position pos){

    }
}
