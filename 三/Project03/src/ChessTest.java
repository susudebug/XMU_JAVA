import java.util.Scanner;

public class ChessTest {
    ChessTest(){}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Player p1 = new Player("Player1", true);
        Player p2 = new Player("Player2", false);
        Board board = new Board();
        for (int i = 0; i < 9; i++) {
            System.out.println("Please input the position!");
            int x = in.nextInt() - 1, y = in.nextInt() - 1;
            if (i % 2 == 0) {
                while (p1.makeDrop(board, x, y) != 1) {
                    System.out.println("Please input again!");
                    x = in.nextInt() - 1;
                    y = in.nextInt() - 1;
                }
            }
            else {
                while (p2.makeDrop(board, x, y) != 1) {
                    System.out.println("Please input again!");
                    x = in.nextInt() - 1;
                    y = in.nextInt() - 1;
                }
            }
            board.draw();
            if (board.check() != 0) break;
        }
    }
}
