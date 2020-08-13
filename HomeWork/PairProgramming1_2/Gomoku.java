import java.util.Scanner;

public class Gomoku implements Simulatable, Winnable, Playable, Printable {
    Scanner scanner = new Scanner(System.in);
    Player playerA, playerB;
    Position pos;
    int sizeofI;
    int sizeofJ;
    int count = 1;
    boolean check3by3=true;
    char [][] met;

    boolean isFinished = false;

    public Gomoku() {
    }
    public void run() {
        initialize();//플레이어 둘 생성
        System.out.println("플레이어 A: " + playerA.name);
        System.out.println("플레이어 B: " + playerB.name);
        System.out.println("오목판 크기: "+ sizeofJ*sizeofI);


        while(isFinished==false)//isFinished, 안끝났으면 계속
        {
            Position pos = new Position();//새로운 좌표 생성

            if(count%2==1){//A차례
                play(playerA, pos);
                System.out.println("("+pos.getX()+ "," + pos.getY()+")");

            }
            else{//B차례
                play(playerB, pos);
                System.out.println("("+pos.getX()+ "," + pos.getY()+")");
            }
            printStatus();
        }
    }

    @Override
    public void play(Player player, Position pos) {
        while(true) {
            System.out.println("하 좌표 두개 입력하던지");
            pos.set(scanner.nextInt(), scanner.nextInt());
            if(pos.getX()>sizeofJ-1||pos.getY()>sizeofI-1) {
                System.out.println("똑바로 다시입력하세요");
                continue;
            }

            if (player.equals(playerA) && checkOverlap(pos)){
            if(check3by3(pos))
                {
                    met[pos.getX()][pos.getY()] = 'o';
                    System.out.println("이번턴: " + count);
                    count++;
                    break;
                }
                else {
                    System.out.println("33모델이야 다시해");
                    continue;
                }
            }
            else if (player.equals(playerB) && checkOverlap(pos)) {
                if (check3by3(pos)) {
                    met[pos.getX()][pos.getY()] = 'x';
                    System.out.println("이번턴: " + count);
                    count++;
                    break;
                }
                else {
                    System.out.println("33모델이야 다시해");
                    continue;
                }
            }
            else if (checkOverlap(pos)==false)
            {
                System.out.println("중복뜸 다시하셈");
                continue;}
            else
                System.out.println("이거는 뜨면 안되는 오류인데");
        }
    }

    private boolean check3by3(Position pos) {//33인지 아닌지 체크
        //33이라면 false
        int oCount=0;
        int xCount=0;
        for(int i = pos.getX()-1;i<=pos.getX()+1;i++)
            for(int j = pos.getY()-1;j<=pos.getY()+1;j++){
                if(met[i][j]=='o')
                    oCount++;
                else if(met[i][j]=='x')
                    xCount++;
            }
        if(oCount==5||xCount==5)
            return false;
        oCount=0;
        xCount=0;
        for(int i = pos.getX()-1;i<=pos.getX()+1;i++)
            for(int j = pos.getY()-2;j<=pos.getY();j++){
                if(met[i][j]=='o')
                    oCount++;
                else if(met[i][j]=='x')
                    xCount++;
            }
        if(oCount==5||xCount==5)
            return false;
        oCount=0;
        xCount=0;
        for(int i = pos.getX()-1;i<=pos.getX()+1;i++)
            for(int j = pos.getY();j<=pos.getY()+2;j++){
                if(met[i][j]=='o')
                    oCount++;
                else if(met[i][j]=='x')
                    xCount++;
            }
        if(oCount==5||xCount==5)
            return false;
        oCount=0;
        xCount=0;

        for(int i = pos.getX()-2;i<=pos.getX();i++)
            for(int j = pos.getY()-1;j<=pos.getY()+1;j++){
                if(met[i][j]=='o')
                    oCount++;
                else if(met[i][j]=='x')
                    xCount++;
            }
        if(oCount==5||xCount==5)
            return false;
        oCount=0;
        xCount=0;
        for(int i = pos.getX()-2;i<=pos.getX();i++)
            for(int j = pos.getY()-2;j<=pos.getY();j++){
                if(met[i][j]=='o')
                    oCount++;
                else if(met[i][j]=='x')
                    xCount++;
            }
        if(oCount==5||xCount==5)
            return false;
        oCount=0;
        xCount=0;
        for(int i = pos.getX()-2;i<=pos.getX();i++)
            for(int j = pos.getY();j<=pos.getY()+2;j++){
                if(met[i][j]=='o')
                    oCount++;
                else if(met[i][j]=='x')
                    xCount++;
            }
        if(oCount==5||xCount==5)
            return false;
        oCount=0;
        xCount=0;

        for(int i = pos.getX();i<=pos.getX()+2;i++)
            for(int j = pos.getY()-1;j<=pos.getY()+1;j++){
                if(met[i][j]=='o')
                    oCount++;
                else if(met[i][j]=='x')
                    xCount++;
            }
        if(oCount==5||xCount==5)
            return false;
        oCount=0;
        xCount=0;
        for(int i = pos.getX();i<=pos.getX()+2;i++)
            for(int j = pos.getY()-2;j<=pos.getY();j++){
                if(met[i][j]=='o')
                    oCount++;
                else if(met[i][j]=='x')
                    xCount++;
            }
        if(oCount==5||xCount==5)
            return false;
        oCount=0;
        xCount=0;
        for(int i = pos.getX();i<=pos.getX()+2;i++)
            for(int j = pos.getY();j<=pos.getY()+2;j++){
                if(met[i][j]=='o')
                    oCount++;
                else if(met[i][j]=='x')
                    xCount++;
            }
        if(oCount==5||xCount==5)
            return false;
        oCount=0;
        xCount=0;
        return true;ㅇ
    }

//    private void check3by3(Position pos) {
//        int canCase = 9;
//        int oCount = 0;
//        int xCount = 0;
//            switch (0) {
//                case 0:
//                    for(int row = pos.getX()-1; row<=pos.getX()+1;row++){
//                    for(int col = pos.getY()-1; col<=pos.getY()+1;col++){
//                        if(met[row][col]=='o')
//                            oCount++;
//                        if(met[row][col]=='x')
//                            xCount++;
//                    }
//                }
//                    if(oCount==5||xCount==5){
//                        check3by3=false;//o또는 x가 5개이면33성립해서 거짓으로 만들어줌
//                    break;}
//                    oCount=0;
//                    xCount=0;
//
//                case 1:
//                    for(int row = pos.getX()-1; row<=pos.getX()+1;row++){
//                        for(int col = pos.getY(); col<=pos.getY()+2;col++){
//                            if(met[row][col]=='o')
//                                oCount++;
//                            if(met[row][col]=='x')
//                                xCount++;
//                        }
//                    }
//                    if(oCount==5||xCount==5){
//                        check3by3= false;
//        break;}
//                    oCount=0;
//                    xCount=0;
//
//                case 2:
//                    for(int row = pos.getX()-1; row<=pos.getX()+1;row++){
//                        for(int col = pos.getY()-2; col<=pos.getY();col++){
//                            if(met[row][col]=='o')
//                                oCount++;
//                            if(met[row][col]=='x')
//                                xCount++;
//                        }
//                    }
//                    if(oCount==5||xCount==5){
//                        check3by3= false;
//                        break;}
//                    oCount=0;
//                    xCount=0;
//
//                case 3:
//                    for(int row = pos.getX()-2; row<=pos.getX();row++){
//                        for(int col = pos.getY()-1; col<=pos.getY()+1;col++){
//                            if(met[row][col]=='o')
//                                oCount++;
//                            if(met[row][col]=='x')
//                                xCount++;
//                        }
//                    }
//                    if(oCount==5||xCount==5){
//                        check3by3= false;
//                        break;}
//                    oCount=0;
//                    xCount=0;
//
//                case 4:
//                    for(int row = pos.getX()-2; row<=pos.getX();row++){
//                        for(int col = pos.getY(); col<=pos.getY()+2;col++){
//                            if(met[row][col]=='o')
//                                oCount++;
//                            if(met[row][col]=='x')
//                                xCount++;
//                        }
//                    }
//                    if(oCount==5||xCount==5){
//                        check3by3= false;
//                        break;}
//                    oCount=0;
//                    xCount=0;
//                case 5:
//                    for(int row = pos.getX()-2; row<=pos.getX();row++){
//                        for(int col = pos.getY()-2; col<=pos.getY();col++){
//                            if(met[row][col]=='o')
//                                oCount++;
//                            if(met[row][col]=='x')
//                                xCount++;
//                        }
//                    }
//                    if(oCount==5||xCount==5){
//                        check3by3= false;
//                        break;}
//                    oCount=0;
//                    xCount=0;
//                case 6:
//                    for(int row = pos.getX(); row<=pos.getX()+2;row++){
//                        for(int col = pos.getY()-1; col<=pos.getY()+1;col++){
//                            if(met[row][col]=='o')
//                                oCount++;
//                            if(met[row][col]=='x')
//                                xCount++;
//                        }
//                    }
//                    if(oCount==5||xCount==5){
//                        check3by3= false;
//                        break;}
//                    oCount=0;
//                    xCount=0;
//                case 7:
//                    for(int row = pos.getX(); row<=pos.getX()+2;row++){
//                        for(int col = pos.getY(); col<=pos.getY()+2;col++){
//                            if(met[row][col]=='o')
//                                oCount++;
//                            if(met[row][col]=='x')
//                                xCount++;
//                        }
//                    }
//                    if(oCount==5||xCount==5){
//                        check3by3= false;
//                        break;}
//                    oCount=0;
//                    xCount=0;
//                case 8:
//                    for(int row = pos.getX(); row<=pos.getX()+2;row++){
//                        for(int col = pos.getY()-2; col<=pos.getY();col++){
//                            if(met[row][col]=='o')
//                                oCount++;
//                            if(met[row][col]=='x')
//                                xCount++;
//                        }
//                    }
//                    if(oCount==5||xCount==5){
//                        check3by3= false;
//                        break;}
//                    oCount=0;
//                    xCount=0;
//                default:
//                    System.out.println("이게 출력이되면 안되는데");
//                    check3by3= true;
//            }
//
//    }

    private boolean checkOverlap(Position pos) {
        if(met[pos.getX()][pos.getY()]=='E')
        return true;//중복이 되지않으면 트루
        else
            return false;//중복되면 false
    }

    @Override
    public void printStatus() {
        for(int i = 0; i<sizeofI; i++){
            for(int j = 0; j<sizeofJ; j++){
                System.out.print(" "+met[i][j]);
            }
            System.out.println();
        }

    }

    @Override
    public void initialize() {
        int x,y;
        System.out.println("아 시작하려면 엔터누르셈;;");
        scanner.nextLine();
        playerA = new Player();
        playerB = new Player();
        System.out.println("아 첫번째 플레이어 이름 넣으셈");
        playerA.setPlayerName();
        System.out.println("아 두번째 플레이어 이름 넣으셈");
        playerB.setPlayerName();
        System.out.println("아 몇행 몇열짜리로 출력할지 스페이스로 구분해서 입력하셈;;");
        setSize(scanner.nextInt(),scanner.nextInt());
        met = new char[sizeofI][sizeofJ];
        for(int i=0; i<sizeofI;i++)
            for(int j = 0; j<sizeofJ; j++)
                met[i][j]='E';
        System.out.printf("오목판 사이즈: %d x %d\n" , sizeofI, sizeofJ);
        System.out.println();
        printStatus();
        System.out.println("아 설정끝났음 오목하던지");
        System.out.println("===================================================");
    }

    private void setSize(int sizeofI, int sizeofJ) {
        this.sizeofI = sizeofI;
        this.sizeofJ = sizeofJ;
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
}
