package projlab;

/**
 * A felejtővírus genetikai kódját reprezentáló ‘singleton’ osztály. Képes egy MemoryLossVirus példányt létrehozni és visszaadni (createAgent(): MemoryLossVirus). 
 * ‘Singleton’ minta szerint az osztály egyetlen példányát tárolja (only_instance), és visszaadja a getInstance(): MemoryLossVirusGene függvény segítségével.
 */
public class MemoryLossVirusGene extends GeneticCode {

    /**
     * A ‘Singleton’ minta szerint az osztály egyetlen példánya tárolva egy statikus privát változóban.
     */
    private static MemoryLossVirusGene onlyInstance = null; //az egyetlen példány

    private static final String MEMORY_LOSS_METHOD_NAME = "MemoryLossVirusGene()";

    private static final String GET_INSTANCE_METHOD_NAME = "getInstance()";

    private static final String CREATE_AGENT_METHOD_NAME = "createAgent()";

    private static final String CLASS_TYPE = "MemoryLossVirusGene";
    /*
     * Paraméter nélküli PRIVÁT konstruktor
     */
    private MemoryLossVirusGene() {
        Skeleton.printMethodCall(toString(), MEMORY_LOSS_METHOD_NAME, true, null);
        aminoAcidCost = 2;      //random számok, amik megadják, hogy mennyi aminosav és nukleotid kell
        nucleotideCost = 2;         // az előállításához
        Skeleton.printMethodCall(toString(), MEMORY_LOSS_METHOD_NAME, false, null);
    }

    /**
     * EA ‘Singleton’ minta szerint az osztály egyetlen példányát létrehozó statikus függvény, vagy amennyiben a példány még nem létezett, 
     * létrehozza azt (-MemoryLossVirusGene()), és meghívja a Controller addGeneticCode(gc: GeneticCodes) függvényét ‘gc’ paraméterként saját magát megadva.
     * @return az egyetlen MemoryLossVirusGene
     */
    public static MemoryLossVirusGene getInstance(){
        Skeleton.printMethodCall(CLASS_TYPE, GET_INSTANCE_METHOD_NAME, true, null);
        if (onlyInstance == null){
            onlyInstance = new MemoryLossVirusGene();
            Controller.addGeneticCode(onlyInstance);
        }
        Skeleton.printMethodCall(CLASS_TYPE, GET_INSTANCE_METHOD_NAME, false, onlyInstance.toString());
        return onlyInstance;
    }

    /**
     * Létrehoz egy MemoryLossVirus objektumot,  és visszaadja visszatérési értékként.
     * 
     * @return MemoryLossVirusGenehez tartozó MemoryLossVirus
     */
    public MemoryLossVirus createAgent() {
        Skeleton.printMethodCall(toString(), CREATE_AGENT_METHOD_NAME, true, null);
        MemoryLossVirus mlv = new MemoryLossVirus();
        Skeleton.printMethodCall(toString(), CREATE_AGENT_METHOD_NAME, false, mlv.toString());
        return mlv;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "MemoryLossVirusGene"
     */
    @Override
    public String toString() {
        return CLASS_TYPE + "(" + aminoAcidCost + ", " + nucleotideCost + ")";
    }
}
