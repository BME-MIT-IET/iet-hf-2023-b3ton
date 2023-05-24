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

    private static final String paralyzingVirusMethodName = "ParalyzingVirusGene()";

    private static final String getInstanceMethodName = "getInstance()";

    private static final String createAgentMethodName = "createAgent()";

    private static final String classType = "ParalyzingVirusGene";

    /*
     * Paraméter nélküli PRIVÁT konstruktor, inicializálja a GeneticCode-tól örökölt aminoAcidCost és nucleotideCost változókat
     */
    private ParalyzingVirusGene() {
        Skeleton.printMethodCall(toString(), paralyzingVirusMethodName, true, null);
        aminoAcidCost = 2;      //random számok, amik megadják, hogy mennyi aminosav és nukleotid kell
        nucleotideCost = 3;         // az előállításához
        Skeleton.printMethodCall(toString(), paralyzingVirusMethodName, false, null);
    }

    /**
     * A ‘Singleton’ minta szerint az osztály egyetlen példányát létrehozó statikus függvény, vagy amennyiben a példány még nem létezett, 
     * létrehozza azt (-ParalyzingVirusGene()), és meghívja a Controller addGeneticCode(gc: GeneticCodes) függvényét ‘gc’ paraméterként 
     * saját magát megadva.
     * @return az egyetlen ParalyzingVirusGene
     */
    public static ParalyzingVirusGene getInstance(){
        Skeleton.printMethodCall(classType, getInstanceMethodName, true, null);
        if (onlyInstance == null){
            onlyInstance = new ParalyzingVirusGene();
            Controller.addGeneticCode(onlyInstance);
        }
        Skeleton.printMethodCall(classType, getInstanceMethodName, false, onlyInstance.toString());
        return onlyInstance;
    }

    /**
     * Létrehoz egy ParalyzingVirus objektumot,  és visszaadja visszatérési értékként.
     * 
     * @return ParalyzingVirusGenehez tartozó ParalyzingVirus
     */
    public ParalyzingVirus createAgent() {
        Skeleton.printMethodCall(toString(), createAgentMethodName, true, null);
        ParalyzingVirus pv = new ParalyzingVirus();
        Skeleton.printMethodCall(toString(), createAgentMethodName, false, pv.toString());
        return pv;
    }
    
    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "ParalyzingVirusGene"
     */
    @Override
    public String toString() {
        return classType + "(" + aminoAcidCost + ", " + nucleotideCost + ")";
    }
}
