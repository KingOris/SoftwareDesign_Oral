/**
 * A Board class to create the board and check if the position is available, if there is a winner and whose turn it is
 */
public class Board {
    /**
     * A private int matrix to record player1 input
     */
    private int[][] board;
    /**
     * A private boolean record whose turn it is
     */
    private boolean turn;

    /**
     * The constructor for Board class which created the board
     */
    public Board() {
        //To created a 3x3 matrix
        board = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }
        turn = true;
    }

    /**
     * A get mothed of Turn
     *
     * @return turn True if it is the player1's turn and false if it is the player2's turn
     */
    public boolean getTrun() {
        return turn;
    }

    /**
     * To check if the position is available
     *
     * @param x the position of x
     * @param y the position of y
     * @return true if it is available or return false
     */
    public boolean check(int x, int y) {
        if (board[x][y] == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * A funtion to record the player's chosen position(1 for player 1; 2 for player 2)
     *
     * @param x the position of x
     * @param y the position of y
     */
    public void draw(int x, int y) {
        if (turn) {
            board[x][y] = 1;
            turn = false;
        } else {
            board[x][y] = 2;
            turn = true;
        }

    }

    /**
     * A function to check if there is a winner.
     *
     * @return true if there is a winner
     */
    public boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != 0) {
                return true;
            } else if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != 0) {
                return true;
            }
        }

        if (board[0][0] == board[1][1] && board[2][2] == board[1][1] && board[0][0] != 0) {
            return true;
        } else if (board[2][0] == board[1][1] && board[0][2] == board[1][1] && board[2][0] != 0) {
            return true;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        System.out.println("Draw");
        return true;
    }


    /**
     * A function to print the whole board
     */
    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 1) {
                    System.out.print(" x |");
                } else if (board[i][j] == 2) {
                    System.out.print(" o |");
                } else {
                    System.out.print("   |");
                }
            }
            System.out.println();
        }
    }
}
