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
    private static ParalyzingVirusGene only_instance = null; // az egyetlen példány

    /*
     * Paraméter nélküli PRIVÁT konstruktor, inicializálja a GeneticCode-tól örökölt aminoAcidCost és nucleotideCost változókat
     */
    private ParalyzingVirusGene() {
        Skeleton.printMethodCall(toString(), "ParalyzingVirusGene() ", true, null);
        aminoAcidCost = 2;      //random számok, amik megadják, hogy mennyi aminosav és nukleotid kell
        nucleotideCost = 3;         // az előállításához
        Skeleton.printMethodCall(toString(), "ParalyzingVirusGene() ", false, null);
    }

    /**
     * A ‘Singleton’ minta szerint az osztály egyetlen példányát létrehozó statikus függvény, vagy amennyiben a példány még nem létezett, 
     * létrehozza azt (-ParalyzingVirusGene()), és meghívja a Controller addGeneticCode(gc: GeneticCodes) függvényét ‘gc’ paraméterként 
     * saját magát megadva.
     * @return az egyetlen ParalyzingVirusGene
     */
    public static ParalyzingVirusGene getInstance(){
        Skeleton.printMethodCall("ParalyzingVirusGene", "getInstance()", true, null);
        if (only_instance == null){
            only_instance = new ParalyzingVirusGene();
            Controller.addGeneticCode(only_instance);
        }
        Skeleton.printMethodCall("ParalyzingVirusGene", "getInstance()", false, only_instance.toString());
        return only_instance;
    }

    /**
     * Létrehoz egy ParalyzingVirus objektumot,  és visszaadja visszatérési értékként.
     * 
     * @return ParalyzingVirusGenehez tartozó ParalyzingVirus
     */
    public ParalyzingVirus createAgent() {
        Skeleton.printMethodCall(toString(), "createAgent()", true, null);
        ParalyzingVirus pv = new ParalyzingVirus();
        Skeleton.printMethodCall(toString(), "createAgent()", false, pv.toString());
        return pv;
    }
    
    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "ParalyzingVirusGene"
     */
    @Override
    public String toString() {
        return "ParalyzingVirusGene" + "(" + aminoAcidCost + ", " + nucleotideCost + ")";
    }
}
