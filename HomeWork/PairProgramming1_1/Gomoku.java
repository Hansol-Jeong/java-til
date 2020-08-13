import java.util.Scanner;

public class Gomoku implements Simulatable, Winnable, Playable, Printable {
    Scanner scanner = new Scanner(System.in);
    Player playerA;
    Player playerB;

    int [][] met = new int[15][15];
    int count=1;


    public void run() {
        initialize();
        while(true) {
            if(count%2!=0) {
                playerAInserting();//중복체크
                int x=scanner.nextInt();
                if(x==1){
                    System.out.println("아 33안된다고했잖아 다시");
                    reset();
                }

                count++;
                printStatus();
            }
            else if(count%2==0) {
                playerBInserting();
                count++;
                printStatus();
            }
        }
    }

    private void playerAInserting() {
            while(true) {
                System.out.println("스페이스바로 구분해서 x,y좌표 입력해보던가");
                playerA.getKeyboardInput();//키보드 인풋을 받고
                if (checkOverlapA()) {//중복인지 아닌지 확인하고
                    met[playerA.getPosition_x()][playerA.getPosition_y()] = 1;//중복이 아니라면 1로바꿈
                    break;//while문 탈출
            }
                else System.out.println("다시입력하여라.");
        }
    }

//    private boolean check3By3A() {
////        boolean right=false,left=false,up=false,down=false;
////        boolean up_right=false, up_left=false, down_right=false, down_left=false;
//        int colStack=0;//세로스텍
//        int rowStack=0;//가로스텍
//        int rightDiagonal=0;
//        int leftDiagonal=0;
//        int who_made_3hole=0;
//        if(met[playerA.getPosition_x()][playerA.getPosition_y()+1]!=0) {
//            colStack++;
//            if(colStack==2)
//                who_made_3hole++;
//        }
////            right=true;
//        if(met[playerA.getPosition_x()][playerA.getPosition_y()-1]!=0) {
//            colStack++;
//            if(colStack==2)
//                who_made_3hole++;
//        }
////            left=true;
//        if(met[playerA.getPosition_x()][playerA.getPosition_y()]!=0) {
//            rowStack++;
//            if(rowStack==2)
//                who_made_3hole++;
//        }
////            up=true;
//        if(met[playerA.getPosition_x()+1][playerA.getPosition_y()]!=0){
//            rowStack++;
//            if(rowStack==2)
//                who_made_3hole++;
//        }
////            down=true;
//
//        if(met[playerA.getPosition_x()-1][playerA.getPosition_y()+1]!=0){
//            rightDiagonal++;
//            if(rightDiagonal==2)
//                who_made_3hole++;
//        }
////            up_right=true;
//        if(met[playerA.getPosition_x()-1][playerA.getPosition_y()-1]!=0){
//            leftDiagonal++;
//            if(leftDiagonal==2)
//                who_made_3hole++;
//        }
////            up_left=true;
//        if(met[playerA.getPosition_x()+1][playerA.getPosition_y()+1]!=0){
//            leftDiagonal++;
//            if(leftDiagonal==2)
//                who_made_3hole++;
//        }
////            down_right=true;
//        if(met[playerA.getPosition_x()+1][playerA.getPosition_y()-1]!=0){
//            rightDiagonal++;
//            if(rightDiagonal==2)
//                who_made_3hole++;
//        }
////            down_left=true;
//
//        if(who_made_3hole==2)
//            return false;//33성립
//        else return true;
//
//
//
//    }
//    private boolean check3By3B() {
////        boolean right=false,left=false,up=false,down=false;
////        boolean up_right=false, up_left=false, down_right=false, down_left=false;
//        int colStack=0;//세로스텍
//        int rowStack=0;//가로스텍
//        int rightDiagonal=0;
//        int leftDiagonal=0;
//        int who_made_3hole=0;
//        if(met[playerB.getPosition_x()][playerB.getPosition_y()+1]!=0) {
//            colStack++;
//            if(colStack==2)
//                who_made_3hole++;
//        }
////            right=true;
//        if(met[playerB.getPosition_x()][playerB.getPosition_y()-1]!=0) {
//            colStack++;
//            if(colStack==2)
//                who_made_3hole++;
//        }
////            left=true;
//        if(met[playerB.getPosition_x()][playerB.getPosition_y()]!=0) {
//            rowStack++;
//            if(rowStack==2)
//                who_made_3hole++;
//        }
////            up=true;
//        if(met[playerB.getPosition_x()+1][playerB.getPosition_y()]!=0){
//            rowStack++;
//            if(rowStack==2)
//                who_made_3hole++;
//        }
////            down=true;
//
//        if(met[playerB.getPosition_x()-1][playerB.getPosition_y()+1]!=0){
//            rightDiagonal++;
//            if(rightDiagonal==2)
//                who_made_3hole++;
//        }
////            up_right=true;
//        if(met[playerB.getPosition_x()-1][playerB.getPosition_y()-1]!=0){
//            leftDiagonal++;
//            if(leftDiagonal==2)
//                who_made_3hole++;
//        }
////            up_left=true;
//        if(met[playerB.getPosition_x()+1][playerB.getPosition_y()+1]!=0){
//            leftDiagonal++;
//            if(leftDiagonal==2)
//                who_made_3hole++;
//        }
////            down_right=true;
//        if(met[playerB.getPosition_x()+1][playerB.getPosition_y()-1]!=0){
//            rightDiagonal++;
//            if(rightDiagonal==2)
//                who_made_3hole++;
//        }
////            down_left=true;
//
//        if(who_made_3hole==2)
//            return false;//33성립
//        else return true;
//
//
//
//    }

    private void playerBInserting() {

            while(true) {
                System.out.println("스페이스바로 구분해서 x,y좌표 입력해보던가");
                playerB.getKeyboardInput();
                if (checkOverlapB()) {
                    met[playerB.getPosition_x()][playerB.getPosition_y()] = 2;
                    break;
            }
                else System.out.println("다시입력하여라.");
        }
    }

    private boolean checkOverlapA() {
        if(met[playerA.getPosition_x()][playerA.getPosition_y()]!=0)//비어있지 않다면
            return false;
        else
            return true;//비어있다면
    }
    private boolean checkOverlapB() {
        if(met[playerB.getPosition_x()][playerB.getPosition_y()]!=0)//비어있지 않다면
            return false;
        else
            return true;//비어있다면
    }

    @Override
    public void play(Player player, Position pos) {
    }

    @Override
    public void printStatus() {
        for(int i =0; i<15; i++){
            for(int j=0;j<15;j++){
                if(met[i][j]==0)
                    System.out.print(" "+0);
                else if(met[i][j]==1)
                    System.out.print(" x");
                else if(met[i][j]==2)
                    System.out.print(" o");
            }
            System.out.println();
        }

    }

    @Override
    public void initialize() {
        scanner.nextLine();
        System.out.println("첫번째 플레이어 이름 입력하던가");
        playerA= new Player(scanner.nextLine());

        System.out.println("두번째 플레이어 이름 입력하던가");
        playerB= new Player(scanner.nextLine());



    }

    @Override
    public void isFinished() {

    }

    @Override
    public void reset() {
        run();
    }

    @Override
    public Player getWinner() {
        return null;
    }


}
