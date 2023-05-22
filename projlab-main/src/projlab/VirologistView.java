package projlab;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * A Virologist megjelenítéséért felelős osztály.
 */
public class VirologistView implements View {
    /**
     * A Virologist, amit a draw() függvénnyel ki fog rajzolni.
     */
    private Virologist virologist;
    /**
     * Singleton objektum, ha már létezik, akkor visszaadunk rá egy referenciát.
     */
    private static VirologistView instance = null;

    /**
     * Lekérdezi a virologist értékeit és beállítja azokat a Canvas-on.
     */
    @Override
    public void draw() {
        int amino = virologist.getAminoAcid();
        int nucleotide = virologist.getNucleotide();
        HashSet<GeneticCode> geneticCodes = virologist.getGeneticCodes();
        TreeMap<Integer, Agent> agents = virologist.getAgents();
        TreeMap<Integer, Equipment>  equipments = virologist.getEquipments();
        ArrayList<Effect> effects = virologist.getEffects();
        Canvas canvas = Canvas.getInstance();

        canvas.clearAgents();
        canvas.clearEquipment();
        canvas.clearEffects();

        canvas.setAminoAcid(amino);
        canvas.setNucleotide(nucleotide);

        HashSet<GeneticCode> allGeneticCodes = Controller.getGeneticCodes();
        for (GeneticCode gc : allGeneticCodes) {
            if (geneticCodes.contains(gc)) {
                canvas.setGeneticCodeCollected(gc, true);
            } else {
                canvas.setGeneticCodeCollected(gc, false);
            }
        }

        for (Agent a : agents.values()) {
            canvas.addAgent(a);
        }

        for (Equipment e : equipments.values()) {
            canvas.addEquipment(e);
        }

        for (Effect e : effects) {
            canvas.addEffect(e);
        }

        canvas.setCurrentVirologist(virologist.getId());
    }

    /**
     * Visszaadja a játékban szereplő Virologist objektumot (mivel singleton osztály).
     * @return VirologistView
     */
    public static VirologistView getInstance() {
        if (instance == null) {
            instance = new VirologistView();
        }

        return instance;
    }
    
    /**
     * Beállítja azt a Virologist-et, amit a draw() metódussal ki fog rajzolni.
     * @param v - beállítandó Virologist
     */
    public void setVirologist(Virologist v) {
        virologist = v;
    }
}
