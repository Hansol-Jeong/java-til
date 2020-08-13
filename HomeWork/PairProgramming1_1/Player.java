import java.util.Scanner;

public class Player implements Inputtable {
    Scanner scanner = new Scanner(System.in);
    protected String name;
    private int numWin;
    Position position = new Position();
    int input_x;
    int input_y;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void getKeyboardInput() {
        while (true) {
        input_x = scanner.nextInt();
        input_y = scanner.nextInt();

            if ((input_x >= 0 && input_x < 15) && (input_y >= 0 && input_y < 15)) {
                position.setInput(input_x, input_y);
            break;
            }
            else
                System.out.println("다시입력");
        }
    }
    public int getPosition_x() {
        return position.input_x;
    }
    public int getPosition_y() {
        return position.input_y;
    }

    public void win() {
        numWin++;
    }
}
