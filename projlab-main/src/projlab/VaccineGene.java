package projlab;

/**
 * A vakcina genetikai kódját reprezentáló ‘singleton’ osztály. Képes egy Vaccine példányt létrehozni és visszaadni (createAgent(): Vaccine ). 
 * ‘Singleton’ minta szerint az osztály egyetlen példányát tárolja (only_instance), és visszaadja a getInstance(): VaccineGene függvény segítségével.
 */
public class VaccineGene extends GeneticCode {

    private static VaccineGene onlyInstance = null; // az egyetlen példány


    private static final String VaccineMethodName = "VaccineGene()";

    private static final String getInstanceMethodName = "getInstance()";

    private static final String createAgentMethodName = "createAgent()";

    private static final String classType = "VaccineGene";
    /**
     * Paraméter nélküli PRIVÁT konstruktor, inicializálja a GeneticCode-tól örökölt aminoAcidCost és nucleotideCost változókat.
     */
    public VaccineGene() {
        Skeleton.printMethodCall(toString(), VaccineMethodName, true, null);
        aminoAcidCost = 3;   //random számok, amik megadják, hogy mennyi aminosav és nukleotid kell
        nucleotideCost = 2;  // az előállításához
        Skeleton.printMethodCall(toString(), VaccineMethodName, false, null);
    }

    /**
     * A ‘Singleton’ minta szerint az osztály egyetlen példányát létrehozó statikus függvény, vagy amennyiben a példány még nem létezett, 
     * létrehozza azt (-VaccineGene()), és meghívja a Controller addGeneticCode(gc: GeneticCodes) függvényét ‘gc’ paraméterként saját magát megadva.
     * @return az egyetlen VaccineGene
     */
    public static VaccineGene getInstance(){ 
        Skeleton.printMethodCall(classType, getInstanceMethodName, true, null);
        if (onlyInstance == null){
            onlyInstance = new VaccineGene();
            Controller.addGeneticCode(onlyInstance);
        }
        Skeleton.printMethodCall(classType, getInstanceMethodName, false, onlyInstance.toString());
        return onlyInstance;
    }

    /**
     * Létrehozza a VaccineGenehez tartozó ágenst és visszaadja visszatérési értékként.
     * @return VaccineGenehez tartozó VaccineGene
     */
    public Vaccine createAgent() {
        Skeleton.printMethodCall(toString(), createAgentMethodName, true, null);
        Vaccine v = new Vaccine();
        Skeleton.printMethodCall(toString(), createAgentMethodName, false, v.toString());
        return v;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "VaccineGene"
     */
    @Override
    public String toString() {
        return classType + "(" + aminoAcidCost + ", " + nucleotideCost + ")";
    }
}
