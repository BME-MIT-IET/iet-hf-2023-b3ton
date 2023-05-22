package projlab;

/**
 * Egyfajta GeneticCode.
 * A vítustánc vírus genetikai kódját reprezentáló ‘singleton’ osztály. Képes egy ChoreaVirus 
 * példányt létrehozni és visszaadni (createAgent(): ChoreaVirus). ‘Singleton’ minta szerint az osztály egyetlen 
 * példányát tárolja (only_instance), és visszaadja a getInstance(): ChoreaVirusGene függvény segítségével.
 */
public class ChoreaVirusGene extends GeneticCode {

    private static ChoreaVirusGene only_instance = null; // az egyetlen példány

    /**
     * Paraméter nélküli PRIVÁT konstruktor
     */
    private ChoreaVirusGene() {
        Skeleton.printMethodCall(toString(), "ChoreaVirusGene()", true, null);
        aminoAcidCost = 4;  //random számok, amik megadják, hogy mennyi aminosav és nukleotid kell
        nucleotideCost = 1; // az előállításához
        Skeleton.printMethodCall(toString(), "ChoreaVirusGene()", false, null);
    }
    
    /**
     * Ezzel a függvénnyel lehet lekérni az egyetlen példányt, megakadályozza, hogy
     * több keletkezhessen
     * @return az egyetlen ChoreaVirusGene
     */
    public static ChoreaVirusGene getInstance(){
        Skeleton.printMethodCall("ChoreaVirusGene", "getInstance()", true, null);
        if (only_instance == null){
            only_instance = new ChoreaVirusGene();
            Controller.addGeneticCode(only_instance);
        }
        Skeleton.printMethodCall("ChoreaVirusGene", "getInstance()", false, only_instance.toString());
        return only_instance;
    }

    /**
     * Létrehozza a ChoreaVirusGenehez tartozó ágenst
     * 
     * @return ChoreaVirusGenehez tartozó ChoreaVirus
     */
    public ChoreaVirus createAgent() {
        Skeleton.printMethodCall(toString(), "createAgent()", true, null);
        ChoreaVirus cv = new ChoreaVirus();
        Skeleton.printMethodCall(toString(), "createAgent()", false, cv.toString());
        return cv;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "ChoreaVirusGene"
     */
    @Override
    public String toString() {
        return "ChoreaVirusGene" + "(" + aminoAcidCost + ", " + nucleotideCost + ")";
    }
}
