package projlab;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.*;
import java.awt.event.*;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

/**
 * A játék grafikus megjelenéséért felelős singleton osztály.
 * Maga egy ablak, módosíthatók benne az egyes felületei.
 */
public class Canvas extends JFrame {
    /**
     * Sorosításhoz kell.
     */
	private static final long serialVersionUID = 1L;

    /**
     * Az egyedüli példány az osztályból.
     */
    private static Canvas only_instance = null;

    /**
     * A BorderLayout-ot követő ablak 4 területén lévő JPanel.
     */
    private JPanel east, west, northRight, northLeft, northCenter, center;

    /** 
     * Az összes éppen aktív virológushoz tartozó dolgokat összefogó panel 
     */
    private InventoryPanel inventory;

    /** 
     * Az aktív virológusok lehetséges akcióit megjelenítő táblázat
     */
    private JTable actions;

    /**
     * Az aktuális Field szomszédjait megjelenítő táblázat
     */
    private NeighborFieldsPanel neighborFields;

     /** 
    * az aktuális Field-en lévő Virologist-ok kijelölésére való gombok
    */
    private ArrayList<JRadioButton> virologists;

    /** 
    * az aktuális Field-en lévő Virologist-ok kijelölésére való gombok csoportja
    */
    private ButtonGroup virologistsGroup;

    /**
     * A konzolt reprezentáló JLabel
     */
    private JLabel console;

    /**
     * a mező típusa, amin éppen a virológus áll
     */
    private JLabel fieldType;

    /**
     * A jelenlegi virológus azonosítóját írja ki
     */
    private JLabel currentVirologist;

    /**
     * A "next" gombot reprezentáló objektum, ezzel tudja a felhasználó egy köre fázisát befejezni
     */
    private JButton next;

    /**
     * ActionListener osztály, a gomb megyomásakor meghívja a giveUserInput() függvényt
     */
    private class NextActionListener implements ActionListener {
        @Override
		public void actionPerformed(ActionEvent ae) {
			giveUserInput();
		}
	}

	public Canvas() {
		super();
        setTitle("Game");
        setSize(1000,600);

        initializeEast();
        initializeWest();
        initializeCenter();
        initializeNorth();

        initializeInventory();
        initilaizeNeighborFields();
        initializeActions();
        initializeVirologists();
        initializeConsole();
        initializeNext();
        initializeCurrentField();
        initializeCurrentVirologist();

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}

    /**
     * Visszaadja az egyedüli példányt az osztályból.
     * @return az egyedüli példány
     */
    public static Canvas getInstance() {
        if (only_instance == null) {
            only_instance = new Canvas();
        }
        return only_instance;
    }

    /**
     * Inicializálja az "east" JPanel tagváltozót
     */
    private void initializeEast(){
        east = new JPanel();
        add(east, BorderLayout.EAST);
        east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
    }

    /**
     * Inicializálja a "west" JPanel tagváltozót
     */
    private void initializeWest() {
        west = new JPanel();
        add(west, BorderLayout.WEST);
        west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
    }

    /**
     * Inicializálja a "center" JPanel tagváltozót
     */
    private void initializeCenter() {
        center = new JPanel();
        add(center, BorderLayout.CENTER);
    }

    /**
     * Inicializálja a "north" JPanel tagváltozót
     */
    private void initializeNorth(){
        JPanel north = new JPanel(new BorderLayout());
        add(north, BorderLayout.NORTH);

        northLeft = new JPanel();
        northLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
        northLeft.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        north.add(northLeft, BorderLayout.WEST);

        northCenter = new JPanel();
        north.add(northCenter, BorderLayout.CENTER);

        northRight = new JPanel();
        //jobbról tölti fel a fenti részt a Next gomb miatt
        northRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
        northRight.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        north.add(northRight, BorderLayout.EAST);
    }

    /**
     * Beállítja az aktív virológus felszerelését megjelenítő panelt a grafikus felület specifikációjában megjelölt részre.
     * Majd inicializálja a panelben lévő komponenseket, és feltölti őket a kezdőértékükkel.  
     */
    private void initializeInventory() {
        inventory = new InventoryPanel();
        west.add(inventory);
    }

    /**
     * Inicializálja a neighborFields tagváltozót, feltölti két üres sorral.
     */
    private void initilaizeNeighborFields() {
        neighborFields = new NeighborFieldsPanel();
        east.add(neighborFields);
    }

    /**
     * inicializálja az actions tagváltozót, feltölti a lehetséges akció-típusokkal
     */
    private void initializeActions() {
        //Use Action JTable inicializálása
        String[][] data = {
            { "Create agent" },
            { "DropEquipment" },
            { "Kill" },
            { "Steal" },
            { "Use agent" },
            { "Collect" },
            { "Skip" }
        };
        // oszlop nevek
        String[] columnNames = { "Use Action" };

        actions = new JTable(data, columnNames);
        actions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        actions.setDefaultEditor(Object.class, null);
        JScrollPane jsp2 = new JScrollPane(actions);
        east.add(jsp2);
    }

    /**
     * Inicializálja a virologists ButtonGroup-ot, de még nem tesz bele JRadioButtont
     */
    private void initializeVirologists() {
        virologists = new ArrayList<JRadioButton>();
        virologistsGroup = new ButtonGroup();
    }

     /**
     * Inicializálja a szöveget megjelenítő konzolt
     */
    private void initializeConsole(){
        JPanel consolePanel = new JPanel();
        consolePanel.setBackground(Color.BLACK);
        console = new JLabel();
        console.setForeground(Color.WHITE);
        consolePanel.add(console);
        console.setText("Choose field to step on");
        east.add(consolePanel); 
    }

    /**
     * Inicializálja a Next gombot
     */
    private void initializeNext(){
        next = new JButton("Next");
        next.addActionListener(new NextActionListener());
        JPanel jp = new JPanel();
        jp.add(next);
        northRight.add(jp, 0);
    }

    /**
     * Inicializálja a kiírt mező típusát a bal felső sarokban.
     */
    private void initializeCurrentField(){
        fieldType = new JLabel();
        fieldType.setText("Current field is:");
        northLeft.add(fieldType);
    }

    /**
     * Inicializálja a jelenlegi virológus azonosítóját kiíró mezőt.
     */
    private void initializeCurrentVirologist(){
        currentVirologist = new JLabel();
        currentVirologist.setText("Current virologist is: ");
        northCenter.add(currentVirologist);
    }

    // INTERFÉSZEK:

    /**
     * Beállítja a táblázat aminoacid értékét a kapottra.
     * @param value az új érték
     */
    public void setAminoAcid(Integer value) {
        inventory.setAminoAcidValue(value);
    }
    /**
     * Beállítja a táblázat nukleotid értékét a kapottra.
     * @param value az új érték
     */
    public void setNucleotide(Integer value) {
        inventory.setNucleotideValue(value);
    }
    /**
     * Beállítja a táblázat genetikai kód megszerzettség értékét a kapottra.
     * @param gc a genetikai kód
     * @param collected az érték
     */
    public void setGeneticCodeCollected(GeneticCode gc, boolean collected) {
        inventory.setGeneticCodeCollected(gc, collected);
    }

    /**
     * Visszaadja az éppen kiválasztott genetikai kódot, null-t, ha nincs egy sem kiválasztva.
     * @return kiválasztott genetikai kód/null
     */
    public GeneticCode getSelectedGeneticCode() {
        return inventory.getSelectedGeneticCode();
    }

    /**
     * Hozzáadja a kapott felszerelést az "equipmentTable" táblázathoz. 
     * @param e a kapott felszerelés
     */
    public void addEquipment(Equipment e) {
        inventory.addEquipment(e);
    }

    /**
     * Visszaadja az éppen kiválasztott felszerelés id-jét, vagy "-1"-et, ha nincs egy sem kiválasztva.
     * @return kiválasztott felszerelés id-je/-1
     */
    public int getSelectedEquipmenntID() {
        return inventory.getSelectedEquipmenntID();
    }

    /**
     * Kiüríti az "equipmentTable" táblázatot.
     */
    public void clearEquipment() {
        inventory.clearEquipment();
    }

    /**
     * Hozzáadja a kapott ágenst az "agentTable" táblázathoz. 
     * @param a a kapott ágens
     */
    public void addAgent(Agent a) {
        inventory.addAgent(a);
    }

    /**
     * Visszaadja az éppen kiválasztott ágens id-jét, vagy "-1"-et, ha nincs egy sem kiválasztva.
     * @return kiválasztott ágens id-je/-1
     */
    public int getSelectedAgentID() {
        return inventory.getSelectedAgentID();
    }

    /**
     * Kiüríti az "agentTable" táblázatot.
     */
    public void clearAgents() {
        inventory.clearAgents();
    }

    /**
     * Hozzáadja a kapott hatást az "effectTable" táblázathoz. 
     * @param e a kapott hatás
     */
    public void addEffect(Effect e) {
        inventory.addEffect(e);
    }

    /**
     * Kiüríti az "effectTable" táblázatot.
     */
    public void clearEffects() {
        inventory.clearEffects();
    } 

    /**
     * Hozzáad egy virológust a mezőn lévő virológusokat megjelenítő listához
     * @param id a hozzáadott virológus id-je
     */
    public void addVirologist(int id){
        JRadioButton jb = new JRadioButton(String.valueOf(id));
        virologists.add(jb);
        virologistsGroup.add(jb);
        center.add(jb);
    }

    /**
     * Visszaadja a kiválasztott virológus id-ját
     */
    public int getSelectedVirologistId(){
        for (JRadioButton jb : virologists) {
            if(jb.isSelected()){
               int i = Integer.parseInt(jb.getText());
               return i;
            }
            
        }
        return -1;
    }

    /**
     * Eltávolít minden JRadioButtont
     */
    public void clearVirologists(){
        for (JRadioButton jb : virologists) {
            virologistsGroup.remove(jb);
            center.remove(jb);
            center.validate();
        }
        virologists.clear();
           
    }

    /**
     * Visszaadja, hogy melyik akció van kijelölve felületen.
     * @return a kiválasztott akció
     */
    private Action getSelectedAction() {
        int row = actions.getSelectedRow();
        switch(row) {
            case 0:
                return Action.CREATE_AGENT;
            case 1:
                return Action.DROP_EQUIPMENT;
            case 2:
                return Action.KILL;
            case 3:
                return Action.STEAL;
            case 4:
                return Action.USE_AGENT;
            case 5:
                return Action.COLLECT;
            case 6:
                return Action.SKIP;
            default:
                return Action.SKIP;
        }
    }

    /**
     * Hozzáadja a kapott mezőt a "neighborFieldTable" táblázathoz. 
     * @param f a kapott mező
     */
    public void addNeighborField(Field f) {
        neighborFields.addNeighborField(f);
    }

    /**
     * Visszaadja az éppen kiválasztott mező id-jét, vagy "-1"-et, ha nincs egy sem kiválasztva.
     * @return kiválasztott mező id-je/-1
     */
    public int getSelectedNeighborFieldID() {
        return neighborFields.getSelectedNeighborFieldID();
    }

    /**
     * Kiüríti az "neighborFieldsTable" táblázatot.
     */
    public void clearNeighborFields() {
        neighborFields.clearNeighborFields();
    }

    /**
     * Beállítja a fieldType kiírást
     * @param s a kiírandó szöveg a bal felső sarokban
     */
    public void setCurrentField(String s){
        String s2 = "Current field is: "+ s;
        fieldType.setText(s2);
    }

    /**
     * Beállítja a jelenlegi virológus kiírásban szereplő id-t
     * @param id ez az id jelenik meg, mint jelenlegi virológus id
     */
    public void setCurrentVirologist(int id){
        String s2 = "Current virologist is: "+ String.valueOf(id);
        currentVirologist.setText(s2);
    }

    /**
     * Beállítja a console szövegét
     * @param s ezt a szöveget jeleníti meg a console-n
     */
    public void setConsole(String s){
        console.setText(s);
    }
    
    /**
     * A gomb nyomáskor meghívódó függvény, ami átadja a kiválasztott elemeket a Controllernek.
     */
    public void giveUserInput() {
        int selectedVirologistID = getSelectedVirologistId();
        int selectedFieldID = getSelectedNeighborFieldID();
        int selectedAgentID = getSelectedAgentID();
        int selectedEquipmentID = getSelectedEquipmenntID();
        Action selectedAction = getSelectedAction();
        GeneticCode selectedGeneticCode = getSelectedGeneticCode();

        UserSelection userSel = new UserSelection(selectedVirologistID, selectedFieldID, selectedAgentID, selectedEquipmentID, selectedAction, selectedGeneticCode);
        Controller.HandleUserInput(userSel);
    }

}
