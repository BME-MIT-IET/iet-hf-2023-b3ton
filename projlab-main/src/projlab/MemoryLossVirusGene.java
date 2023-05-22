package projlab;

/**
 * A felejtővírus genetikai kódját reprezentáló ‘singleton’ osztály. Képes egy MemoryLossVirus példányt létrehozni és visszaadni (createAgent(): MemoryLossVirus). 
 * ‘Singleton’ minta szerint az osztály egyetlen példányát tárolja (only_instance), és visszaadja a getInstance(): MemoryLossVirusGene függvény segítségével.
 */
public class MemoryLossVirusGene extends GeneticCode {

    /**
     * A ‘Singleton’ minta szerint az osztály egyetlen példánya tárolva egy statikus privát változóban.
     */
    private static MemoryLossVirusGene only_instance = null; //az egyetlen példány

    /*
     * Paraméter nélküli PRIVÁT konstruktor
     */
    private MemoryLossVirusGene() {
        Skeleton.printMethodCall(toString(), "MemoryLossVirusGene()", true, null);
        aminoAcidCost = 2;      //random számok, amik megadják, hogy mennyi aminosav és nukleotid kell
        nucleotideCost = 2;         // az előállításához
        Skeleton.printMethodCall(toString(), "MemoryLossVirusGene()", false, null);
    }

    /**
     * EA ‘Singleton’ minta szerint az osztály egyetlen példányát létrehozó statikus függvény, vagy amennyiben a példány még nem létezett, 
     * létrehozza azt (-MemoryLossVirusGene()), és meghívja a Controller addGeneticCode(gc: GeneticCodes) függvényét ‘gc’ paraméterként saját magát megadva.
     * @return az egyetlen MemoryLossVirusGene
     */
    public static MemoryLossVirusGene getInstance(){
        Skeleton.printMethodCall("MemoryLossVirusGene", "getInstance()", true, null);
        if (only_instance == null){
            only_instance = new MemoryLossVirusGene();
            Controller.addGeneticCode(only_instance);
        }
        Skeleton.printMethodCall("MemoryLossVirusGene", "getInstance()", false, only_instance.toString());
        return only_instance;
    }

    /**
     * Létrehoz egy MemoryLossVirus objektumot,  és visszaadja visszatérési értékként.
     * 
     * @return MemoryLossVirusGenehez tartozó MemoryLossVirus
     */
    public MemoryLossVirus createAgent() {
        Skeleton.printMethodCall(toString(), "createAgent()", true, null);
        MemoryLossVirus mlv = new MemoryLossVirus();
        Skeleton.printMethodCall(toString(), "createAgent()", false, mlv.toString());
        return mlv;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "MemoryLossVirusGene"
     */
    @Override
    public String toString() {
        return "MemoryLossVirusGene" + "(" + aminoAcidCost + ", " + nucleotideCost + ")";
    }
}
