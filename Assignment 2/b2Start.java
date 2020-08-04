import java.util.HashMap;

/**
 * A class to start bagging the items
 *
 * @author Zer Jun Eng
 */
public class b2Start extends Prodn {

    final static String name = "START-BAGGING";
    final static String[] antes = {"step is start bagging"};
    final static String[] adds = {
        "step is get next item",
        "current bag 1 space 100",
        "total 1 bags"
    };
    final static String[] dels = {"step is start bagging"};

    final static String[] remarks = {"Starting to bag"};

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
