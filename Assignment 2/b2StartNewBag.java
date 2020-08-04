import java.util.HashMap;

/**
 * Starts a new bag if the current item cannot fit in any bags
 *
 * @author Zer Jun Eng
 */
public class b2StartNewBag extends Prodn {

    final static String name = "START-NEW-BAG";

    final static String[] antes = {
        "step is bag item",
        "current bag ?N space ?BS",
        "total ?T bags"
    };

    final static String[] adds = {
        "bag ?N space ?BS",
        "current bag ?NB space 100",
        "total ?NB bags"
    };

    final static String[] dels = {"current bag ?N space ?BS", "total ?T bags"};
    final static String[] remarks = {"Starting bag ?NB"};

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
    public boolean pred(HashMap context) {
        return true;
    }

    /**
     * Modifies the context after it matches the predicate
     *
     * @param context The context
     * @return The modified context
     */
    @Override
    public HashMap modifyContext(HashMap context) {
        Integer bagNumber = Integer.valueOf((String) context.get("?T"));
        context.put("?NB", String.valueOf(bagNumber + 1));
        return context;
    }
}
