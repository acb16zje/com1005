/**
 * A class to search for optimal path of 8 puzzle
 *
 * @author Zer Jun Eng
 */

public class PuzzleSearch extends Search {

    // Variables
    private int[][] targetPuzzle;
    private String distanceMethod;

    /**
     * A constructor that takes target puzzle state as parameter
     *
     * @param tarPuzzle The target state of the puzzle
     */
    public PuzzleSearch(int[][] tarPuzzle, String dMethod) {
        this.targetPuzzle = tarPuzzle;
        this.distanceMethod = dMethod.toLowerCase();
    }

    /**
     * Gets the state of the target puzzle
     *
     * @return The target puzzle
     */
    public int[][] getTargetPuzzle() {
        return this.targetPuzzle;
    }

    /**
     * Gets the distance method the user wants to use
     *
     * @return The distance method input by user
     */
    public String getDistanceMethod() {
        return this.distanceMethod;
    }
}