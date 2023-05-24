package projlab;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.Random;

public class Virologist {

    /**
     * A Virologist id-ja
     */
    protected final int id;

    /** 
     * Az alap maximum anyagmennyiség amit el tud tárolni anyagtípusonként. 
     * */
    private static int baseMaxMaterial = 10;

    /**
     * A Virologistnál található nukleotidok száma.
     */
    private int nucleotide = 0;

    /**
     * A Virologistnál található aminosavak száma.
     */
    private int aminoAcid = 0;

    /**
     * A Field, amin a Virologist éppen rajta van.
     */
    private Field currentField;

    /**
     *  Megadja, hogy a körben a Virologist már mozgott-e.
     */
    private boolean alreadyMoved = false;

    /**
     *  Megadja, hogy a körben a Virologist már elhasználta-e az akcióját.
     */
    private boolean alreadyUsedAction = false;

    /**
     *  A Virologistnál található ágensek.
     */
    private TreeMap<Integer, Agent> agents;

    /**
     *  A Virologistnál található GeneticCodeok.
     */
    private HashSet<GeneticCode> geneticCodes;

    /**
     * A Virologistra ható Effectek.
     */
    private ArrayList<Effect> effects;

    /**
     * A Virologistnál található Equipmentek.
     */
    private TreeMap<Integer, Equipment> equipments;

    /**
     * Visszaadja a Virologist-en lévő összes hatást,
     * beleértve az Effect-ek és az Equipment-ek hatását is.
     * 
     * @return
     */
    private ArrayList<Effect> getAllEffects() {
        ArrayList<Effect> all = new ArrayList<Effect>(effects);
        all.addAll(equipments.values());
        return all;
    }

    /**
     * Paraméter nélküli konstrukor.
     * Inicializálja a tömböket és beállítja
     * az aminosav és nukleotid értékeket nullára.
     */
    public Virologist() {
        id = Controller.getNewId();
        Skeleton.printMethodCall(toString(), "Virologist()", true, null);
        agents = new TreeMap<Integer, Agent>();
        geneticCodes = new HashSet<GeneticCode>();
        effects = new ArrayList<Effect>();
        equipments = new TreeMap<Integer, Equipment>();
        nucleotide = 0;
        aminoAcid = 0;
        Skeleton.printMethodCall(toString(), "Virologist()", false, null);
    }

    /**
     * visszaadja a Virologist id-ját
     * @return Virologist id-ja
     */
    public int getId() {
        return id;
    }

    /**
     * Visszaadja a Virologist aminosavainak számát
     * @return Virologist aminosavainak száma
     */
    public int getAminoAcid(){
        return aminoAcid;
    }

    /**
     *  Visszaadja a Virologist nukleitidjainak számát
     * @return Virologist nukleitidjainak száma
     */
    public int getNucleotide(){
        return nucleotide;
    }


    /**
     * Átlépteti a Virológust a paraméterként kapott <code>f</code> mezőre.
     * 
     * @param f A mező ahova a Virológus átlép
     */
    public void moveTo(Field f) {
        Skeleton.printMethodCall(toString(), "moveTo(Field f)", true, null);
        if (!alreadyMoved) {
            if (currentField != null) {
                currentField.stepOut(this);
            }
            currentField = f;
            f.stepIn(this);
            for (Effect e : getAllEffects()) {
                Agent a = e.spreads();
                if (a != null) {
                    f.spreadAgentBy(a, this);
                    break;
                }
            }
            alreadyMoved = true;
        }
        Skeleton.printMethodCall(toString(), "moveTo(Field f)", false, null);
    }

    /**
     * Interakcióbak lép a mezővel, amelyiken áll.
     * Ha a mező <code>Laboratory</code>,
     * akkor letapogatja az ott lévő <code>GeneticCode</code>-ot,
     * ha <code>Shelter</code>,
     * akkor felveszi az ott lévő <code>Equipment</code>-et,
     * ha <code>Storage</code>, akkor felveszi az ott lévő nyersanyagot.
     * Üres mezőn nem csinál semmit.
     */
    public void collectFromField() {
        Skeleton.printMethodCall(toString(), "collectFromField()", true, null);
        if (!alreadyUsedAction) {
            currentField.collectBy(this);
            alreadyUsedAction = true;
        }
        Skeleton.printMethodCall(toString(), "collectFromField()", false, null);
    }

    /**
     * A paraméterként kapott <code>GeneticCode</code>
     * alapján létrehozza a hozzá tartozó <code>Agent</code>-et.
     * 
     * 
     * @param gc A <code>GeneticCode</code> ami alapján
     *           létrehozza az <code>Agent</code>-et
     */
    public int createAgent(GeneticCode gc) {
        Skeleton.printMethodCall(toString(), "createAgent(GeneticCode gc)", true, null);
        int agentId = -1;
        if (!alreadyUsedAction) {
            int nucleotideCost = gc.getNucleotideCost();
            int aminoAcidCost = gc.getAminoAcidCost();

            if (nucleotideCost <= nucleotide && aminoAcidCost <= aminoAcid) {
                nucleotide -= nucleotideCost;
                aminoAcid -= aminoAcidCost;

                Agent a = gc.createAgent();
                agentId = a.getId();
                agents.put(agentId, a);
            }
            alreadyUsedAction = true;
        }
        Skeleton.printMethodCall(toString(), "createAgent(GeneticCode gc)", false, null);
        return agentId;
    }

    /**
     * Meghívja a a parméterként kapott <code>Agent</code>
     * <code>useOnBy</code> metódusát
     * a parméterként kapott <code>Virologist</code>-on.
     * 
     * @param v A Virológus akin végrehajták a metódust
     * @param a Az Ágens amin meghívódik a metódus
     */
    public void useAgentOn(Virologist v, Agent a) {
        Skeleton.printMethodCall(toString(), "useAgentOn(Virologist v, Agent a)", true, null);
        if (!alreadyUsedAction) {
            a.useOnBy(v, this);
            agents.remove(a.getId()); // a virológus a használat után elpusztítja az ágenst
            alreadyUsedAction = true;
        }
        Skeleton.printMethodCall(toString(), "useAgentOn(Virologist v, Agent a)", false, null);
    }

    /**
     * Megkísérel lopni a paraméterként kapott <code>Virologist</code>-tól.
     * 
     * @param v A <code>Virologist</code> akitől próbál lopni
     */
    public void stealFrom(Virologist v) {
        Skeleton.printMethodCall(toString(), "stealFrom(Virologist v)", true, null);
        if (!alreadyUsedAction) {
            v.getStolenBy(this);
            alreadyUsedAction = true;
        }
        Skeleton.printMethodCall(toString(), "stealFrom(Virologist v)", false, null);
    }

    /**
     * Ha ez a <code>Virologist</code> bénult, akkor a paraméterként kapott
     * <code>Virologist</code>-nak átadja az anyagkészletét,
     * valamint egy <code>Equipment</code>-et, ha van még nála.
     * 
     * @param v A <code>Virologist</code> aki próbál lopni
     */
    public void getStolenBy(Virologist v) {
        Skeleton.printMethodCall(toString(), "getStolenBy(Virologist v)", true, null);
        boolean paralyzed = false;
        for (Effect effect : getAllEffects()) {
            if (effect.paralyzed()) {
                paralyzed = true;
                break;
            }
        }
        if (paralyzed) {
            int aminoAcidLeft = v.addAminoAcid(aminoAcid);
            aminoAcid = aminoAcidLeft;
            int nucleotideLeft = v.addNucleotide(nucleotide);
            nucleotide = nucleotideLeft;
            try {
                Equipment lopnivalo = equipments.ceilingEntry(0).getValue();
                boolean ellopta = v.addEquipment(lopnivalo);
                if (ellopta) {
                    equipments.remove(lopnivalo.getId());
                }

            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        Skeleton.printMethodCall(toString(), "getStolenBy(Virologist v)", false, null);
    }

    /**
     * megöli a célpont Virologist-ot. Ha az egyik Equipment lethal() függvénye true-val tér vissza, akkor meghívja 
     * a kapott Virologist die() függvényét.
     * @param v megölendő Virologist
     */
    public void kill(Virologist v) {
        if (!alreadyUsedAction) {

            for (Equipment e : equipments.values()) {
                if (e.lethal()) {
                    v.die();
                    break;
                }
            } 
            alreadyUsedAction = true;
        }
    }

    /**
     *  a Virologist meghal, kilép a Field-jéről, és nem lép többet.
     */
    public void die() {
        Controller.removeVirologist(this);
        currentField.stepOut(this);
    }

    /**
     *  Virologist tombol, ha a éppen BearDanceEffect hatása alatt áll, és elpusztítja az összes Storage-ban lévő anyagot. 
     * Ha valamelyik Effect rampage() függvénye igazzal tér vissza, akkor meghívja currentField destroyObjects() függvényét.
     */
    public void rampage() {
        for (Effect e : getAllEffects()) {
            if (e.rampage()) {
                currentField.clearMaterial();
                break;
            }
        }
    }

    /**
     * Felveszi a <code>GeneticCode</code>-ot a listájába.
     * 
     * @param gc A felvevendő <code>GeneticCode</code>
     * @return Igazzal tér vissza, ha még nem szerepelt
     */
    public boolean addGeneticCode(GeneticCode gc) {
        Skeleton.printMethodCall(toString(), "addGeneticCode(GeneticCode gc)", true, null);
        boolean added = geneticCodes.add(gc);
        if (added) {
            Controller.virologistLearnedGeneticCode(this);
        }
        Skeleton.printMethodCall(toString(), "addGeneticCode(GeneticCode gc)", false,
                Boolean.toString(added));
        return added;
    }

    /**
     * A <code>Virologist</code> elfelejti (törli) az összes
     * <code>GeneticCode</code>-ot, amit ismert.
     */
    public void forgetGeneticCodes() {
        Skeleton.printMethodCall(toString(), "forgetGeneticCodes()", true, null);
        geneticCodes.clear();
        Skeleton.printMethodCall(toString(), "forgetGeneticCodes()", false, null);
    }

    public HashSet<GeneticCode> getGeneticCodes() {
        return geneticCodes;
    }

    /**
     * Egy <code>Effect</code> felrakása erre a <code>Virologist</code>-ra.
     * 
     * Ha ki tudja védeni, akkor nem kerül fel.
     * Ha nem tudta kivédeni, de vissza tudja dobni,
     * akkor meghívja ugyanezt a metódust
     * a paraméterként kapott <code>Virologist</code>-on.
     * 
     * @param e A hozzáadandó <code>Effect</code>
     * @param v A <code>Virologist</code> aki fel akarja rakni erre
     *          a <code>Virologist</code>-ra az <code>Effect</code>-et.
     *          Ha null, akkor mindenképp felkerül,
     *          ha saját maga, akkor a kesztyű nem védi ki.
     * @return Sikeres volt-e a felrakás
     */
    public boolean addEffectBy(Effect e, Virologist v) {
        Skeleton.printMethodCall(toString(), "addEffectBy(Effect e, Virologist v)", true, null);
        removeNotUsedEquipments();
        if (v == null) {
            effects.add(e);
            Skeleton.printMethodCall(toString(), "addEffectBy(Effect e, Virologist v)", false,
                    Boolean.toString(true));
            return true;
        }
        boolean resist = false;
        boolean reflect = false;
        ArrayList<Effect> allEffects = getAllEffects();

        for (Effect effect : allEffects) {
            if (effect.resist()) {
                resist = true;
                break;
            }
        }

        if (!resist && this != v) {
            for (Effect effect : allEffects) {
                if (effect.reflect()) {
                    reflect = true;
                    v.addEffectBy(e, this);
                    break;
                }
            }
        }

        // Ha nem védte ki semmi ÉS nem dobtuk vissza,
        // akkor eltároljuk.
        boolean effectApplies = !resist && !reflect;

        if (effectApplies) {
            effects.add(e);
        }
        Skeleton.printMethodCall(toString(), "addEffectBy(Effect e, Virologist v)", false,
                Boolean.toString(effectApplies));
        return effectApplies;
    }

    /**
     * Felveszi a parméterként kapott <code>Equipment</code>-et,
     * ha még van elég hely.
     * 
     * @param e Az <code>Equipment</code> amit felvesz
     * @return Sikeres volt-e a felvétel
     */
    public boolean addEquipment(Equipment e) {
        Skeleton.printMethodCall(toString(), "addEquipment(Equipment e)", true, null);
        boolean hasEnoughSpace = equipments.size() < 3;
        if (hasEnoughSpace && e != null) {
            equipments.put(e.getId(), e);
        }

        Skeleton.printMethodCall(toString(), "addEquipment(Equipment e)", false,
                Boolean.toString(hasEnoughSpace));
        return hasEnoughSpace;
    }


    /**
     * Felveszi a parméterként kapott <code>Agent</code>-et.
     * 
     * @param e Az <code>Agent</code> amit felvesz
     */
    public void addAgent(Agent a) {
        Skeleton.printMethodCall(toString(), "addAgent(Agent a)", true, null);
        agents.put(a.getId(), a);

        Skeleton.printMethodCall(toString(), "addAgent(Agent a)", false, null);
    }

    /**
     * Törli a parméterként kapott <code>Equipment</code>-et.
     * 
     * @param e Az <code>Equipment</code> amit töröl
     */
    public void dropEquipment(Equipment e) {
        Skeleton.printMethodCall(toString(), "dropEquipment(Equipment e)", true, null);
        if (!alreadyUsedAction) {
            equipments.remove(e.getId());
            alreadyUsedAction = true;
        }
        Skeleton.printMethodCall(toString(), "dropEquipment(Equipment e)", false, null);
    }

    /**
     * Megnöveli a <code>Virologist</code> aminosav készletét a
     * paméterként kapott mennyiséggel.
     * 
     * Ha többet kapott paraméterként, mint amennyit el tud tárolni,
     * akkor eltárol amennyit tud és visszaadja azt a mennyiséget
     * amit már nem tud eltárolni.
     * 
     * @param amount A mennyiség amit kap
     * @return amennyit már nem tud eltárolni
     */
    public int addAminoAcid(int amount) {
        Skeleton.printMethodCall(toString(), "addAminoAcid(int amount)", true, null);
        int maxMaterial = baseMaxMaterial;
        for (Effect effect : getAllEffects()) {
            maxMaterial *= effect.moreMaterial();
        }
        int difference = (amount + aminoAcid) - maxMaterial;
        int retval;
        if (difference > 0) {
            aminoAcid = maxMaterial;
            retval = difference;
        } else {
            aminoAcid += amount;
            retval = 0;
        }
        Skeleton.printMethodCall(toString(), "addAminoAcid(int amount)", false,
                Integer.toString(retval));
        return retval;
    }

    /**
     * Megnöveli a <code>Virologist</code> nukleotid készletét a
     * paméterként kapott mennyiséggel.
     * 
     * Ha többet kapott paraméterként, mint amennyit el tud tárolni,
     * akkor eltárol amennyit tud és visszaadja azt a mennyiséget
     * amit már nem tud eltárolni.
     * 
     * @param amount A mennyiség amit kap
     * @return amennyit már nem tud eltárolni
     */

    public int addNucleotide(int amount) {
        Skeleton.printMethodCall(toString(), "addNucleotide(int amount)", true, null);
        int maxMaterial = baseMaxMaterial;
        for (Effect effect : getAllEffects()) {
            maxMaterial *= effect.moreMaterial();
        }
        int difference = (amount + nucleotide) - maxMaterial;
        int retval;
        if (difference > 0) {
            nucleotide = maxMaterial;
            retval = difference;
        } else {
            nucleotide += amount;
            retval = 0;
        }
        Skeleton.printMethodCall(toString(), "addNucleotide(int amount)", false,
                Integer.toString(retval));
        return retval;
    }

    /**
     * Ezt a függvényt hívja meg a <code>Controller</code>,
     * amikor ennek a Virológusnak jön a lépési köre.
     */
    public void startTurn() {
        Skeleton.printMethodCall(toString(), "startTurn()", true, null);

        effectsTimePasses();
        agentsTimePasses();
        removeNotUsedEquipments();

        alreadyMoved = false;
        alreadyUsedAction = false;

        // Ha a Virologist le van bénulva, akkor nem tud lépni,
        // a következő Virologist jön
        for (Effect effect : getAllEffects()) {
            if (effect.paralyzed()) {
                alreadyMoved = true;
                alreadyUsedAction = true;
                Skeleton.printMethodCall(toString(), "startTurn()", false, null);
                return;
            }
        }

        // Kör elején kifejti a hasChorea hatását, ha van
        if (!Controller.getDeterminism()) {
            boolean hasChorea = false;
            for (Effect effect : getAllEffects()) {
                if (effect.hasChorea()) {
                    hasChorea = true;
                    break;
                }
            }

            if (hasChorea) {
                Object[] neighbourFields = currentField.getNeighbors().toArray();
                Field nextField = (Field) neighbourFields[new Random()
                        .nextInt(neighbourFields.length)];
                moveTo(nextField);
                alreadyMoved = true;
            }
        }
        Skeleton.printMethodCall(toString(), "startTurn()", false, null);
    }

    /**
     * Visszaadja a Fieldet, ahol a Virologist áll.
     * @return
     */
    public Field getCurrentField() {
        return currentField;
    }

    /**
     * Visszaadja a virológus meglévő ágenseit
     * @return a virológus ágensei
     */
    public TreeMap<Integer, Agent> getAgents(){
        return agents;
    }

    /**
     * Visszaadja a virológus meglévő felszereléseit
     * @return a virológus felszerelései
     */
    public TreeMap<Integer, Equipment> getEquipments(){
        return equipments;
    }

    /**
     * Visszaadja a virológus érvényes effectjeit
     * @return a virológuson ható effectek
     */
    public ArrayList<Effect> getEffects(){
        return effects;
    }

    /**
     * Ez a függvény hívódik meg akkor, amikor a TimedEffect-ek hatóidejét
     * csökkenteni kell.
     * Mindegyik TimedEffect hatódeje eggyel csökken, és aminek lejárt, azt kiveszi.
     */
    private void effectsTimePasses() {
        ArrayList<Effect> removable = new ArrayList<>();
        for (Effect e : effects) {
            if (e.timePasses()) {
                removable.add(e);
            }
        }
        effects.removeAll(removable);
    }

    /**
     * Ez a függvény hívódik meg akkor,
     * amikor a Agent-ek hatóidejét csökkenteni kell.
     * Mindegyik Agent hatódeje eggyel csökken, és aminek lejárt, azt kiveszi.
     */
    private void agentsTimePasses() {
        for (Agent a : agents.values()) {
            if (a.timePasses()) {
                agents.remove(a.getId());
            }
        }
    }
    /**
     * Ez a függvény hívódik meg akkor, ha az elhasznált Equipment-eket ki kell törölnie a Virologist-nek az Equipment-jei közül.
     * Végigmegy az összes Equipment-en, és ha a stillUsable() függvény 'false'-al tér vissza, akkor törli az Equipment-et.
     */
    private void removeNotUsedEquipments() {
        for (Equipment e : equipments.values()) {
            if (!e.stillUsable()) {
                equipments.remove(e.getId());
            }
        } 
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "Virologist"
     */
    @Override
    public String toString() {
        return "Virologist:" + id;
    }
}
