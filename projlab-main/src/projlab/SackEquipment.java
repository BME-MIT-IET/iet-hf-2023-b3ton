package projlab;

/**
 * A zsák működését megvalósító Effect. Megnöveli, hogy mennyi anyagot tud a virológus magánál tartani.
 */
public class SackEquipment extends Equipment {

    /**
     * Paraméter nélküli konstruktor
     */
    public SackEquipment() {
        super();
        Skeleton.printMethodCall(toString(), "SackEquipment()", true, null);
        Skeleton.printMethodCall(toString(), "SackEquipment()", false, null);
    }

    /**
     * Visszaadja, hogy hányszor annyi anyagot tud a virológus magánál tárolni. A maximum ellenőrzése előtt hívódik meg, 
     * a Virologist baseMaxMaterial attribútumát ezzel szorozva kapjuk meg a Virologist anyagtárolási kapacitását.
     * @return 2-t ad vissza, mivel kétszeres szorzót kap a Virologist
     *         az anyagkapacitására
     */
    @Override
    public double moreMaterial() {
        Skeleton.printMethodCall(toString(), "moreMaterial()", true, null);
        Double materialIncrease = 2.0;
        Skeleton.printMethodCall(toString(), "moreMaterial()", false, materialIncrease.toString());
        return materialIncrease;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "SackEquipment"
     */
    @Override
    public String toString() {
        return "SackEquipment";
    }
}
