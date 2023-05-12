package projlab;

/**
 * A raktárat reprezentáló osztály. A Fieldből származik le. A Field
 * felelősségei mellett átadni a benne lévő aminosavot és nukleotidot,
 * aminek mindig nemnegatívnak kell lennie.
 */
public class Storage extends Field {
    /**
     *  Amennyi nukleotidot tárol a Storage.
     */
    int nucleotideStored;

    /**
     * Amennyi aminosavat tárol a Storage.
     */
    int aminoAcidStored;

    /**
     * Paraméter nélküli konstruktor. Meghívja a Field konstruktorát.
     */
    public Storage() {
        super();
        Skeleton.printMethodCall(toString(), "Storage()", true, null);
        Skeleton.printMethodCall(toString(), "Storage()", false, null);
    }

    /**
     * Visszaadja a Storageban lévő aminoacidok számát
     * @return Storageban lévő aminoacidok száma
     */
    public int getAminoAcid(){
        return aminoAcidStored;
    }

    /**
     * Visszaadja a Storageban lévő nucleotidok számát
     * @return Storageban lévő nucleotidok száma
     */
    public int getNucleotide(){
        return nucleotideStored;
    }

    /**
     * Belépteti a ‘v’ Virologist objektumot a mezőre, azaz beteszi a virologists tömbbe, majd meghívja a ‘v’ rampage() függvényét.
     */
    @Override
    public void stepIn(Virologist v) {
        Skeleton.printMethodCall(toString(), "stepIn(Virologist v)", true, null);
        virologists.add(v);
        v.rampage();
        Skeleton.printMethodCall(toString(), "stepIn(Virologist v)", false, null);
    }

    /**
     *  A Storage-ban lévő nukleotid és aminosav mennyiségét 0-ra állítja.
     */
    @Override
    public void clearMaterial() {
        setAminoAcid(0);
        setNucleotide(0);
    }

    /**
     * Konstruktor a kezdő nukleotid és aminsav értékkel.
     * Meghívja a Field konstruktorát, majd beállítja
     * a nukelotid és aminosav értéket a kezdőértékre.
     * Amennyiben bármelyik átadott érték negatív lenne, nullára állítja be azt.
     * 
     * @param nucleotide a kezdő nukleotid érték
     * @param aminoAcid  a kezdő aminosav érték
     */
    public Storage(int nucleotide, int aminoAcid) {
        super();
        Skeleton.printMethodCall(toString(), "Storage(int nucleotide, int aminoAcid)", true, null);
        setNucleotide(nucleotide);
        setAminoAcid(aminoAcid);
        Skeleton.printMethodCall(toString(), "Storage(int nucleotide, int aminoAcid)", false, null);
    }

    /**
     * Nukleotid beállítása az új értékre.
     * Amennyiben az új érték negatív, a tárolt érték nem változik.
     * 
     * @param newValue a tárolt nukleotid új értéke
     */
    public void setNucleotide(int newValue) {
        Skeleton.printMethodCall(toString(), "setNucleotide(int newValue)", true, null);
        if (newValue >= 0) {
            nucleotideStored = newValue;
        }
        Skeleton.printMethodCall(toString(), "setNucleotide(int newValue)", false, null);
    }

    /**
     * Aminosav beállítása az új értékre.
     * Amennyiben az új érték negatív, a tárolt érték nem változik.
     * 
     * @param newValue a tárolt aminosav új értéke
     */
    public void setAminoAcid(int newValue) {
        Skeleton.printMethodCall(toString(), "setAminoAcid(int newValue)", true, null);
        if (newValue >= 0) {
            aminoAcidStored = newValue;
        }
        Skeleton.printMethodCall(toString(), "setAminoAcid(int newValue)", false, null);
    }

    /**
     * Az aminosav és nukleotid begyűjtése a Virologist által.
     * Átad annyi aminosavat és nukleotidot a begyűjtő Virologist-nak,
     * amennyit a Virologist el tud tárolni, és a maradékkal felülírja
     * a Storage-ben tárolt értéket.
     * Nem ellenőrzi, hogy a begyűjtő Virologist null-e.
     * False-al tér vissza, ha üres a Shelter, egyébként true-val.
     * 
     * @param v a begyűjtő Virologist
     * @return hogy a Shelterben volt-e begyűjthető anyag
     */
    @Override
    public boolean collectBy(Virologist v) {
        Skeleton.printMethodCall(toString(), "collectBy(Virologist v)", true, null);

        Boolean collected;
        if (nucleotideStored == 0 && aminoAcidStored == 0) {
            collected = false;
        } else {
            // elrakja azt az értéket, amit a Virologist nem tudott felszedni
            int nucleotideRemaining = v.addNucleotide(nucleotideStored);
            // és evvel az értékkel felülírja a bentlévőt
            setNucleotide(nucleotideRemaining);

            int aminoAcidRemaining = v.addAminoAcid(aminoAcidStored);
            setAminoAcid(aminoAcidRemaining);

            collected = true;
        }
        Skeleton.printMethodCall(toString(), "collectBy(Virologist v)", false, collected.toString());
        return collected;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "Storage"
     */
    @Override
    public String toString() {
        return "Storage:" + id;
    }
}
