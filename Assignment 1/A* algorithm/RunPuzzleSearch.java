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
        final int[][] P1 = {{1, 0, 3}, {4, 2, 6}, {7, 5, 8}};
        final int[][] P2 = {{4, 1, 3}, {7, 2, 5}, {0, 8, 6}};
        final int[][] P3 = {{2, 3, 6}, {1, 5, 8}, {4, 7, 0}};
        final int[][] P7 = {{7, 2, 4}, {5, 1, 8}, {3, 6, 0}};

        // "Hardest" puzzle, Hamming takes very long time to solve, while Manhattan can solve it in under a minute
        final int[][] P4 = {{8, 6, 7}, {2, 5, 4}, {3, 0, 1}};
        final int[][] P5 = {{6, 4, 7}, {8, 5, 0}, {3, 2, 1}};

        EpuzzGen puzzleGenerator = new EpuzzGen(12345); // Seed "12345"

        int[][] puzzle = puzzleGenerator.puzzGen(6); // Difficulty "6"

        PuzzleSearch searcher = new PuzzleSearch(TARGET,
            "hamming"); // Hamming or Manhattan, not case-sensitive
        SearchState initState = (SearchState) new PuzzleState(puzzle, 0,
            0); // Can change puzzle to P1, P2 or P3

        String res_aStar = searcher.runSearch(initState, "AStar");
        System.out.println(res_aStar);

    }
}