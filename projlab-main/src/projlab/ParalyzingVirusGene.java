package projlab;

/**
 * A bénítógenetikai kódját reprezentáló ‘singleton’ osztály. Képes egy ParalyzingVirus példányt létrehozni és visszaadni 
 * (createAgent(): ParalyzingVirus ). ‘Singleton’ minta szerint az osztály egyetlen példányát tárolja (only_instance), és 
 * visszaadja a getInstance(): ParalyzingVirusGene függvény segítségével.
 */
public class ParalyzingVirusGene extends GeneticCode {
    /**
     * A ‘Singleton’ minta szerint az osztály egyetlen példánya tárolva egy statikus privát változóban.
     */
    private static ParalyzingVirusGene onlyInstance = null; // az egyetlen példány

    private static final String PARALYZING_VIRUS_METHOD_NAME = "ParalyzingVirusGene()";

    private static final String GET_INSTANCE_METHOD_NAME = "getInstance()";

    private static final String CREATE_AGENT_METHOD_NAME = "createAgent()";

    private static final String CLASS_TYPE = "ParalyzingVirusGene";

    /*
     * Paraméter nélküli PRIVÁT konstruktor, inicializálja a GeneticCode-tól örökölt aminoAcidCost és nucleotideCost változókat
     */
    private ParalyzingVirusGene() {
        Skeleton.printMethodCall(toString(), PARALYZING_VIRUS_METHOD_NAME, true, null);
        aminoAcidCost = 2;      //random számok, amik megadják, hogy mennyi aminosav és nukleotid kell
        nucleotideCost = 3;         // az előállításához
        Skeleton.printMethodCall(toString(), PARALYZING_VIRUS_METHOD_NAME, false, null);
    }

    /**
     * A ‘Singleton’ minta szerint az osztály egyetlen példányát létrehozó statikus függvény, vagy amennyiben a példány még nem létezett, 
     * létrehozza azt (-ParalyzingVirusGene()), és meghívja a Controller addGeneticCode(gc: GeneticCodes) függvényét ‘gc’ paraméterként 
     * saját magát megadva.
     * @return az egyetlen ParalyzingVirusGene
     */
    public static ParalyzingVirusGene getInstance(){
        Skeleton.printMethodCall(CLASS_TYPE, GET_INSTANCE_METHOD_NAME, true, null);
        if (onlyInstance == null){
            onlyInstance = new ParalyzingVirusGene();
            Controller.addGeneticCode(onlyInstance);
        }
        Skeleton.printMethodCall(CLASS_TYPE, GET_INSTANCE_METHOD_NAME, false, onlyInstance.toString());
        return onlyInstance;
    }

    /**
     * Létrehoz egy ParalyzingVirus objektumot,  és visszaadja visszatérési értékként.
     * 
     * @return ParalyzingVirusGenehez tartozó ParalyzingVirus
     */
    public ParalyzingVirus createAgent() {
        Skeleton.printMethodCall(toString(), CREATE_AGENT_METHOD_NAME, true, null);
        ParalyzingVirus pv = new ParalyzingVirus();
        Skeleton.printMethodCall(toString(), CREATE_AGENT_METHOD_NAME, false, pv.toString());
        return pv;
    }
    
    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "ParalyzingVirusGene"
     */
    @Override
    public String toString() {
        return CLASS_TYPE + "(" + aminoAcidCost + ", " + nucleotideCost + ")";
    }
}
