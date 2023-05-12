package projlab;

/**
 * Az ágensek genetikai kódját reprezentáló absztrakt osztály. Létre tud hozni egy típusnak megfelelő Agent-et, 
 * és visszaadni (createAgent(): Agent). Tárolja a megfelelő Agent létrehozásának aminosav és nukloetid árát 
 * (aminoAcidCost, nucleotideCost), és ezeket vissza is tudja adni (getNucleotideCost(): int, getAminoAcidCost(): int).
 */
public abstract class GeneticCode {
    protected int aminoAcidCost; // nem írható
    protected int nucleotideCost; // nem írható

    /**
     * Visszaadja mennyi nucleotide kell az adott genetic code létrehozásához
     * 
     * @return a genetic code létrehozásához szükséges nucleotidok száma
     */
    public int getNucleotideCost() {
        Skeleton.printMethodCall(toString(), "getNucleotideCost()", true, null);
        Skeleton.printMethodCall(toString(), "getNucleotideCost()", false, Integer.toString(nucleotideCost));
        return nucleotideCost;
    }

    /**
     * Visszaadja mennyi aminoacid kell az adott genetic code létrehozásához
     * 
     * @return a genetic code létrehozásához szükséges aminoacidok száma
     */
    public int getAminoAcidCost() {
        Skeleton.printMethodCall(toString(), "getAminoAcidCost()", true, null);
        Skeleton.printMethodCall(toString(), "getAminoAcidCost()", false, Integer.toString(aminoAcidCost));
        return aminoAcidCost;
    }

    /**
     * Absztrakt függvény, létrehozza az adott geneticcodehoz
     * tartozó agentet
     * 
     * @return geneticcodehoz tartozó agent
     */
    public abstract Agent createAgent();

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "GeneticCode"
     */
    @Override
    public String toString() {
        return "GeneticCode";
    }
}
