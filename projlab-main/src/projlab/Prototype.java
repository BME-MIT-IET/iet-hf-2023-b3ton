package projlab;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collection;

public class Prototype {

    private static final String badInputMessage = "Rossz a parancs paraméterezése!";

    private static final String noEquipmentLikeThisMessage = "Nincs ilyen felszerelés!";

    private static final String noGeneLikeThisMessage = "Nincs ilyen gén!";

    private static final String addedToLiteral = " added to ";

    private static final String hasLiteral = " has : ";

    private static final String Paralyzing = "paralyzing-gene";
    private static final String Chorea = "chorea-gene";
    private static final String MemoryLoss = "memory-loss-gene";
    private static final String Vaccine = "vaccine-gene";

    public static void main(String[] args) {

        Scanner bemenet = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            String szoveg;
            try {
                szoveg = bemenet.nextLine();
            // ha üres a sor
            if (szoveg.equals("")) {
                continue;
            }

            String[] darabolt = szoveg.split(" ");

            try{
                switch (darabolt[0]) {

                    case "create-field":
                        createField(darabolt);
                        break;
                    case "create-virologist":
                    createVirologist(darabolt);
                        break;
                    case "add-material":
                        addMaterial(darabolt);
                        break;
                    case "add-equipment":
                        addEquipment(darabolt);
                        break;
                    case "add-agent":
                        addAgent(darabolt);
                        break;
                    case "add-effect":
                    addEffect(darabolt);
                        break;
                    case "connect-fields":
                    connectFields(darabolt);
                        break;
                    case "place-virologist":
                    placeVirologist(darabolt);
                        break;
                    case "determinism":
                    setDeterminism(darabolt);
                        break;
                    case "get-current-virologist":
                        getCurrentVirologist(darabolt);
                        break;
                    case "next-turn":
                        nextTurn(darabolt);
                        break;
                    case "get-neighbor-fields":
                        getNeighborFields(darabolt);
                        break;
                    case "get-virologists":
                        getVirologists(darabolt);
                        break;
                    case "get-current-field":
                        getCurrentField(darabolt);
                        break;
                    case "get-agents":
                        getAgents(darabolt);
                        break;
                    case "get-equipments":
                        getEquipments(darabolt);
                        break;
                    case "get-equipments-of-field":
                        getEquipmentsOfField(darabolt);
                        break;
                    case "get-genetic-codes":
                        getGeneticCodes(darabolt);
                        break;
                    case "get-material":
                        getMaterial(darabolt);
                        break;
                    case "get-material-of-field":
                        getMaterialOfField(darabolt);
                        break;
                    case "get-effects":
                        getEffects(darabolt);
                        break;
                    case "virologist-moves":
                        virologistMoves(darabolt);
                        break;
                    case "virologist-action":
                        action(darabolt);
                        break;
                    case "list":
                        break;
                    case "exit":
                        exit = true;
                        break;
                    default:
                        hiba("Nincs ilyen parancs!");
                        break;
                }
            }catch(NumberFormatException e){
                kiir("Nem jó formátumú parancs!");
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        bemenet.close();
    }

    private static void hiba(String szoveg) {
        System.err.println(szoveg);
        System.exit(1);
    }

    public static void kiir(String szoveg) {
        System.out.println(szoveg);
    }

    /**
     * A crate-field parancsot hajtja végre
     * @param cmd a parancs argumentumai 
     */
    private static void createField(String[] cmd){
        Field field = null;
        Equipment e = null;
        if (cmd.length == 1 || cmd.length>4) {
            hiba(badInputMessage);
        } else {
            switch (cmd[1]) {
                case "field":
                    field = new Field();
                    break;
                case "shelter":
                    field = new Shelter();
                    if (cmd.length == 3) {
                        switch (cmd[2]) {
                            case "sack":
                                e = new SackEquipment();
                                break;
                            case "gloves":
                                e = new GlovesEquipment();
                                break;
                            case "axe":
                                e = new AxeEquipment();
                                break;
                            case "white-coat":
                                e = new WhiteCoatEquipment();
                                break;
                            default:
                                hiba(noEquipmentLikeThisMessage);
                                break;
                        }
                        ((Shelter) field).addEquipment(e); 
                    }
                    break;
                case "storage":
                    if (cmd.length == 4) {
                        field = new Storage(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]));
                    } else {
                        field = new Storage();
                    }
                    break;
                case "laboratory":
                    GeneticCode gc = null;
                    if (cmd.length == 3) {
                        switch (cmd[2]) {
                            case Paralyzing:
                                gc = ParalyzingVirusGene.getInstance();
                                break;
                            case Chorea:
                                gc = ChoreaVirusGene.getInstance();
                                break;
                            case MemoryLoss:
                                gc = MemoryLossVirusGene.getInstance();
                                break;
                            case Vaccine:
                                gc = VaccineGene.getInstance();
                                break;
                            default:
                                hiba(noGeneLikeThisMessage);
                                break;
                        }
                    }
                    field = new Laboratory(gc);
                    break;
                case "infected-laboratory":
                    GeneticCode gci = null;
                    if (cmd.length == 3) {
                        switch (cmd[2]) {
                            case Paralyzing:
                                gci = ParalyzingVirusGene.getInstance();
                                break;
                            case Chorea:
                                gci = ChoreaVirusGene.getInstance();
                                break;
                            case MemoryLoss:
                                gci = MemoryLossVirusGene.getInstance();
                                break;
                            case Vaccine:
                                gci = VaccineGene.getInstance();
                                break;
                            default:
                                hiba(noGeneLikeThisMessage);
                                break;
                        }
                    }
                    field = new InfectedLaboratory(gci);
                    break;
                default:
                    hiba("Nincs ilyen mező!");
                    return;
            }
        }
        Controller.addField(field);
        try {
            StringBuilder output = new StringBuilder();
            output.append("field created " + field.getId() + " ");
            for (int i = 1; i < cmd.length; ++i) {
                output.append(cmd[i]);
                output.append(" ");
            }
            if (cmd[1].equals("shelter")) {
                output.append(e.getId());
            }
            kiir(output.toString());
        }catch (NullPointerException npe ){
            npe.printStackTrace();
        }
    }

    /**
     * A create-virologist parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void createVirologist(String[] cmd){
        Virologist nVirologist = new Virologist();
        Controller.addVirologist(nVirologist);
        kiir("virologist created "+nVirologist.getId());
    }

    /**
     * Az add-material parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void addMaterial(String[] cmd){
        //Ellenőrzi a megadott paraméterek számát
        if(cmd.length!=3 && cmd.length!=4){
            hiba(badInputMessage);
            return;
        }
        int nucleotide = Integer.parseInt(cmd[2]);
        int amino = 0;
        //Amennyiben csak nukleotidot kell hozzáadni, 0 aminosav kerül átadásra
        if(cmd.length==4){
            amino = Integer.parseInt(cmd[3]);
        }
        //Negatív mennyiségű anyag ne adható hozzá!!
        if(nucleotide<0 || amino<0){
            hiba("Csak pozitív mennyiségű nukleotidot és aminosavat adhatsz hozzá!");
        }
        Virologist amVirologist = Controller.getVirologist(Integer.parseInt(cmd[1]));
        amVirologist.addNucleotide(nucleotide);
        amVirologist.addAminoAcid(amino);
        kiir("material added to "+amVirologist.getId()+" "+nucleotide+" "+amino);
    }

    /**
     * Az add-equipment parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void addEquipment(String[] cmd){
        Virologist aeqVirologist = Controller.getVirologist(Integer.parseInt(cmd[1]));
        Equipment e = null;
        if(cmd.length!=3){
            hiba(badInputMessage);
            return;
        }
        switch (cmd[2]) {
            case "sack":
                e = new SackEquipment();
                break;
            case "gloves":
                e = new GlovesEquipment();
                break;
            case "axe":
                e = new AxeEquipment();
                break;
            case "white-coat":
                e = new WhiteCoatEquipment();
                break;
            default:
                hiba(noEquipmentLikeThisMessage);
                break;
        }
        aeqVirologist.addEquipment(e);
        kiir("equipment "+e.getId()+addedToLiteral+aeqVirologist.getId());
    }

    /**
     * Az add-agent parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void addAgent(String[] cmd){
        Virologist aagVirologist = Controller.getVirologist(Integer.parseInt(cmd[1]));
        Agent a = null;
        if(cmd.length!=3){
            hiba(badInputMessage);
            return;
        }
        switch (cmd[2]) {
            case "chorea-virus":
                a = new ChoreaVirus();
                break;
            case "memory-loss-virus":
                a = new MemoryLossVirus();
                break;
            case "paralyzing-virus":
                a = new ParalyzingVirus();
                break;
            case "vaccine":
                a = new Vaccine();
                break;
            default:
                hiba(noEquipmentLikeThisMessage);
                break;
        }
        aagVirologist.addAgent(a);
        kiir("agent "+a.getId()+addedToLiteral+aagVirologist.getId());
    }

    /**
     * Az add-effect parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void addEffect(String[] cmd){
        Virologist aefVirologist = Controller.getVirologist(Integer.parseInt(cmd[1]));
        Effect effect = null;
        if(cmd.length!=4){
            hiba(badInputMessage);
            return;
        } 
        int time = Integer.parseInt(cmd[3]);
        switch (cmd[2]) {
            case "paralyzing":
                effect = new TimedParalyzingEffect(time);
                break;
            case "chorea":
                effect = new TimedChoreaEffect(time);
                break;
            case "memory-loss":
                effect = new TimedMemoryLossEffect(time);
                break;
            case "protecting":
                effect = new TimedProtectingEffect(time);
                break;
            case "bear-dance":
                effect = new BearDanceEffect();
                break;
            default:
                hiba("Nincs ilyen hatás!");
                break;
        }
        aefVirologist.addEffectBy(effect, null);
        kiir("effect "+cmd[2]+ " " + cmd[3] +addedToLiteral+aefVirologist.getId());
    }

    /**
     * A connect-fields parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void connectFields(String[] cmd){
        Field conn1 = Controller.getField(Integer.parseInt(cmd[1]));
        Field conn2 = Controller.getField(Integer.parseInt(cmd[2]));
        conn1.setNeighbor(conn2);
        conn2.setNeighbor(conn1);
        kiir("fields "+conn1.getId()+" "+ conn2.getId()+" connected");
    }

    /**
     * A place-virologist parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void placeVirologist(String[] cmd){
        Virologist pVirologist = Controller.getVirologist(Integer.parseInt(cmd[1]));
        Field pField = Controller.getField(Integer.parseInt(cmd[2]));
        pVirologist.moveTo(pField);
        kiir("virologist "+pVirologist.getId()+" placed on "+ pField.getId());
    }


    /**
     * A determinizmust változtató parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void setDeterminism(String[] cmd){
        boolean b = Boolean.parseBoolean(cmd[1]);
        Controller.setDeterminism(b);
        kiir("determinism is set to "+cmd[1]);
    }

    /**
     * A get-current-virologist parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void getCurrentVirologist(String[] cmd){
        Virologist gcVirologist = Controller.getCurrentVirologist();
        kiir("current virologist is "+gcVirologist.getId());
    }

    /**
     * A next-turn parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void nextTurn(String[] cmd){
        Controller.nextTurn();
        kiir("turn started for "+Controller.getCurrentVirologist().getId());
    }

    /**
     * A get-neighbor-fields parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void getNeighborFields(String[] cmd){
        if(cmd.length!=2){
            hiba(badInputMessage);
            return;
        }
        int fieldId = Integer.parseInt(cmd[1]);
        Field f = Controller.getField(fieldId);
        Set<Field> fields = f.getNeighbors();
        String output = "neighbor fields are ";
        for (Field field : fields) {
           output+=field.getId()+" ";
        } 
        kiir(output);
    }

    /**
     * A get-virologists parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void getVirologists(String[] cmd){
        if(cmd.length!=2){
            hiba(badInputMessage);
            return;
        }
        int fieldId = Integer.parseInt(cmd[1]);
        Field f = Controller.getField(fieldId);
        Set<Virologist> virologists = f.getVirologists();
        String output ="on "+fieldId+" virologists are ";
        for (Virologist v : virologists) {
            output+=v.getId()+" ";
        } 
        kiir(output);
    }

    /**
     * A get-current-field parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void getCurrentField(String[] cmd){
        if(cmd.length!=2){
            hiba(badInputMessage);
            return;
        }
        int virId = Integer.parseInt(cmd[1]);
        Virologist v = Controller.getVirologist(virId);
        Field f = v.getCurrentField();
        kiir("current field for "+virId+" is " + f.getId());
    }

    /**
     * A get-agents parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void getAgents(String[] cmd){
        if(cmd.length!=2){
            hiba(badInputMessage);
            return;
        }
        int virId = Integer.parseInt(cmd[1]);
        Virologist v = Controller.getVirologist(virId);
        Collection<Agent> agents = v.getAgents().values();
        String output = virId+hasLiteral;
        for (Agent a  : agents) {
            output+= a.getId()+" ";
        } 
        kiir(output);
    }

    /**
     * A get-equipments parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void getEquipments(String[] cmd){
        if(cmd.length!=2){
            hiba(badInputMessage);
            return;
        }
        int virId = Integer.parseInt(cmd[1]);
        Virologist v = Controller.getVirologist(virId);
        Collection<Equipment> equipments = v.getEquipments().values();
        String output = virId+hasLiteral;
        for (Equipment e  : equipments) {
            output+=e.getId()+" ";
        } 
        kiir(output);
    }

    /**
     * A get-equipments-of-field parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void getEquipmentsOfField(String[] cmd){
        if(cmd.length!=2){
            hiba(badInputMessage);
            return;
        }
        int fieldId = Integer.parseInt(cmd[1]);
        Field s = Controller.getField(fieldId);
        Equipment e = s.getEquipment();
        if (e ==null){
            kiir(fieldId+hasLiteral);
        }else{
           kiir(fieldId+hasLiteral+e.getId());
        }
        
    }

    /**
     * A get-genetic-codes parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void getGeneticCodes(String[] cmd){
        if(cmd.length!=2){
            hiba(badInputMessage);
            return;
        }
        int virId = Integer.parseInt(cmd[1]);
        Virologist v = Controller.getVirologist(virId);
        HashSet<GeneticCode> genCodes = v.getGeneticCodes();
        StringBuilder output = new StringBuilder(virId+hasLiteral);
        for (GeneticCode g  : genCodes) {
            output.append(g.toString()+" ");
        } 
        kiir(output.toString());
    }

    /**
     * a get-material paracsot hajtja végre.
     * @param cmd  a parancs argumentumai egy String tömbben
     */
    private static void getMaterial(String[] cmd) {
        if(cmd.length!=2){
            hiba(badInputMessage);
            return;
        }
        int virId = Integer.parseInt(cmd[1]);
        Virologist v = Controller.getVirologist(virId);
        int amino = v.getAminoAcid();
        int nucleotide = v.getNucleotide();
        String output = virId+hasLiteral+amino+" aminoacid "+nucleotide+" nucleotide";
        kiir(output);
    }

    /**
     * a get-material-of-field parancsot hajtja végre
     * @param cmd  a parancs argumentumai egy String tömbben
     */
    private static void getMaterialOfField(String[] cmd) {
        if(cmd.length!=2){
            hiba(badInputMessage);
            return;
        }
        int fieldId = Integer.parseInt(cmd[1]);
        Storage s = (Storage) Controller.getField(fieldId);
        int amino = s.getAminoAcid();
        int nucleotide = s.getNucleotide();
        String output = fieldId+hasLiteral+ amino+" aminoacid "+nucleotide+ " nucleotide";
        kiir(output);
    }

    /**
     * A get-effects parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void getEffects(String[] cmd){
        if(cmd.length!=2){
            hiba(badInputMessage);
            return;
        }
        int virId = Integer.parseInt(cmd[1]);
        Virologist v = Controller.getVirologist(virId);
        ArrayList<Effect> effects = v.getEffects();
        String output = virId+hasLiteral;
        for (Effect e  : effects) {
           output+= e.toString() + " ";
        } 
        kiir(output);
    }

    /**
     * A virologist-moves parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void virologistMoves(String[] cmd){
        Virologist curr = Controller.getCurrentVirologist();
        Field next = Controller.getField(Integer.parseInt(cmd[1]));
        curr.moveTo(next);
        kiir(curr.getId()+ " moved to "+next.getId());
    }

    /**
     * A virologist-action parancsot hajtja végre
     * @param cmd a parancs argumentumai egy String tömbben
     */
    private static void action(String[] cmd){
        try {
            if (cmd.length < 2 || cmd.length > 5) {
                hiba(badInputMessage);
                return;
            }
            Virologist v = Controller.getCurrentVirologist();
            String output = String.valueOf(v.getId()) + " took action " + cmd[1] + " ";
            switch (cmd[1]) {
                case "use-agent":
                    Virologist useOnVir = null;
                    Collection<Agent> agents = v.getAgents().values();
                    Agent toUse = null;
                    for (Agent a : agents) {
                        if (a.getId() == Integer.parseInt(cmd[2])) {
                            toUse = a;
                            break;
                        }
                    }
                    if (cmd.length == 3) {
                        useOnVir = v;
                    } else if (cmd.length == 4) {
                        useOnVir = Controller.getVirologist(Integer.parseInt(cmd[3]));
                    } else {
                        hiba(badInputMessage);
                        return;
                    }
                    if (toUse != null) {
                        toUse.useOnBy(useOnVir, v);
                        output += String.valueOf(toUse.getId()) + " " + String.valueOf(useOnVir.getId());
                    } else {
                        hiba("Rossz az ágens-azonosító");
                        return;
                    }
                    break;
                case "collect":
                    v.collectFromField();
                    break;
                case "steal":
                    Virologist toStealFrom = Controller.getVirologist(Integer.parseInt(cmd[2]));
                    v.stealFrom(toStealFrom);
                    output += String.valueOf(toStealFrom.getId());
                    break;
                case "kill":
                    Virologist toKill = Controller.getVirologist(Integer.parseInt(cmd[2]));
                    v.kill(toKill);
                    output += toKill.getId();
                    break;
                case "create-agent":
                    GeneticCode gc = null;
                    if (cmd.length == 3) {
                        switch (cmd[2]) {
                            case Paralyzing:
                                gc = ParalyzingVirusGene.getInstance();
                                break;
                            case Chorea:
                                gc = ChoreaVirusGene.getInstance();
                                break;
                            case MemoryLoss:
                                gc = MemoryLossVirusGene.getInstance();
                                break;
                            case Vaccine:
                                gc = VaccineGene.getInstance();
                                break;
                            default:
                                hiba(noGeneLikeThisMessage);
                                break;
                        }
                    }
                    int id = v.createAgent(gc);
                    output += id;
                    break;
                case "drop-equipment":
                    if (cmd.length != 3) {
                        hiba(badInputMessage);
                        return;
                    }
                    Collection<Equipment> equipments = v.getEquipments().values();
                    Equipment e = null;
                    for (Equipment eq : equipments) {
                        if (eq.getId() == Integer.parseInt(cmd[2])) {
                            e = eq;
                            break;
                        }
                    }
                    v.dropEquipment(e);
                    output += String.valueOf(e.getId());
                    break;
                default:
                    break;
            }

            kiir(output);
        } catch (NullPointerException npe){
            npe.printStackTrace();
        }
    }
}
