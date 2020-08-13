import java.util.Scanner;

public class Player implements Inputtable {
    protected String name;
    private int numWin;

    @Override
    public void setPlayerName() {
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.nextLine();
    }
}
