import java.util.Scanner;

/**
 * A sub class HumanPlayer extends From Player class
 */
public class HumanPlayer extends Player {
    /**
     * A private integer X
     */
    private int x;
    /**
     * A private integer Y
     */
    private int y;

    /**
     * The constructor of HumanPlayer
     */
    public HumanPlayer() {
        super();
        x = 0;
        y = 0;
    }

    /**
     * A function to get player's input x and set it to x
     */
    public void getInputX() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter x position(1-3): ");
        x = input.nextInt() - 1;
        if (x < 0 || x > 2) {
            System.out.println("X should be between 0-3");
            getInputX();
        } else {
            return;
        }
    }

    /**
     * A function to get player's input y and set it to y
     */
    public void getInputY() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter y position(1-3): ");
        y = input.nextInt() - 1;
        if (y < 0 || y > 2) {
            System.out.println("X should be between 0-3");
            getInputX();
        } else {
            return;
        }
    }

    /**
     * A overwrite function fo draw
     *
     * @param a The board of the gmae
     */
    @Override
    public void draw(Board a) {
        getInputX();
        getInputY();
        while (!a.check(x, y)) {
            System.out.println("The location your chose not available");
            getInputX();
            getInputY();
        }
        a.draw(x, y);
    }
}

