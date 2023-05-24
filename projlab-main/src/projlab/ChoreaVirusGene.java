package projlab;

/**
 * Egyfajta GeneticCode.
 * A vítustánc vírus genetikai kódját reprezentáló ‘singleton’ osztály. Képes egy ChoreaVirus 
 * példányt létrehozni és visszaadni (createAgent(): ChoreaVirus). ‘Singleton’ minta szerint az osztály egyetlen 
 * példányát tárolja (only_instance), és visszaadja a getInstance(): ChoreaVirusGene függvény segítségével.
 */
public class ChoreaVirusGene extends GeneticCode {

    private static ChoreaVirusGene onlyInstance = null; // az egyetlen példány

    private final static String choreaMethodName = "ChoreaVirusGene()";
    private static final String choreaClassType = "ChoreaVirusGene";
    private static final String createAgentMethod = "createAgent()";
    private static final String getInstanceMethodName = "getInstance()";
    /**
     * Paraméter nélküli PRIVÁT konstruktor
     */
    private ChoreaVirusGene() {
        Skeleton.printMethodCall(toString(), choreaMethodName, true, null);
        aminoAcidCost = 4;  //random számok, amik megadják, hogy mennyi aminosav és nukleotid kell
        nucleotideCost = 1; // az előállításához
        Skeleton.printMethodCall(toString(), choreaMethodName, false, null);
    }
    
    /**
     * Ezzel a függvénnyel lehet lekérni az egyetlen példányt, megakadályozza, hogy
     * több keletkezhessen
     * @return az egyetlen ChoreaVirusGene
     */
    public static ChoreaVirusGene getInstance(){
        Skeleton.printMethodCall(choreaClassType, getInstanceMethodName, true, null);
        if (onlyInstance == null){
            onlyInstance = new ChoreaVirusGene();
            Controller.addGeneticCode(onlyInstance);
        }
        Skeleton.printMethodCall(choreaClassType, getInstanceMethodName, false, onlyInstance.toString());
        return onlyInstance;
    }

    /**
     * Létrehozza a ChoreaVirusGenehez tartozó ágenst
     * 
     * @return ChoreaVirusGenehez tartozó ChoreaVirus
     */
    public ChoreaVirus createAgent() {
        Skeleton.printMethodCall(toString(), createAgentMethod, true, null);
        ChoreaVirus cv = new ChoreaVirus();
        Skeleton.printMethodCall(toString(), createAgentMethod, false, cv.toString());
        return cv;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "ChoreaVirusGene"
     */
    @Override
    public String toString() {
        return choreaClassType + "(" + aminoAcidCost + ", " + nucleotideCost + ")";
    }
}
