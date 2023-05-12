package projlab;

/**
 * Laboratóriumot reprezentáló osztály. A Field-ből származik le. A Field
 * felelősségei mellett képes visszaadni a benne lévő GeneticCode-ot.
 */
public class Laboratory extends Field {
    private GeneticCode geneticCode;

    /**
     * Paraméter nélküli konstruktor. Meghívja a Field konstruktorát.
     */
    public Laboratory() {
        super();
        Skeleton.printMethodCall(toString(), "Laboratory()", true, null);
        Skeleton.printMethodCall(toString(), "Laboratory()", false, null);
    }

    /**
     * Konstrukor egy GeneticCode-al.
     * Meghívja a Field konstruktorát, és beállítja a GeneticCode-ját a kapottra.
     * 
     * @param gc a beállítandó GeneticCode
     */
    public Laboratory(GeneticCode gc) {
        super();
        Skeleton.printMethodCall(toString(), "Laboratory(GeneticCode gc)", true, null);
        setGeneticCode(gc);
        Skeleton.printMethodCall(toString(), "Laboratory(GeneticCode gc)", false, null);
    }

    /**
     * A kapott GeneticCode beállítása.
     * Beállítja a tárolt GeneticCode-ot az új GeneticCode-ra.
     * Nem ellenőrzi, hogy a kapott GeneticCode null-e.
     * 
     * @param gc az új GeneticCode
     */
    public void setGeneticCode(GeneticCode gc) {
        Skeleton.printMethodCall(toString(), "setGeneticCode(GeneticCode gc)", true, null);
        geneticCode = gc;
        Skeleton.printMethodCall(toString(), "setGeneticCode(GeneticCode gc)", false, null);
    }

    /**
     * GeneticCode begyűjtése a Virologist által.
     * Átadja a tárolt GeneticCode-ot a begyűjtő Virologist-nak.
     * Nem ellenőrzi, hogy a begyűjtő Virologist null-e.
     * Visszaadja, hogy a Virologis sikeresen begyűjtötte-e a GeneticCode-ot.
     * 
     * @param v a begyűjtő Virologist
     * @return hogy sikeres volt-e az átadás
     */
    @Override
    public boolean collectBy(Virologist v) {
        Skeleton.printMethodCall(toString(), "collectBy(Virologist v)", true, null);
        Boolean added = v.addGeneticCode(geneticCode);
        Skeleton.printMethodCall(toString(), "collectBy(Virologist v)", false, added.toString());
        return added;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "Laboratory"
     */
    @Override
    public String toString() {
        return "Laboratory:" + id;
    }
}
