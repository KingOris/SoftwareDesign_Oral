import java.util.Scanner;

/**
 * @author Yuhang Chen
 * @version 1.0.0
 * The run main class which create the game and run it
 */
public class TicTacToeRun {
    public static void main(String[] args) {
        Scanner type = new Scanner(System.in);
        //Let player choose the play mod
        System.out.println("Please choose :A PVP ; B PVE ; C EVE");
        String game = type.nextLine();
        if (game.equals("A")) {
            HumanPlayer player1 = new HumanPlayer();
            HumanPlayer player2 = new HumanPlayer();
            Board board = new Board();

            while (!board.checkWinner()) {
                System.out.println("Player 1 round ");
                player1.draw(board);
                if (!board.checkWinner()) {
                    System.out.println("Player 2 round ");
                    player2.draw(board);
                }
                board.checkWinner();
                board.printBoard();
            }
            if (board.getTrun()) {
                System.out.println("Winner: Player2");
            } else {
                System.out.println("Winner : Player1");
            }
        }else if (game.equals("B")) {
            HumanPlayer player1 = new HumanPlayer();
            ComputerPlayer computerPlayer = new ComputerPlayer();
            Board board = new Board();

            while (!board.checkWinner()) {
                System.out.println("Player 1 round ");
                player1.draw(board);
                if (!board.checkWinner()) {
                    System.out.println("Player 2 round ");
                    computerPlayer.draw(board);
                }
                board.checkWinner();
                board.printBoard();
            }
            if (board.getTrun()) {
                System.out.println("Winner:ComputerPlayer");
            } else {
                System.out.println("Winner : Player1");
            }
        }else if (game.equals("C")) {
            ComputerPlayer computerPlayer1 = new ComputerPlayer();
            ComputerPlayer computerPlayer2 = new ComputerPlayer();
            Board board = new Board();

            while (!board.checkWinner()) {
                computerPlayer1.draw(board);
                if (!board.checkWinner()) {
                    computerPlayer2.draw(board);
                }
                board.checkWinner();
                board.printBoard();
            }
            if (board.getTrun()) {
                System.out.println("Winner:ComputerPlayer2");
            } else {
                System.out.println("Winner : ComputerPlayer1");
            }
        }else{
            System.out.println("Please enter A or B or C");
            throw new IndexOutOfBoundsException("Please enter A or B or C");
        }
    }
}
