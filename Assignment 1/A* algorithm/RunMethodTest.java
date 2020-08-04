/**
 * A class for testing methods
 *
 * @author Zer Jun Eng
 */
public class RunMethodTest {

    /**
     * The main method for the testing
     *
     * @param args String[]	Command line arguments - not used
     */
    public static void main(String[] args) {
        // The puzzle arrays to be tested
        final int[][] TARGET_TEST = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        final int[][] TEST_1 = {{7, 2, 4}, {5, 1, 8}, {3, 6, 0}};
        final int[][] TEST_2 = {{8, 6, 7}, {2, 5, 4}, {3, 0, 1}};

        // Test the methods in PuzzleSearch.java and PuzzleState.java
        PuzzleSearch testPuzzleSearch1 = new PuzzleSearch(TARGET_TEST, "hamming");
        PuzzleSearch testPuzzleSearch2 = new PuzzleSearch(TARGET_TEST, "manhattan");
        PuzzleState testPuzzleState1 = new PuzzleState(TEST_1, 0, 0);
        PuzzleState testPuzzleState2 = new PuzzleState(TEST_2, 0, 0);
        PuzzleState testPuzzleState3 = new PuzzleState(TARGET_TEST, 0, 0);

        int[][] testTargetPrint = testPuzzleSearch1.getTargetPuzzle();
        int[][] test3 = testPuzzleState2.copyPuzzle(); // deep copying of TEST_2

        System.out.println("Testing the methods in PuzzleSearch.java");

        // getTargetPuzzle() method test
        /** It should print out
         * 1 2 3
         * 4 5 6
         * 7 8 0
         */
        System.out.println("\nTesting method getTargetPuzzle(), test print of TARGET_TEST");
        for (int i = 0; i < testTargetPrint.length; i++) {
            for (int j = 0; j < testTargetPrint[i].length; j++) {
                System.out.print(testTargetPrint[i][j] + " ");
            }
            System.out.println();
        }

        // getDistanceMethod() method test
        System.out.println("\nTesting method getDistanceMethod()");
        System.out.println("The testPuzzleSearch1 distance method is: " + testPuzzleSearch1
            .getDistanceMethod()); // hamming
        System.out.println("The testPuzzleSearch2 distance method is: " + testPuzzleSearch2
            .getDistanceMethod()); // manhattan

        System.out.println("\n==========================");

        int[][] testPrint2 = testPuzzleState2.getCurrentPuzzle();
        int[][] testPrint3 = testPuzzleState3.getCurrentPuzzle();
        System.out.println("Testing the methods in PuzzleState.java");

        // getCurrentPuzzle() method test
        /** It should print out
         * 8 6 7
         * 2 5 4
         * 3 0 1
         */
        System.out.println("\nTesting method getCurrentPuzzle(), test print of TEST_2");
        for (int i = 0; i < testPrint2.length; i++) {
            for (int j = 0; j < testPrint2[i].length; j++) {
                System.out.print(testPrint2[i][j] + " ");
            }
            System.out.println();
        }

        // getEmptyTileRow() and getEmptyTileColumn() methods test
        // It should print out 2 for the row and 2 for the column
        System.out.println(
            "The empty tile row of TEST_2 is: " + testPuzzleState2.getEmptyTileRow(TEST_2));
        System.out.println(
            "The empty tile column of TEST_2 is: " + testPuzzleState2.getEmptyTileColumn(TEST_2));

        // swapTile() method test
        /** It should print out
         * 8 6 7
         * 2 0 4
         * 3 5 1
         */
        System.out.println(
            "Testing swapTile() method, swap (" + testPuzzleState2.getEmptyTileRow(TEST_2) + ", "
                + testPuzzleState2.getEmptyTileColumn(TEST_2) + ") with (1, " + testPuzzleState2
                .getEmptyTileColumn(TEST_2) + "): ");
        int[][] swapTestPuzzleState2 = testPuzzleState2
            .swapTile(testPuzzleState2.getEmptyTileRow(TEST_2),
                testPuzzleState2.getEmptyTileColumn(TEST_2),
                testPuzzleState2.getEmptyTileRow(TEST_2) - 1,
                testPuzzleState2.getEmptyTileColumn(TEST_2));
        for (int i = 0; i < swapTestPuzzleState2.length; i++) {
            for (int j = 0; j < swapTestPuzzleState2[i].length; j++) {
                System.out.print(swapTestPuzzleState2[i][j] + " ");
            }
            System.out.println();
        }

        // copyPuzzle() method test
        /** It should print out
         * 0 1 2
         * 3 4 5
         * 6 7 8
         */
        System.out.println("\nTesting method copyPuzzle(), which returns a deep copy of TEST_2");
        for (int i = 0; i < test3.length; i++) {
            for (int j = 0; j < test3[i].length; j++) {
                System.out.print(test3[i][j] + " ");
            }
            System.out.println();
        }

        // It should print out the same value as TEST_2
        System.out.println(
            "The empty tile row of test3 is: " + testPuzzleState2.getEmptyTileRow(TEST_2)
                + "    // Row 2, same as TEST_2");
        System.out.println(
            "The empty tile column of test is: " + testPuzzleState2.getEmptyTileColumn(TEST_2)
                + "    // Column 1, same as TEST_2");

        // sameState() method test
        System.out.println("\nTesting the sameState() method, using test3:");
        System.out.println(
            "Is TEST_1 same as TEST_1 : " + testPuzzleState1.sameState(testPuzzleState1)
                + "    // same puzzle"); // true
        System.out.println(
            "Is TEST_1 same as TEST_2 : " + testPuzzleState1.sameState(testPuzzleState2)
                + "    // two different puzzles"); // false
        System.out.println(
            "Is TEST_1 same as test3 : " + testPuzzleState1.sameState(testPuzzleState3)
                + "    // two different puzzles"); // false
        System.out.println(
            "Is TEST_2 same as test3 : " + testPuzzleState2.sameState(testPuzzleState3)
                + "    // test3 is a deep copy of TEST_2"); // true

        // goalP() method test
        System.out.println("\nTesting the goalP() method");
        System.out
            .println("Is TEST_1 a goal : " + testPuzzleState1.goalP(testPuzzleSearch1)); // false
        System.out
            .println("Is TEST_2 a goal : " + testPuzzleState2.goalP(testPuzzleSearch1)); // false
        System.out.println(
            "Is TARGET_TEST a goal : " + testPuzzleState3.goalP(testPuzzleSearch1)); // false

        // getHammingDistance test
        System.out.println("\ngetHammingDistance() method test");
        System.out.println("This is the target state: " + testPuzzleState1
            .getHammingDistance(TARGET_TEST, TARGET_TEST) + "    // 0");
        System.out.println("This is the puzzle used in the assignment document: " + testPuzzleState1
            .getHammingDistance(TEST_1, TARGET_TEST) + "    // 7");
        System.out.println("This is one of the hardest puzzle (TEST_2): " + testPuzzleState1
            .getHammingDistance(TEST_2, TARGET_TEST) + "    // 8");

        // getManhattanDistance test
        System.out.println("\ngetManhattanDistance() method test");
        System.out.println("This is the target state: " + testPuzzleState1
            .getManhattanDistance(TARGET_TEST, TARGET_TEST) + "    // 0");
        System.out.println("This is the puzzle used in the assignment document: " + testPuzzleState1
            .getManhattanDistance(TEST_1, TARGET_TEST) + "    // 16");
        System.out.println("This is one of the hardest puzzle (TEST_2): " + testPuzzleState1
            .getManhattanDistance(TEST_2, TARGET_TEST) + "    // 22");
    }
}
