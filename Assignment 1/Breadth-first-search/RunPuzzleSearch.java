/**
 * Run the solving algorithm for 8 puzzle search
 *
 * @author Zer Jun Eng
 */

public class RunPuzzleSearch {

    /**
     * The main method for the puzzle search
     *
     * @param args String[]	Command line arguments - not used
     */
    public static void main(String[] args) {
        // The target state for the puzzle
        final int[][] TARGET = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

        // Three initial configurations for test
        final int[][] P1 = {{1, 0, 3}, {4, 2, 6}, {7, 5, 8}};
        final int[][] P2 = {{4, 1, 3}, {7, 2, 5}, {0, 8, 6}};
        final int[][] P3 = {{2, 3, 6}, {1, 5, 8}, {4, 7, 0}};

        final int[][] P4 = {{8, 6, 7}, {2, 5, 4}, {3, 0, 1}};
        final int[][] P5 = {{6, 4, 7}, {8, 5, 0}, {3, 2, 1}};

        PuzzleSearch searcher = new PuzzleSearch(TARGET);
        SearchState initState = (SearchState) new PuzzleState(P2); // change P1 to change puzzle

        String resb = searcher.runSearch(initState, "Breadth-First");
        System.out.println(resb);

    }
}