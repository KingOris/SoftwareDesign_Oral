/**
 * @author Yuhang Chen
 * @version 1.0.0
 */
public class MazeTraversalRun {
    public static void main(String[] arg){
        //Create a mazemap
        MazeMap mazeMap = new MazeMap();
        //Show the maze map
        mazeMap.print();
        System.out.println();
        //Start travelling the maze at the position [2][0]
        MazeTraversal mazeTraversal = new MazeTraversal(mazeMap,2,0);
        //To find the way out
        mazeTraversal.mazeTraversal();
        //Print the traveled map
        mazeTraversal.getTravelMap().print();
    }
}
