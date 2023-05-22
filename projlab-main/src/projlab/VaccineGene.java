package projlab;

/**
 * A vakcina genetikai kódját reprezentáló ‘singleton’ osztály. Képes egy Vaccine példányt létrehozni és visszaadni (createAgent(): Vaccine ). 
 * ‘Singleton’ minta szerint az osztály egyetlen példányát tárolja (only_instance), és visszaadja a getInstance(): VaccineGene függvény segítségével.
 */
public class VaccineGene extends GeneticCode {

    private static VaccineGene only_instance = null; // az egyetlen példány

    /**
     * Paraméter nélküli PRIVÁT konstruktor, inicializálja a GeneticCode-tól örökölt aminoAcidCost és nucleotideCost változókat.
     */
    public VaccineGene() {
        Skeleton.printMethodCall(toString(), "VaccineGene()", true, null);
        aminoAcidCost = 3;   //random számok, amik megadják, hogy mennyi aminosav és nukleotid kell
        nucleotideCost = 2;  // az előállításához
        Skeleton.printMethodCall(toString(), "VaccineGene()", false, null);
    }

    /**
     * A ‘Singleton’ minta szerint az osztály egyetlen példányát létrehozó statikus függvény, vagy amennyiben a példány még nem létezett, 
     * létrehozza azt (-VaccineGene()), és meghívja a Controller addGeneticCode(gc: GeneticCodes) függvényét ‘gc’ paraméterként saját magát megadva.
     * @return az egyetlen VaccineGene
     */
    public static VaccineGene getInstance(){ 
        Skeleton.printMethodCall("VaccineGene", "getInstance()", true, null);
        if (only_instance == null){
            only_instance = new VaccineGene();
            Controller.addGeneticCode(only_instance);
        }
        Skeleton.printMethodCall("VaccineGene", "getInstance()", false, only_instance.toString());
        return only_instance;
    }

    /**
     * Létrehozza a VaccineGenehez tartozó ágenst és visszaadja visszatérési értékként.
     * @return VaccineGenehez tartozó VaccineGene
     */
    public Vaccine createAgent() {
        Skeleton.printMethodCall(toString(), "createAgent()", true, null);
        Vaccine v = new Vaccine();
        Skeleton.printMethodCall(toString(), "createAgent()", false, v.toString());
        return v;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "VaccineGene"
     */
    @Override
    public String toString() {
        return "VaccineGene" + "(" + aminoAcidCost + ", " + nucleotideCost + ")";
    }
}
