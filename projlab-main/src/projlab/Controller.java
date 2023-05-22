package projlab;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * A játékot irányító osztály statikus függvényekkel. Képes elindítani a játékot, lehet rajta a determinisztikusságot állítani. 
 * Tárolja a játékban lévő Field-eket és Virologist-okat. Lehet hozzáadni, elvenni a tárolt Field-ekből és Virologist-okból. Számon 
 * tartja, hogy ki az éppen soron következő Virologist, és tudja neki jelezni, hogy kezdheti a körét. El lehet rajta indítani a játékot, 
 * ami addig fut, amíg valamelyik Virologist nem nyeri meg a játékot.
 */
public class Controller {

    /**
     * jelzi, ahogy a Controller determinisztikus módban van-e. Ha igen, akkor a véletlenszerű események 
     * (pl. TimedChoreaVirusEffect miatti véletlenszerű mozgás) előre meghatározott módon történnek.
     */
    private static boolean isDeterministic = false;

    /**
     * Hány példány van id-ket használó osztályokból.
     */
    private static int count = 0;

    /**
     * A játék állapotát jelzi, hogy éppen lépni, akciót végrehajtani, vagy a kört befejezni lehet.
     */
    private static GameState gs = GameState.WAITING_FOR_MOVE;

    /**
     * Új id kérése.
     */
    public static int getNewId()
    {
        return count++;
    }

    /**
     * Setter, beállítja az isDeterministic változót a kapott értékre
     * @param value  a Controller determinisztikus módban van-e
     */
    public static void setDeterminism(boolean value) {
        isDeterministic = value;
    }

    /**
     * Getter, visszaadja az isDeterministic változó értékét
     * @return  a Controller determinisztikus módban van-e
     */
    public static boolean getDeterminism() {
        return isDeterministic;
    }

    /**
     * jelzi, hogy a játék éppen fut-e, azaz a Virologist-ek körei mennek-e sorban
     */
    private static boolean gameRunning = true;

    /**
     * Getter,  visszaadja az gameRunning változó értékét
     * @return a játék éppen fut-e
     */
    public static boolean isGameRunning() {
        return gameRunning;
    }

    /**
     *  jelzi, hogy hányadik Virologist köre van épp, -1, ha még senkinek sincs a köre
     */
    private static int currentVirologist = -1;

    /**
     * Getter, visszaadja a currentVirologist-al indexelt Virologist-et, null-t ha a currentVirologist értéke -1.
     * @return virológus, akinek éppen a köre van
     */
    public static Virologist getCurrentVirologist() {
        return currentVirologist < 0 ? null : virologists.get(currentVirologist);
    }

    /**
     * a játékban lévő Field-ek az ‘id’ értékükkel, mint kulcs eltárolva
     */
    private static HashMap<Integer, Field> fields = new HashMap<Integer, Field>();
    
    /**
     * a játékban lévő Virologist-ok az ‘id’ értékükkel, mint kulcs eltárolva
     */
    private static TreeMap<Integer, Virologist> virologists = new TreeMap<Integer, Virologist>();
    
    /**
     * a játékban lévő összes GeneticCode-ból 1 példány
     */
    private static HashSet<GeneticCode> geneticCodes = new HashSet<GeneticCode>();

    /**
     * Visszaadja a játékban jelenlévő összes genetikai kódot
     * @return geneticCodes - genetikai kódok hashSet-e
     */
    public static HashSet<GeneticCode> getGeneticCodes() {
        return geneticCodes;
    }

    /**
     * Eltárolja a kapott GeneticCode-ot a geneticCodes tárolóban.
     * @param gc hozzáadandó GeneticCode
     * @return ‘True’-val tér vissza, ha eddig nem szerepelt benne, egyébként ‘false’-al.
     */
    public static boolean addGeneticCode(GeneticCode gc)
    {
        return geneticCodes.add(gc);
    }

    /**
     * Eltárolja a kapott Field-et az ‘id’-jével együtt a fields tárolóban.
     * @param f hozzáadandó field
     * @return ‘True’-val tér vissza, ha a tároló még nem tartalmazta a Field-et, egyébként ‘false’-al.
     */
    public static boolean addField(Field f) {
        return fields.put(f.getId(), f) == null;
    }

    /**
     * Eltárolja a kapott Virologist-et az ‘id’-jével együtt a virologists tárolóban.
     * @param v Virologistokhoz hozzáadandó virologist
     * @return ‘True’-val tér vissza, ha a tároló még nem tartalmazta a Virologist-et, egyébként ‘false’-al.
     */
    public static boolean addVirologist(Virologist v) {
        return virologists.put(v.getId(), v) == null;
    }

    /**
     * Kilépteti a kapott Virologist-et a Field-jéről, kiszedi a tárolóba a Virologist indexéhez ‘null’ értéket rak be.
     * @param v eltávolítandó virologist
     * @return ‘True’-val tér vissza, ha a tároló tartalmazta eddig a Virologist-et, egyébként ‘false’-al.
     */
    public static boolean removeVirologist(Virologist v) {
        Field currentField = v.getCurrentField();
        if (currentField != null) {
            currentField.stepOut(v);
        }
        return virologists.remove(v.getId()) != null;
    }

    /**
     * visszaadja a fields tárolót
     * @return az összes Field
     */
    public static HashMap<Integer, Field> getFields() {
        return fields;
    }

    /**
     * visszaadja a kapott indexű Field-et, ha nincs ilyen akkor ‘null’-t.
     * @param id kapott index
     * @return kapott indexű Field, ha nincs ilyen, akkor null
     */
    public static Field getField(int id) {
        return fields.get(id);
    }

    /**
     * Visszaadja a virologists tárolót
     * @return az összes Virologist
     */
    public static TreeMap<Integer, Virologist> getVirologists() {
        return virologists;
    }

    /**
     * Visszaadja a kapott indexű Virologist-et, ha nincs ilyen akkor ‘null’-t.
     * @param id kapott index
     * @return kapott indexű Virologist, ha nincs, akkor null
     */
    public static Virologist getVirologist(int id) {
        return virologists.get(id);
    }

    /**
     * Növeli a currentVirologist számlálót,
     * ha az túllép a legnagyobbon, akkor megkeresi a legelsőt,
     * majd meghívja currentVirologist ‘id’-jű Virologist startTurn() függvényét.
     */
    public static void nextTurn() {
        currentVirologist++;
        // Nem biztos, hogy van eggyel nagyobb id-jű virológus,
        // ezért megkeressük a következőt
        try {
            currentVirologist = virologists.ceilingKey(currentVirologist);
        }
        // Ha nem volt nagyobb nála, akkor elölről keresünk,
        // ha még így is NullPointerException lenne, akkor üres a lista :(
        catch (NullPointerException e) {
            currentVirologist = virologists.ceilingKey(0);
        }
        
   
        Virologist currentVir = virologists.get(currentVirologist);
        currentVir.startTurn();
        refreshView();
    }

    /**
     * ha a geneticCodes tároló tartalma megegyezik a paraméterként kapott ‘v’ Virologist
     * getGeneticCodes() visszatérési értékével, akkor a winner értékét beállítja a ‘v’-re.
     * @param v Virológus, akinek a getGeneticCodes() visszatérési értékét üsszehasonlítjuk
     */
    public static void virologistLearnedGeneticCode(Virologist v) {
        if (geneticCodes.equals(v.getGeneticCodes())) {
            endGame();
        }
    }

    /**
     * A játék leállítása.
     */
    private static void endGame(){
        Canvas canvas = Canvas.getInstance();
        canvas.setConsole("You won the game!");
        gameRunning = false;
        gs = GameState.GAME_ENDED;
    }

    /**
     * A felhasználóktól érkező inputokat kezeli attól függően, hogy milyen GameState-ben van,
     * hogy milyen Fieldre akar lépni, milyen akciót akar végrehajtani, avagy a körét akarja befejezni. 
     * @param userSel a felhasználó által kiválasztott objektumokat tartalmazó struktúra
     */
    public static void HandleUserInput(UserSelection userSel){
        Canvas canvas = Canvas.getInstance();
        Virologist currentVir = getCurrentVirologist();
        if (currentVir == null) {
            canvas.setConsole("FAILURE: Cannot reach current virologist");
            return;
        }
        
        boolean virologistSelected = userSel.selectedVirologistID != -1;
        boolean fieldSelected = userSel.selectedFieldID != -1;
        boolean agentSelected = userSel.selectedAgentID != -1;
        boolean equipmentSelected = userSel.selectedEquipmentID != -1;
        boolean geneticCodeSelected = userSel.selectedGeneticCode != null;

        switch(gs){
            case  WAITING_FOR_MOVE:
            {
                if (fieldSelected) {
                    Field nextField = getField(userSel.selectedFieldID);
                    Field currentField = currentVir.getCurrentField();
                    if (nextField!=null && !currentField.equals(nextField)){
                        currentVir.moveTo(nextField);
                    }
                    canvas.setConsole("Choose Action");
                }
                else {
                    canvas.setConsole("No field selected. " + 
                                        "Choose Action");
                }
                break;
            }
            case WAITING_FOR_ACTION:
            {
                switch(userSel.selectedAction){
                    case CREATE_AGENT:
                    {
                        if (geneticCodeSelected) {
                            HashSet<GeneticCode> geneticCodes = currentVir.getGeneticCodes();
                            boolean gcIsScanned = false;
                            for (GeneticCode gencode : geneticCodes) {
                                if (gencode.equals(userSel.selectedGeneticCode)) {
                                    currentVir.createAgent(userSel.selectedGeneticCode);
                                    gcIsScanned = true;
                                    break;
                                }
                            }
                            if (!gcIsScanned) {
                                canvas.setConsole("ERROR: Virologist has not scanned the selected genetic code. " + 
                                "Choose Action again");
                                return;
                            }
                        }
                        else {
                            canvas.setConsole("ERROR: No genetic code selected. " + 
                            "Choose Action again");
                            return;
                        }
                        break;
                    }
                    case DROP_EQUIPMENT:
                    {
                        if (equipmentSelected) {
                            Equipment equipment = currentVir.getEquipments().get(userSel.selectedEquipmentID);
                            currentVir.dropEquipment(equipment);
                        }
                        else {
                            canvas.setConsole("ERROR: No equipment selected. " + 
                            "Choose Action again");
                            return;
                        }
                        break;
                    }
                    case KILL:
                    {
                        if (virologistSelected) {
                            Virologist targetVir = getVirologist(userSel.selectedVirologistID);
                            currentVir.kill(targetVir);
                        }
                        else {
                            canvas.setConsole("ERROR: No virologist selected to kill. " + 
                            "Choose Action again");
                            return;
                        }
                        break;
                    }
                    case STEAL:
                    {
                        if (virologistSelected) {
                            Virologist targetVir = getVirologist(userSel.selectedVirologistID);
                            currentVir.stealFrom(targetVir);
                        }
                        else {
                            canvas.setConsole("ERROR: No virologist selected to steal from. " + 
                            "Choose Action again");
                            return;
                        }
                        break;
                    }
                    case USE_AGENT:
                    {
                        if (virologistSelected && agentSelected) {
                            Virologist targetVir = getVirologist(userSel.selectedVirologistID);
                            Agent agent = currentVir.getAgents().get(userSel.selectedAgentID);
                            currentVir.useAgentOn(targetVir, agent);
                        }
                        else if (!virologistSelected) {
                            canvas.setConsole("ERROR: No virologist selected to use agent on. " + 
                            "Choose Action again");
                            return;
                        }
                        else {
                            canvas.setConsole("ERROR: No agent selected to use. " + 
                            "Choose Action again");
                            return;
                        }
                        break;
                    }
                    case COLLECT:
                    {
                        currentVir.collectFromField();
                        break;
                    }
                    case SKIP:
                    {
                        canvas.setConsole("No action selected. " + 
                        "Your turn has ended. Press Next to continue");
                        break;
                    }
                    default:
                    {
                        canvas.setConsole("FAILURE: Undefined selected action.");
                        return;
                    }
                }
                
                if (userSel.selectedAction != Action.SKIP && gs!=GameState.GAME_ENDED) {
                    canvas.setConsole("Your turn has ended. Press Next to continue");
                }
                break;
            }
            case WAITING_FOR_NEXT_TURN:
            {
                nextTurn();
                canvas.setConsole("Choose field to step on");
                break;
            }
            case GAME_ENDED:
            {
                break;
            }
        }
       
        gs = gs.nextState();
        refreshView();
    }

    private static void refreshView() {
        Virologist virologist = getCurrentVirologist();
        VirologistView.getInstance().setVirologist(virologist);
        FieldView.getInstance().setField(virologist.getCurrentField());
        FieldView.getInstance().draw();
        VirologistView.getInstance().draw();
    }

    /**
     * Pálya és virológusok generálása.
     */
    public static void createMap()
    {
        /// Field-ek
        Field f1 = new Field();
        addField(f1);

        Storage st1 = new Storage(20, 20);
        addField(st1);
        connentFields(f1, st1);

        Shelter sh1 = new Shelter(new AxeEquipment());
        addField(sh1);
        connentFields(st1, sh1);

        Field f2 = new Field();
        addField(f2);
        connentFields(sh1, f2);

        Shelter sh2 = new Shelter(new GlovesEquipment());
        addField(sh2);
        connentFields(sh2, f2);
        connentFields(sh2, f1);

        Storage st2 = new Storage(120, 200);
        addField(st2);
        connentFields(st2, sh2);

        Shelter sh3 = new Shelter(new GlovesEquipment());
        addField(sh3);
        connentFields(sh3, sh2);
        connentFields(sh3, f1);

        Shelter sh4 = new Shelter(new SackEquipment());
        addField(sh4);
        connentFields(f1, sh4);

        Storage st3 = new Storage(70, 30);
        addField(st3);
        connentFields(sh4, st3);

        Shelter sh5 = new Shelter( new WhiteCoatEquipment());
        addField(sh5);
        connentFields(st3, sh5);

        Laboratory l1 = new Laboratory(VaccineGene.getInstance());
        addField(l1);
        connentFields(f1, l1);
        connentFields(st3, l1);

        Field f3 = new Field();
        addField(f3);
        connentFields(l1, f3);

        InfectedLaboratory il1 = new InfectedLaboratory(ParalyzingVirusGene.getInstance());
        addField(il1);
        connentFields(f3, il1);

        Storage st4 = new Storage(75, 90);
        addField(st4);
        connentFields(il1, st4);

        Field f4 = new Field();
        addField(f4);
        connentFields(st4, f4);

        Laboratory l2 = new Laboratory(ParalyzingVirusGene.getInstance());
        addField(l2);
        connentFields(f4, l2);
        connentFields(st1, l2);

        Laboratory l3 = new Laboratory(ChoreaVirusGene.getInstance());
        addField(l3);
        connentFields(f1, l3);
        connentFields(st4, l3);
        connentFields(l2, l3);

        Shelter sh6 = new Shelter(new AxeEquipment());
        addField(sh6);
        connentFields(l1, sh6);
        connentFields(il1, sh6);
        connentFields(l3, sh6);

        Laboratory l4 = new Laboratory(MemoryLossVirusGene.getInstance());
        addField(l4);
        connentFields(l3, l4);
        connentFields(sh6, l4);


        /// Virologist-ok
        Virologist v1 = new Virologist();
        addVirologist(v1);
        v1.moveTo(f1);

        Virologist v2 = new Virologist();
        addVirologist(v2);
        v2.moveTo(st1);

        Virologist v3 = new Virologist();
        addVirologist(v3);
        v3.moveTo(f2);

        Virologist v4 = new Virologist();
        addVirologist(v4);
        v4.moveTo(f3);

        Virologist v5 = new Virologist();
        addVirologist(v5);
        v5.moveTo(l3);
    }

    /**
     * Két mező összekötésének segédfüggvénye.
     * 
     * @param f1 mező1
     * @param f2 mező2
     */
    private static void connentFields(Field f1, Field f2)
    {
        f1.setNeighbor(f2);
        f2.setNeighbor(f1);
    }
}
