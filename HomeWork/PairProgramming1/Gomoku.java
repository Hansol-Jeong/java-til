import java.util.Scanner;

public class Gomoku implements Simulatable, Winnable, Playable, Printable {
    int count = 0 ;
    Position [] posA = new Position[150];
    Position [] posB = new Position[150];
    int nA, nB;
    boolean isExist=false;
    Player playerA;
    Player playerB;

    public void runGomoku() {
        initialize();
        while(true){
                playerA.getKeyboardInput();
                check(playerA.pos);
                if (isExist){
                    continue;
                }
                else{
                    break;
                }
        }
        play(playerA, playerA.pos);
        printStatus();
        isFinished();

        playerB.getKeyboardInput();
        play(playerB, playerB.pos);
        printStatus();
        isFinished();
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
