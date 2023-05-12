package projlab;

/**
 * A kesztyű működését megvalósító Equipment. A Virologist által használt Agent hatását visszaveri a küldőre, 
 * kivéve, ha nem adtak meg küldőt, vagy a Virologist önmagára kente az Agent-et. Három használat után eltűnik 
 * a Virologist készletéből.
 */
public class GlovesEquipment extends Equipment {
    private int uses;

    /**
     * Paraméter nélküli konstruktor
     */
    public GlovesEquipment() {
        super();
        uses = 3;
        Skeleton.printMethodCall(toString(), "GlovesEquipment()", true, null);
        Skeleton.printMethodCall(toString(), "GlovesEquipment()", false, null);
    }

    /**
     * Megvizsgálja, hogy az adott Effect GlovesEquipment-e,
     * tehát tudja-e visszadobni az adott Virologist a rá felhasznált
     * Effectet
     * 
     * @return a vizsgált effect GlovesEquipment-e,
     *         mivel igen, a visszatérési érték true
     */
    public boolean reflect() {
        Skeleton.printMethodCall(toString(), "reflect()", true, null);
        Boolean reflects;
        if (uses > 0) {
            reflects = true;
        } else {
            reflects = false;
        }
        --uses;
        Skeleton.printMethodCall(toString(), "reflect()", false, reflects.toString());
        return reflects;
    }

    /**
     *  Három használat után elhasználódik, ezért utána false-szal tér vissza, egyébként true-val.
     */
    @Override
    public boolean stillUsable() {
        Skeleton.printMethodCall(toString(), "stillUsable()", true, null);
        Boolean usable;
        if (uses > 0) {
            usable = true;
        } else {
            usable = false;
        }
        Skeleton.printMethodCall(toString(), "stillUsable()", false, usable.toString());
        return usable;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "GlovesEquipment"
     */
    @Override
    public String toString() {
        return "GlovesEquipment(" + uses + ")";
    }
}
