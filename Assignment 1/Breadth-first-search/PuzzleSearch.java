/**
 * A class to search for optimal path of 8 puzzle
 *
 * @author Zer Jun Eng
 */

public class PuzzleSearch extends Search {

    // Variables
    private int[][] targetPuzzle;

    /**
     * A constructor that takes target puzzle state as parameter
     *
     * @param tarPuzzle The target state of the puzzle
     */
    public PuzzleSearch(int[][] tarPuzzle) {
        this.targetPuzzle = tarPuzzle;
    }

    /**
     * Gets the state of the target puzzle
     *
     * @return The target puzzle
     */
    public int[][] getTargetPuzzle() {
        return this.targetPuzzle;
    }

}