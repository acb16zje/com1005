/**
 * Prodn.java Abstract class for productions which have antecedants, a predicate method, a
 * modifyContext method, add actions, delete actions & remark actions the antecedants are matched
 * against the STM. If they match a context is established if the pred succeeds for the context,
 * modifyContext runs, then the actions are caarried out using the resulting context
 *
 * @author Phil Green 2013 version
 */

import java.util.HashMap;

public abstract class Prodn {

    String name;    //production name
    String[] antes;    //antecedants
    String[] adds;    //additions to stm
    String[] dels;    //deletions from stm
    String[] remarks; //printouts on firing

    // can't give the accessor code here, otherwise don't get val from concrete class

    /**
     * Gets the name of the production
     *
     * @return The name of the production
     */
    abstract String getName();

    /**
     * Gets the antecedents of the production
     *
     * @return The antecedents of the production
     */
    abstract String[] getAntes();

    /**
     * Gets the additions to the STM
     *
     * @return The additions to the STM
     */
    abstract String[] getAdds();

    /**
     * Gets the deletions from the STM
     *
     * @return The deletions from the STM
     */
    abstract String[] getDels();

    /**
     * Gets the result on firing a production
     *
     * @return The result on firing a production
     */
    abstract String[] getRemarks();

    /**
     * Checks if the context matches the antecedents
     *
     * @param context The context
     * @return True if the context matches the antecedents
     */
    abstract boolean pred(HashMap context);

    /**
     * Modifies the context after it matches the predicate
     *
     * @param context The context
     * @return The modified context
     */
    abstract HashMap modifyContext(HashMap context);
}