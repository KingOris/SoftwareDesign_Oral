/**
 * A class to find the way out of the maze
 */
public class MazeTraversal {
    /**
     * A private MazeMap which contain the maze mao
     */
    private MazeMap travelMap;
    /**
     * A private integer i to show the start point
     */
    private int i;
    /**
     * A private integer j to show the start point
     */
    private int j;

    /**
     * The constructor of MazeTraversal which to set up the map and start position
     *
     * @param map the maze map
     * @param i   the position of start point
     * @param j   the position of start point
     */
    public MazeTraversal(MazeMap map, int i, int j) {
        travelMap = map;
        this.i = i;
        this.j = j;
    }

    /**
     * The recursive function to find the way out. When it has a way go right, it will always go right.
     */
    public void mazeTraversal() {
        if (j < 11 && travelMap.getMazeMap()[i][j + 1] == '.') {
            travelMap.getMazeMap()[i][j] = 'X';
            j++;
            travelMap.print();
            mazeTraversal(); //Move to right
        } else if (i > 0 && travelMap.getMazeMap()[i - 1][j] == '.') {
            travelMap.getMazeMap()[i][j] = 'X';
            i--;
            travelMap.print();
            mazeTraversal();//Move to up
        } else if (i < 11 && travelMap.getMazeMap()[i + 1][j] == '.') {
            travelMap.getMazeMap()[i][j] = 'X';
            i++;
            travelMap.print();
            mazeTraversal();//Move to down
        } else if (j > 0 && travelMap.getMazeMap()[i][j - 1] == '.') {
            travelMap.getMazeMap()[i][j] = 'X';
            j--;
            travelMap.print();
            mazeTraversal();//Move to left
        } else if (i == 0 || i == 11 || j == 0 || j == 11) {
            travelMap.getMazeMap()[i][j] = 'X';//Start or exit
        } else {
            traceback();
            travelMap.print();
        }


    }

    /**
     * The function to find the way back
     */
    public void traceback() {
        travelMap.getMazeMap()[i][j] = '0';
        if (j < 11 && travelMap.getMazeMap()[i][j + 1] == 'X') {
            travelMap.getMazeMap()[i][j] = '0';
            j++;
            mazeTraversal();
        } else if (i > 0 && travelMap.getMazeMap()[i - 1][j] == 'X') {
            travelMap.getMazeMap()[i][j] = '0';
            i--;
            mazeTraversal();//Move to up
        } else if (i < 11 && travelMap.getMazeMap()[i + 1][j] == 'X') {
            travelMap.getMazeMap()[i][j] = '0';
            i++;
            mazeTraversal();//Move to down
        } else if (j > 0 && travelMap.getMazeMap()[i][j - 1] == 'X') {
            travelMap.getMazeMap()[i][j] = '0';
            j--;
            mazeTraversal();//Move to left
        }
    }

    /**
     * A get method to get the final map of the maze
     *
     * @return MazeMap show the way out of the maze
     */
    public MazeMap getTravelMap() {
        return travelMap;
    }
}
