package projlab;

/**
 * Egyfajta GeneticCode.
 * A vítustánc vírus genetikai kódját reprezentáló ‘singleton’ osztály. Képes egy ChoreaVirus 
 * példányt létrehozni és visszaadni (createAgent(): ChoreaVirus). ‘Singleton’ minta szerint az osztály egyetlen 
 * példányát tárolja (only_instance), és visszaadja a getInstance(): ChoreaVirusGene függvény segítségével.
 */
public class ChoreaVirusGene extends GeneticCode {

    private static ChoreaVirusGene onlyInstance = null; // az egyetlen példány

    private static final String CHOREA_VIRUS_GENE = "ChoreaVirusGene()";
    private static final String CHOREA_CLASS_TYPE = "ChoreaVirusGene";
    private static final String CREATE_AGENT_METHOD = "createAgent()";
    private static final String GET_INSTANCE_METHOD_NAME = "getInstance()";
    /**
     * Paraméter nélküli PRIVÁT konstruktor
     */
    private ChoreaVirusGene() {
        Skeleton.printMethodCall(toString(), CHOREA_VIRUS_GENE, true, null);
        aminoAcidCost = 4;  //random számok, amik megadják, hogy mennyi aminosav és nukleotid kell
        nucleotideCost = 1; // az előállításához
        Skeleton.printMethodCall(toString(), CHOREA_VIRUS_GENE, false, null);
    }
    
    /**
     * Ezzel a függvénnyel lehet lekérni az egyetlen példányt, megakadályozza, hogy
     * több keletkezhessen
     * @return az egyetlen ChoreaVirusGene
     */
    public static ChoreaVirusGene getInstance(){
        Skeleton.printMethodCall(CHOREA_CLASS_TYPE, GET_INSTANCE_METHOD_NAME, true, null);
        if (onlyInstance == null){
            onlyInstance = new ChoreaVirusGene();
            Controller.addGeneticCode(onlyInstance);
        }
        Skeleton.printMethodCall(CHOREA_CLASS_TYPE, GET_INSTANCE_METHOD_NAME, false, onlyInstance.toString());
        return onlyInstance;
    }

    /**
     * Létrehozza a ChoreaVirusGenehez tartozó ágenst
     * 
     * @return ChoreaVirusGenehez tartozó ChoreaVirus
     */
    public ChoreaVirus createAgent() {
        Skeleton.printMethodCall(toString(), CREATE_AGENT_METHOD, true, null);
        ChoreaVirus cv = new ChoreaVirus();
        Skeleton.printMethodCall(toString(), CREATE_AGENT_METHOD, false, cv.toString());
        return cv;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "ChoreaVirusGene"
     */
    @Override
    public String toString() {
        return CHOREA_CLASS_TYPE + "(" + aminoAcidCost + ", " + nucleotideCost + ")";
    }
}
