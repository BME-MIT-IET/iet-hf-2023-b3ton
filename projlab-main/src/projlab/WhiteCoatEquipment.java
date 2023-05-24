package projlab;

import java.util.Random;

/**
 *  A védőköpeny működését megvalósító Effect. Ha a viselő virológusra valaki ágenst akar használni, akkor 82,3%-kal kivédi azt.
 */
public class WhiteCoatEquipment extends Equipment {


    private Random rand;
    /**
     * Paraméter nélküli konstruktor
     */
    public WhiteCoatEquipment() {
        super();
        Skeleton.printMethodCall(toString(), "WhiteCoatEquipment()", true, null);
        Skeleton.printMethodCall(toString(), "WhiteCoatEquipment()", false, null);
        rand = new Random();
    }

    /**
     * Megvizsgálja, hogy az adott Effect WhiteCoatEquipment-e,
     * tehát 82.3 %-ban kivédi-e a Virológusra felhasznált Effectet
     * 
     * @return a vizsgált effect GlovesEquipment-e, mivel igen,
     *         a visszatérési érték 82.3%-ban true, egyébként false
     */
    @Override
    public boolean resist() {
        Skeleton.printMethodCall(toString(), "resist()", true, null);
        boolean resists = Controller.getDeterminism() || (100 * rand.nextDouble()) < 82.3;
        Skeleton.printMethodCall(toString(), "resist()", false, Boolean.toString(resists));
        return resists;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "WhiteCoatEquipment"
     */
    @Override
    public String toString() {
        return "WhiteCoatEquipment";
    }
}
