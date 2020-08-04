import java.util.ArrayList;
import sheffield.EasyWriter;

/**
 * A class to run the bagging production system
 *
 * @author Zer Jun Eng
 */
public class TestPS {

    /**
     * The main method for TestPS
     *
     * @param args Command line arguments, not used
     */
    public static void main(String[] args) {

        /* Create objects for input and output */
        EasyWriter screen = new EasyWriter();
        ArrayList<Prodn> bagger2 = new ArrayList<>(); // make the bagger2 rules
        bagger2.add(new b2Start());
        bagger2.add(new b2UncheckBag());
        bagger2.add(new b2GetNextItem());
        bagger2.add(new b2GetSuitableBag());
        bagger2.add(new b2BagInCurrent());
        bagger2.add(new b2RemoveEmptyBag());
        bagger2.add(new b2StartNewBag());

        /* Initial facts */
        ArrayList<String> stm = new ArrayList<>();
        stm.add("step is start bagging");

        /* Generates a random trolley */
        TrolleyGen trolley = new TrolleyGen(12345, 10);
        String[] trolleyItems = trolley.fillTrolley();
        for (String trolleyItem : trolleyItems) {
            stm.add(trolleyItem);
        }

        /* Production system engine */
        ProdSys ps = new ProdSys(bagger2);
        ArrayList<String> res = ps.RunPS(stm);
        screen.println("Final STM");
        screen.println(res);
    }
}
