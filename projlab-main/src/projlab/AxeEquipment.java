package projlab;

/**
 * A balta működését megvalósító Equipment.
 * Segítségével meg lehet ölni egy másik Virologist-et 
 * Egyszer használható.
 */
public class AxeEquipment extends Equipment {
    private int uses;   // még ennyiszer lehet használni

    public AxeEquipment() {
        uses = 1;   // egyszer használható
    }

    /**
     * Megadja, hogy a fegyver halálos-e, vagy sem.
     * Mivel a balta halálos fegyver, ezért igazzal tér vissza.
     * Az első használat után azonban kicsorbul, tehát az első 
     * használat után már false-al tér vissza.
     * @return halálos-e
     */
    @Override
    public boolean lethal() {
        Boolean lethal;
        if (uses-- > 0) { // megnézi, hogy lehet-e használni, és csökkenti a használatot
            lethal = true; // ha még van használat, akkor igazzal tér vissza
        } else {    //nincs több használat, tehát hamissal tér vissza
            lethal = false;
        }
        return lethal;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "AxeEquipment"
     */
    @Override
    public String toString() {
        return "AxeEquipment(" + uses + ")";
    }
}
