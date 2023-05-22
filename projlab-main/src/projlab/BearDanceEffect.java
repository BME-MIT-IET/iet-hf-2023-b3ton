package projlab;

/**
 * Egyfajta Effect.
 * A medvetánc hatást megvalósító osztály. A hatása alatti Virologist véletlenszerűen lépked 
 * (hasChorea(): boolean), elpusztít mindent a raktárban (rampage(): boolean), és terjeszti 
 * a BearDanceVirus-t (spreads(): Agent)
 */
public class BearDanceEffect extends Effect {

    /**
     * Mivel a hatás alatt a virológus végig vítustáncot jár,
     * ezért mindig igazzal tér vissza.
     * 
     * @return true
     */
    @Override
    public boolean hasChorea() {
        Skeleton.printMethodCall(toString(), "hasChorea()", true, Boolean.toString(true));
        Skeleton.printMethodCall(toString(), "hasChorea()", false, Boolean.toString(true));
        return true;
    }

    /**
     * Megadja, hogy tombolni kezd-e a virológus. 
     * Mivel a hatás alatt a virológus tombol, azaz elpusztítja az útjába eső Storage-ban a nyersanyagokat, 
     * ezért mindig igazzal tér vissza.
     * @return tombolni kezd-e
     */
    @Override
    public boolean rampage() {
        Skeleton.printMethodCall(toString(), "rampage()", true, null);
        Boolean destroys = true;
        Skeleton.printMethodCall(toString(), "rampage()", false, destroys.toString());
        return destroys;
    }

    /**
     * Megadja, hogy elterjed-e a vírus.
     *  Mivel a BearDanceVirus terjed, ezért a függvény mindig visszaad egy példányt a BearDanceVirus-ból.
     * @return BearDanceVirus
     */
    @Override
    public Agent spreads() {
        Skeleton.printMethodCall(toString(), "spreads()", true, null);
        BearDanceVirus bv = new BearDanceVirus();
        Skeleton.printMethodCall(toString(), "reflect()", false, bv.toString());
        return bv;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "BearDanceEffect"
     */
    @Override
    public String toString() {
        return "BearDanceEffect";
    }
}
