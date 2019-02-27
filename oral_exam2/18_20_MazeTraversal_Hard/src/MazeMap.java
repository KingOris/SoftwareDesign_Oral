/**
 * This class is to create the maze map
 */
public class MazeMap {
    /**
     * A private character 2D array to store the maze map
     */
    private char[][] mazeMap;

    /**
     * This is the constructor of MazeMap to create the map
     */
    public MazeMap() {
        mazeMap = new char[12][12];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                mazeMap[i][j] = '#';
            }
            mazeMap[1][1] = mazeMap[1][2] = mazeMap[1][3] = mazeMap[1][5] = mazeMap[1][6] = mazeMap[1][7] = mazeMap[1][8] = mazeMap[1][9] = mazeMap[1][10] = '.';
            mazeMap[2][0] = mazeMap[2][1] = mazeMap[2][3] = mazeMap[2][5] = mazeMap[2][10] = '.';
            mazeMap[3][3] = mazeMap[3][5] = mazeMap[3][6] = mazeMap[3][7] = mazeMap[3][8] = mazeMap[3][10] = '.';
            mazeMap[4][1] = mazeMap[4][2] = mazeMap[4][3] = mazeMap[4][4] = mazeMap[4][8] = mazeMap[4][10] = mazeMap[4][11] = '.';
            mazeMap[5][4] = mazeMap[5][6] = mazeMap[5][8] = mazeMap[5][10] = '.';
            mazeMap[6][1] = mazeMap[6][2] = mazeMap[6][4] = mazeMap[6][6] = mazeMap[6][8] = mazeMap[6][10] = '.';
            mazeMap[7][2] = mazeMap[7][4] = mazeMap[7][6] = mazeMap[7][8] = mazeMap[7][10] = '.';
            mazeMap[8][1] = mazeMap[8][2] = mazeMap[8][3] = mazeMap[8][4] = mazeMap[8][5] = mazeMap[8][6] = mazeMap[8][7] = mazeMap[8][8] = mazeMap[8][10] = '.';
            mazeMap[9][6] = mazeMap[9][10] = '.';
            mazeMap[10][1] = mazeMap[10][2] = mazeMap[10][3] = mazeMap[10][4] = mazeMap[10][5] = mazeMap[10][6] = mazeMap[10][8] = mazeMap[10][9] = mazeMap[10][10] = '.';
        }
    }

    /**
     * To print the map
     */
    public void print() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(mazeMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * A get method to get the maze map
     *
     * @return the map
     */
    public char[][] getMazeMap() {
        return mazeMap;
    }
}
