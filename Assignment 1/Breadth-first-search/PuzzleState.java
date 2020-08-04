/**
 * Represent the state in solving the 8 puzzle
 *
 * @author Zer Jun Eng
 */

public class PuzzleState extends SearchState {

    private int[][] currentPuzzle;
    private int emptyTileRow;
    private int emptyTileColumn;

    /**
     * The constructor for PuzzleState that takes current puzzle state as parameter
     *
     * @param currPuzzle The current puzzle state
     */
    public PuzzleState(int[][] currPuzzle) {
        this.currentPuzzle = currPuzzle;
    }

    public int[][] getCurrentPuzzle() {
        return this.currentPuzzle;
    }

    /**
     * Gets the row of the empty tile
     *
     * @param currPuzzle The current puzzle state
     * @return The row of the empty tile
     */
    public int getEmptyTileRow(int[][] currPuzzle) {
        for (int i = 0; i < currPuzzle.length; i++) {
            for (int j = 0; j < currPuzzle[i].length; j++) {
                if (currPuzzle[i][j] == 0) {
                    this.emptyTileRow = i;
                    break;
                }
            }
        }

        return this.emptyTileRow;
    }

    /**
     * Gets the column of the empty tile
     *
     * @param currPuzzle The current puzzle state
     * @return The column of the empty tile
     */
    public int getEmptyTileColumn(int[][] currPuzzle) {
        for (int i = 0; i < currPuzzle.length; i++) {
            for (int j = 0; j < currPuzzle[i].length; j++) {
                if (currPuzzle[i][j] == 0) {
                    this.emptyTileColumn = j;
                    break;
                }
            }
        }

        return this.emptyTileColumn;
    }

    /**
     * goalP takes a SearchNode and returns true if it's a goal
     *
     * @param searcher The current search
     * @return True if the state is a goal
     */
    public boolean goalP(Search searcher) {
        PuzzleSearch pSearcher = (PuzzleSearch) searcher;

        // Get the target puzzle state
        int[][] target = pSearcher.getTargetPuzzle();

        return (Arrays.deepEquals(currentPuzzle, target));
    }

    /**
     * Returns an ArrayList of states which are successors to the current state in a given search
     *
     * @param searcher The current search
     * @return The ArrayList of successor node
     */
    public ArrayList<SearchState> getSuccessors(Search searcher) {
        PuzzleSearch pSearcher = (PuzzleSearch) searcher;
        int currentEmptyRow = getEmptyTileRow(currentPuzzle);
        int currentEmptyColumn = getEmptyTileColumn(currentPuzzle);
        int[][] checkPuzzle = pSearcher.getTargetPuzzle();

        // The lists of puzzle states and search states
        ArrayList<PuzzleState> puzzleStateList = new ArrayList<PuzzleState>();
        ArrayList<SearchState> searchStateList = new ArrayList<SearchState>();

        // If the upper tile is not correct, move the empty tile up
        if (currentEmptyRow > 0) {
            if (currentPuzzle[currentEmptyRow - 1][currentEmptyColumn] != checkPuzzle[
                currentEmptyRow - 1][currentEmptyColumn]) {
                puzzleStateList.add(new PuzzleState(
                    swapTile(currentEmptyRow, currentEmptyColumn, currentEmptyRow - 1,
                        currentEmptyColumn)));
            }
        }

        // If the lower tile is not correct, move the empty tile down
        if (currentEmptyRow < currentPuzzle.length - 1) {
            if (currentPuzzle[currentEmptyRow + 1][currentEmptyColumn] != checkPuzzle[
                currentEmptyRow + 1][currentEmptyColumn]) {
                puzzleStateList.add(new PuzzleState(
                    swapTile(currentEmptyRow, currentEmptyColumn, currentEmptyRow + 1,
                        currentEmptyColumn)));
            }
        }

        // If the tile on the left is not correct, move the empty tile left
        if (currentEmptyColumn > 0) {
            if (currentPuzzle[currentEmptyRow][currentEmptyColumn - 1]
                != checkPuzzle[currentEmptyRow][currentEmptyColumn - 1]) {
                puzzleStateList.add(new PuzzleState(
                    swapTile(currentEmptyRow, currentEmptyColumn, currentEmptyRow,
                        currentEmptyColumn - 1)));
            }
        }

        // If the tile on the right is not correct, move the empty tile right
        if (currentEmptyColumn < currentPuzzle[0].length - 1) {
            if (currentPuzzle[currentEmptyRow][currentEmptyColumn + 1]
                != checkPuzzle[currentEmptyRow][currentEmptyColumn + 1]) {
                puzzleStateList.add(new PuzzleState(
                    swapTile(currentEmptyRow, currentEmptyColumn, currentEmptyRow,
                        currentEmptyColumn + 1)));
            }
        }

        // Cast the puzzle states as search states in searchStateList
        for (PuzzleState puzzleState : puzzleStateList) {
            searchStateList.add((SearchState) puzzleState);
        }

        return searchStateList;
    }

    /**
     * Swaps the empty tile with the tile provided as parameter
     *
     * @param emptyRow The row of empty tile
     * @param emptyColumn The column of empty tile
     * @param toRow The row to swap with the empty tile
     * @param toColumn The column to swap with the empty tile
     * @return The swapped puzzle state
     */
    public int[][] swapTile(int emptyRow,
        int emptyColumn,
        int toRow,
        int toColumn) {
        int[][] tempPuzzle = copyPuzzle();

        tempPuzzle[emptyRow][emptyColumn] = tempPuzzle[toRow][toColumn];
        tempPuzzle[toRow][toColumn] = 0;

        return tempPuzzle;
    }

    /**
     * Copy the current puzzle state
     *
     * @return The deep copy of the current puzzle
     */
    public int[][] copyPuzzle() {
        int[][] tempPuzzle = new int[currentPuzzle.length][currentPuzzle[0].length];

        for (int i = 0; i < currentPuzzle.length; i++) {
            for (int j = 0; j < currentPuzzle[i].length; j++) {
                tempPuzzle[i][j] = currentPuzzle[i][j];
            }
        }

        return tempPuzzle;
    }

    /**
     * Check if another node has the same state as the current one
     *
     * @param n2 The other node
     * @return True if both the nodes have the same state
     */
    public boolean sameState(SearchState n2) {
        PuzzleState puzzleState2 = (PuzzleState) n2;

        return (Arrays.deepEquals(currentPuzzle, puzzleState2.getCurrentPuzzle()));
    }

    /**
     * Converts the puzzle array into a string
     *
     * @return A string representation of the puzzle
     */
    public String toString() {
        String s = "\n";
        for (int i = 0; i < currentPuzzle.length; i++) {
            for (int j = 0; j < currentPuzzle[i].length; j++) {
                s += currentPuzzle[i][j] + " ";
            }
            s += "\n";
        }

        return s;
    }
}