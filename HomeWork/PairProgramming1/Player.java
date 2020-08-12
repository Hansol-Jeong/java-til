import java.util.Scanner;

public class Player implements Inputtable {
    private String name;
    private int numWin;
    public Position pos;
    public Player(String name) {
        this.name = name;
    }

    @Override
    public void getKeyboardInput() {
        Scanner scanner = new Scanner(System.in);
        int input_x = scanner.nextInt();
        int input_y = scanner.nextInt();
        pos = new Position(input_x, input_y);
    }


}
