/**
 * A class ComputerPlayer extends Player class to show how computer players play
 */
public class ComputerPlayer extends Player {
    /**
     * A private integer X
     */
    private int x;
    /**
     * A private integer Y
     */
    private int y;

    /**
     * The constructor of ComputerPlayer
     */
    public ComputerPlayer() {
        x = 0;
        y = 0;
    }

    /**
     * A draw method overwrote from super class method.
     * To show how computer player play the TicTacToe
     *
     * @param a the Board of the game
     */
    @Override
    public void draw(Board a) {
        //To check which position is available
        while (x < 3) {
            while (y < 3) {
                if (a.check(x, y)) {
                    a.draw(x, y);
                    return;
                } else {
                    y += 1;
                }
            }
            y = 0;
            x += 1;
        }
    }
}
