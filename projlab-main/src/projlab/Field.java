package projlab;

import java.util.HashSet;
import java.util.Set;

/**
 * A szabad területet reprezentáló osztály. Eltárolja a szomszéd Field-eket és
 * a rajta található Virologist-okat. Képes új szomszédot felvenni és
 * Virologist-ot ki- és beléptetni. Fel lehet venni a rajta található
 * objektumokat.
 */
public class Field {

    /**
     * A Field id-ja
     */
    protected final int id;

    /**
     *  a Fielddel szomszédos Fieldek listája
     */
    private Set<Field> neighbourFields;

    /**
     *  a Fielden tartózkodó Virologistok listája
     */
    protected Set<Virologist> virologists;

    /**
     * Paraméter nélküli konstrukor.
     * Inicializálja a szomszéd Field és a rajta álló Virologist tömböt.
     */
    public Field() {
        id = Controller.getNewId();
        Skeleton.printMethodCall(toString(), "Field()", true, null);
        neighbourFields = new HashSet<>();
        virologists = new HashSet<>();
        Skeleton.printMethodCall(toString(), "Field()", false, null);
    }

    /**
     * visszaadja az id értékét.
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Null-t ad vissza, a Shelter esetben van felüldefiniálva
     * @return null
     */
    public Equipment getEquipment(){
        return null;
    }

    /**
     * Egy új szomszéd beállítása.
     * Hozzáadja a tárolt "szomszédok" tömbhöz a kapott Field-et.
     * 
     * @param f a hozzáadandó Field
     */
    public void setNeighbor(Field f) {
        Skeleton.printMethodCall(toString(), "setNeighbor(Field f)", true, null);
        neighbourFields.add(f);
        Skeleton.printMethodCall(toString(), "setNeighbor(Field f)", false, null);
    }

    /**
     * Visszaadja a Mező szomszédjait.
     * 
     * @return a szomszédok listája
     */
    public Set<Field> getNeighbors() {
        Skeleton.printMethodCall(toString(), "getNeighbors()", true, null);
        Skeleton.printMethodCall(toString(), "getNeighbors()", false, neighbourFields.toString());
        return neighbourFields;
    } 

    /**
     * Visszaadja a Mezőn álló virológusokat.
     * 
     * @return a mezőn álló virológusok listája
     */
    public Set<Virologist> getVirologists() {
        Skeleton.printMethodCall(toString(), "getVirologists()", true, null);
        Skeleton.printMethodCall(toString(), "getVirologists()", false, neighbourFields.toString());
        return virologists;
    }

    /**
     * Virologist beléptetése.
     * Hozzáadja a rajta lévő Virologist-okhoz a kapott Virologist-ot.
     * 
     * @param v a beléptetendő Virologist
     */
    public void stepIn(Virologist v) {
        Skeleton.printMethodCall(toString(), "stepIn(Virologist v)", true, null);
        virologists.add(v);
        Skeleton.printMethodCall(toString(), "stepIn(Virologist v)", false, null);
    }

    /**
     * Virologist kiléptetése.
     * Kiveszi a rajta lévő Virologist-okból a kapott Virologist-ot.
     * Nem jelzi, hogy a kapott Virolgist már korábban a Field-en volt-e.
     * 
     * @param v a kiléptetendő Virologist
     */
    public void stepOut(Virologist v) {
        Skeleton.printMethodCall(toString(), "stepOut(Virologist v)", true, null);
        virologists.remove(v);
        Skeleton.printMethodCall(toString(), "stepOut(Virologist v)", false, null);
    }

    /**
     * A mezőn lévő objektumok odaadása a Virologist-nak.
     * A Field nem tárol objektumokat, ezért mindig false értékkel tér vissza.
     * 
     * @return false
     */
    public boolean collectBy(Virologist v) {
        Skeleton.printMethodCall(toString(), "collectBy(Virologist v)", true, null);
        Boolean result = false;
        Skeleton.printMethodCall(toString(), "collectBy(Virologist v)", false, result.toString());
        return result;
    }

    /**
     * Végigmegy az összes tárolt Virologist-on (kivéve a ‘by’-ban átadottat), és meghívja a kapott 
     * Agent useOnBy(on: Virologist, by: Virologist) függvényét, ‘on’ paraméterként a Field-en lévő Virologist-ot, 
     * ‘by’-ként a kapott Virologist-ot átadva.
     * @param a Terjesztett ágens
     * @param by Terjesztő Virologist
     */
    public void spreadAgentBy(Agent a, Virologist by) {
        for (Virologist v : virologists) {
            if (v != by) {
                a.useOnBy(v, by);
            }
        }
    }

    /**
     * elpusztítja a mezőn lévő tárgyakat. Alapesetben nem csinál semmit, de a leszármazottak felüldefiniálhatják.
     */
    public void clearMaterial() {
        // Mivel nem abstract az osztály ezért meg lehet hívni a függvényt... de nem kéne
        // throw new UnsupportedOperationException() ;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "Field"
     */
    @Override
    public String toString() {
        return "Field:" + id;
    }
}
