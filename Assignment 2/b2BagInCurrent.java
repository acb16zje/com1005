import java.util.HashMap;

/**
 * Puts an item in the current bag
 *
 * @author Zer Jun Eng
 */
public class b2BagInCurrent extends Prodn {

    final static String name = "BAG-IN-CURRENT";

    final static String[] antes = {
        "step is bag item",
        "item to bag ?I space ?S",
        "current bag ?N space ?BS"
    };

    final static String[] adds = {
        "step is uncheck bag",
        "bag ?N contains ?I",
        "current bag ?N space ?RS",
        "step is get next item"
    };

    final static String[] dels = {
        "step is get suitable bag",
        "step is bag item",
        "item to bag ?I space ?S",
        "current bag ?N space ?BS",
        "bag ?N space ?BS (checked)"
    };

    final static String[] remarks = {"?I in bag ?N"};

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
        Integer spaceLeft = Integer.valueOf((String) context.get("?BS"));
        Integer spaceNeeded = Integer.valueOf((String) context.get("?S"));
        return spaceLeft >= spaceNeeded;
    }

    /**
     * Modifies the context after it matches the predicate
     *
     * @param context The context
     * @return The modified context
     */
    @Override
    HashMap modifyContext(HashMap context) {
        Integer spaceLeft = Integer.valueOf((String) context.get("?BS"));
        Integer spaceNeeded = Integer.valueOf((String) context.get("?S"));
        context.put("?RS", String.valueOf(spaceLeft - spaceNeeded));
        return context;
    }
}
