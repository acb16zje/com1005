import java.util.HashMap;

/**
 * Removes the bag with empty space from STM after unchecking
 *
 * @author Zer Jun Eng
 */
public class b2RemoveEmptyBag extends Prodn {

    final static String name = "REMOVE-EMPTY-BAG";
    final static String[] antes = {"bag ?PB space 0"};
    final static String[] adds = {};
    final static String[] dels = {"step is uncheck bag", "bag ?PB space 0"};
    final static String[] remarks = {"Removing bag ?PB"};

    /**
     * Gets the name of the production
     *
     * @return The name of the production
     */
    @Override
    String getName() {
        return name;
    }

    /**
     * Gets the antecedents of the production
     *
     * @return The antecedents of the production
     */
    @Override
    String[] getAntes() {
        return antes;
    }

    /**
     * Gets the additions to the STM
     *
     * @return The additions to the STM
     */
    @Override
    String[] getAdds() {
        return adds;
    }

    /**
     * Gets the deletions from the STM
     *
     * @return The deletions from the STM
     */
    @Override
    String[] getDels() {
        return dels;
    }

    /**
     * Gets the result on firing a production
     *
     * @return The result on firing a production
     */
    @Override
    String[] getRemarks() {
        return remarks;
    }

    /**
     * Checks if the context matches the antecedents
     *
     * @param context The context
     * @return True if the context matches the antecedents
     */
    @Override
    boolean pred(HashMap context) {
        return true;
    }

    /**
     * Modifies the context after it matches the predicate
     *
     * @param context The context
     * @return The modified context
     */
    @Override
    HashMap modifyContext(HashMap context) {
        return context;
    }
}
