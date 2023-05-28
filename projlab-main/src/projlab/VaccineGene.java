package projlab;

/**
 * A vakcina genetikai kódját reprezentáló ‘singleton’ osztály. Képes egy Vaccine példányt létrehozni és visszaadni (createAgent(): Vaccine ). 
 * ‘Singleton’ minta szerint az osztály egyetlen példányát tárolja (only_instance), és visszaadja a getInstance(): VaccineGene függvény segítségével.
 */
public class VaccineGene extends GeneticCode {

    private static VaccineGene onlyInstance = null; // az egyetlen példány


    private static final String VACCINE_METHOD_NAME = "VaccineGene()";

    private static final String GET_INSTANCE_METHOD_NAME = "getInstance()";

    private static final String CREATE_AGENT_METHOD_NAME = "createAgent()";

    private static final String CLASS_TYPE = "VaccineGene";
    /**
     * Paraméter nélküli PRIVÁT konstruktor, inicializálja a GeneticCode-tól örökölt aminoAcidCost és nucleotideCost változókat.
     */
    public VaccineGene() {
        Skeleton.printMethodCall(toString(), VACCINE_METHOD_NAME, true, null);
        aminoAcidCost = 3;   //random számok, amik megadják, hogy mennyi aminosav és nukleotid kell
        nucleotideCost = 2;  // az előállításához
        Skeleton.printMethodCall(toString(), VACCINE_METHOD_NAME, false, null);
    }

    /**
     * A ‘Singleton’ minta szerint az osztály egyetlen példányát létrehozó statikus függvény, vagy amennyiben a példány még nem létezett, 
     * létrehozza azt (-VaccineGene()), és meghívja a Controller addGeneticCode(gc: GeneticCodes) függvényét ‘gc’ paraméterként saját magát megadva.
     * @return az egyetlen VaccineGene
     */
    public static VaccineGene getInstance(){ 
        Skeleton.printMethodCall(CLASS_TYPE, GET_INSTANCE_METHOD_NAME, true, null);
        if (onlyInstance == null){
            onlyInstance = new VaccineGene();
            Controller.addGeneticCode(onlyInstance);
        }
        Skeleton.printMethodCall(CLASS_TYPE, GET_INSTANCE_METHOD_NAME, false, onlyInstance.toString());
        return onlyInstance;
    }

    /**
     * Létrehozza a VaccineGenehez tartozó ágenst és visszaadja visszatérési értékként.
     * @return VaccineGenehez tartozó VaccineGene
     */
    public Vaccine createAgent() {
        Skeleton.printMethodCall(toString(), CREATE_AGENT_METHOD_NAME, true, null);
        Vaccine v = new Vaccine();
        Skeleton.printMethodCall(toString(), CREATE_AGENT_METHOD_NAME, false, v.toString());
        return v;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "VaccineGene"
     */
    @Override
    public String toString() {
        return CLASS_TYPE + "(" + aminoAcidCost + ", " + nucleotideCost + ")";
    }
}
