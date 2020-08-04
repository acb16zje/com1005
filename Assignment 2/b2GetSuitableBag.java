import java.util.HashMap;

/**
 * Gets the bag with most suitable space for the next item
 *
 * @author Zer Jun Eng
 */
public class b2GetSuitableBag extends Prodn {

    final static String name = "GET-SUITABLE-BAG";

    final static String[] antes = {
        "step is get suitable bag",
        "item to bag ?I space ?S",
        "bag ?PB space ?PBS", // all the previous bags
        "current bag ?N space ?BS"
    };

    final static String[] adds = {
        "bag ?PB space ?PBS (checked)", // mark the checked bag
        "current bag ?SB space ?SBS",   // change the current bag to the most suitable bag
        "bag ?NB space ?NBS (checked)" // if the suitable bag is the current bag
    };

    final static String[] dels = {
        "step is uncheck bag",
        "bag ?PB space ?PBS",
        "current bag ?N space ?BS"
    };

    final static String[] remarks = {"Bagging ?I in bag ?SB"};

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
        Integer currentBagNo = Integer.valueOf((String) context.get("?N"));
        Integer currentBagSpace = Integer.valueOf((String) context.get("?BS"));
        Integer previousBagNo = Integer.valueOf((String) context.get("?PB"));
        Integer previousBagSpace = Integer.valueOf((String) context.get("?PBS"));
        Integer spaceNeeded = Integer.valueOf((String) context.get("?S"));

        /*
        *  Compares the current bag with all the previous bags,
        *  the most suitable bag is selected based on the remaining space
        *  If the current bag is the most suitable bag,
        *  bag 0 space 0 (checked) is added and will be deleted later
        */
        if (currentBagSpace < spaceNeeded && previousBagSpace < spaceNeeded) {
            context.put("?SB", String.valueOf(currentBagNo));
            context.put("?SBS", String.valueOf(currentBagSpace));
            context.put("?NB", String.valueOf(0));
            context.put("?NBS", String.valueOf(0));
            return context;
        } else if (currentBagSpace < spaceNeeded) {
            context.put("?SB", String.valueOf(previousBagNo));
            context.put("?SBS", String.valueOf(previousBagSpace));
            context.put("?NB", String.valueOf(currentBagNo));
            context.put("?NBS", String.valueOf(currentBagSpace));
            return context;
        } else if (previousBagSpace < spaceNeeded) {
            context.put("?SB", String.valueOf(currentBagNo));
            context.put("?SBS", String.valueOf(currentBagSpace));
            context.put("?NB", String.valueOf(0));
            context.put("?NBS", String.valueOf(0));
            return context;
        } else if (currentBagSpace - spaceNeeded <= previousBagSpace - spaceNeeded) {
            context.put("?SB", String.valueOf(currentBagNo));
            context.put("?SBS", String.valueOf(currentBagSpace));
            context.put("?NB", String.valueOf(0));
            context.put("?NBS", String.valueOf(0));
            return context;
        } else if (previousBagSpace - spaceNeeded <= currentBagSpace - spaceNeeded) {
            context.put("?SB", String.valueOf(previousBagNo));
            context.put("?SBS", String.valueOf(previousBagSpace));
            context.put("?NB", String.valueOf(currentBagNo));
            context.put("?NBS", String.valueOf(currentBagSpace));
            return context;
        }

        return context;
    }
}
