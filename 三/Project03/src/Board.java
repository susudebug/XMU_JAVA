public class Board {
    int[][] board = new int[3][3];
    Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = 0;
            }
        }
    }
    public int drop(boolean isBlack, int x, int y) {
        if (x >= 0 && y >= 0 && x <= 2 && y <= 2) {
            if (this.board[x][y] != 0) {
                System.out.println("Have ocuppied, please change!");
                return  -1;
            }
            else {
                this.board[x][y] = isBlack ? 1 : 2; // Black 1, White 2
                return 1;
            }
        }
        else {
            System.out.println("Outside the edge!");
            return 0;
        }
    }
    public int check() {
        for (int i = 0; i < 3; i++) {
            int temp = board[i][0];
            //System.out.println(temp);
            if (temp == 0) continue;
            boolean flag = true;
            for (int j = 1; j < 3; j++) {
                if (board[i][j] != temp) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                String winner = (temp == 1) ? "Black" : "White";
                System.out.println(winner + " wins!");
                return temp;
            }
        }
        for (int i = 0; i < 3; i++) {
            int temp = board[0][i];
            //System.out.println(temp);
            if (temp == 0) continue;
            boolean flag = true;
            for (int j = 1; j < 3; j++) {
                if (board[j][i] != temp) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                String winner = (temp == 1) ? "Black" : "White";
                System.out.println(winner + " wins!");
                return temp;
            }
        }
        int temp1 = board[0][0];
        if (temp1 != 0) {
            if (board[1][1] == temp1 && board[2][2] == temp1) {
                String winner = (temp1 == 1) ? "Black" : "White";
                System.out.println(winner + " wins!");
                return temp1;
            }
        }
        int temp2 = board[0][2];
        if (temp2 != 0) {
            if (board[1][1] == temp2 && board[2][0] == temp2) {
                String winner = (temp2 == 1) ? "Black" : "White";
                System.out.println(winner + " wins!");
                return temp2;
            }
        }
        System.out.println("Nobody wins now!");
        return 0;
    }
    public void draw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i][j] == 1)
                System.out.print("|X|");
                else if (board[i][j] == 2)
                    System.out.print("|O|");
                else System.out.print("| |");

                //System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
