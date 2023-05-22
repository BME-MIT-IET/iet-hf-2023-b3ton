package projlab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

/**
 *  A virológus felszerelését megjelenítő panel.
 */
public class InventoryPanel extends JPanel {
    /** 
     * Az éppen aktív virológus anyagkészletét megjelenítő táblázat
    */
    private JTable materialTable;

    /** 
     * Az éppen aktív virológus genetikai kódjait megjelenítő táblázat (?) 
    */
    private JTable geneticCodeTable;

    /**
     * Az éppen aktív virológus genetikai kódjait tároló adathalmaz.
     */
    private GeneticCodeData geneticCodeData;

    /**
     * A genetikai kódok tárolására alkalmas adathalmaz osztály.
     * Képes eltárolni az egyes genetikai kódokhoz a megszerzettséget is.
     */
    private class GeneticCodeData extends AbstractTableModel {
    
        /**
         * A genetikai kódokat tároló lista.
         */
        private List<GeneticCode> geneticCodes = new ArrayList<>();

        /**
        * Az a genetikai kódokhoz megtanultságot tároló térkép.
        */
        private HashMap<GeneticCode, Boolean> geneticCodeCollection = new HashMap<>();

        /**
         * Visszaadja a kapott indexű genetikai kódot a "geneticCodes" sorban.
         * @param index a kapott index
         * @return az adott indexen lévő genetikai kód
         */
        public GeneticCode getGeneticCode(int index) {
            return geneticCodes.get(index);
        }

        /**
         * Beállítja az oszlopok nevét.
         */
        @Override
        public String getColumnName(int column) {
            if (column == 0) {
                return "Genetic code type";
            }
            else if (column == 1) {
                return "Collected";
            }
            else {
                return null;
            }
        }
        /**
         * Hozzáadja a kapott genetikai kódot az adatokhoz.
         * @param gc a genetikai kód
         */
        public void addGeneticCode(GeneticCode gc) {
            geneticCodes.add(gc);
            geneticCodeCollection.put(gc, false);
            fireTableDataChanged();
        }

        /**
         * Beállítja a kapott genetikai kód megszerzettségét.
         * Ha a genetikai kód nem szerepelt eddig a tároltak között, akkor felveszi.
         * @param gc a genetikai kód
         * @param collected a megszerzettsége
         */
        public void setGeneticCodeCollection(GeneticCode gc, boolean collected) {
            
            geneticCodeCollection.put(gc, collected);
            fireTableDataChanged();
            
        }

        /**
         * Visszaadja az adott oszlop típusát.
         */
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 0) {
                return String.class;
            }
            else if (columnIndex == 1) {
                return Boolean.class;
            }
            else {
                return null;
            }
        }
        /**
         * Visszaadja a sorok számát.
         */
        @Override
        public int getRowCount() {
            return geneticCodes.size();
        }

        /**
         * Visszaadja az oszlopok számát.
         */
        @Override
        public int getColumnCount() {
            return 2;
        }
        /**
         * Visszaadja az értéket az adott cellában.
         */
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            GeneticCode gc = geneticCodes.get(rowIndex);
            if (columnIndex == 0) {
                return gc.toString();
            }
            else if (columnIndex == 1) {
                return geneticCodeCollection.get(gc);
            }
            else {
                return null;
            }
        }
    }

    /**
     * A virológus gyűjthető dolgainak tárolására alkalmas adathalmaz generikus osztály.
     * Egy oszlopa van, és és tetszőleges típusú gyűjtető dolog tárolható benne.
     */
    private class CollectibleData<T> extends AbstractTableModel {

        /**
         * A gyűjtető dolgokat tároló lista. A sorban elfoglalt hely megegyezik a táblázatban is elfoglalt pozícióval.
         */
        private ArrayList<T> data = new ArrayList<>();

        /**
         * Az adathalmaz mögött táblázat egyetlen oszlopának a neve.
         */
        private String name;

        /**
         * Az adathalmaz konstruktora a mögötte lévő táblázat nevével.
         * @param name a táblázat egyetlen oszlopának a neve
         */
        public CollectibleData(String name) {
            this.name = name;
        }

        /**
         * Visszaadja a kapott indexű gyűjthető dolgot sorban.
         * @param index a kapott index
         * @return az adott indexen lévő gyűjthető dolog
         */
        public T getCollectible(int index) {
            return data.get(index);
        }

        /**
         * Egy gyűjthető dolog hozzáadása a listához.
         * @param collectible a gyűjtető dolog
         */
        public void addCollectible(T collectible) {
            data.add(collectible);
            fireTableDataChanged();
        }

        /**
         * A gyűjtető dolgokat tároló lista üressé tétele.
         */
        public void clearData() {
            data.clear();
            fireTableDataChanged();
        }

        /**
         * Beállítja az oszlopok nevét.
         */
        @Override
        public String getColumnName(int column) {
            if (column == 0) {
                return name;
            }
            return null;
        }

        /**
         * Visszaadja az adott oszlop típusát.
         */
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 0) {
                return String.class;
            }
            return null;
        }

        /**
         * Visszaadja a sorok számát.
         */
        @Override
        public int getRowCount() {
            return data.size();
        }

        /**
         * Visszaadja az oszlopok számát.
         */
        @Override
        public int getColumnCount() {
            return 1;
        }
        /**
         * Visszaadja a két index-szel megadott cellán lévő elemet.
         */
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return data.get(rowIndex).toString();
            }
            return null;
        }

    }

    /** 
     * Az éppen aktív virológusnál lévő védőfelszereléseket megjelenítő táblázat 
     */
    private JTable equipmentTable;

    /**
     * Az éppen aktív virológus felszereléseit tároló adathalmaz.
     */
    private CollectibleData<Equipment> equipmentData;

    /** 
     * Az éppen aktív virológusnál lévő ágenseket megjelenítő táblázat 
     */
    private JTable agentTable;

    /**
     * Az éppen aktív virológus ágenseit tároló adathalmaz.
     */
    private CollectibleData<Agent> agentData;

    /** 
     * Az éppen aktív virológuson lévő hatásokat megjelenítő táblázat 
     */
    private JTable effectTable;

    /**
     * Az éppen aktív virológuson lévő hatásokat tároló adathalmaz.
     */
    private CollectibleData<Effect> effectData;

    /**
     * Beállítja a panel elrendezését, majd beállítja a táblázatok kezdőértékét.
     */
    public InventoryPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        initializeMaterialTable();
        initializeGeneticCodeTable();
        initializeEquipmentTable();
        initializeAgentTable();
        initializeEffectTable();
    }

    /**
     * Beállítja a "materials" táblázat kezdőértékét. 
     */
    private void initializeMaterialTable() {
        String[][] data = {
            {"Aminoacid", ""},
            {"Nucleotide", ""}
        };
        String[] columnNames = {"Material type", "Amount"};
        materialTable = new JTable(data, columnNames);
        materialTable.setDefaultEditor(Object.class, null);
        materialTable.setRowSelectionAllowed(false);
        add(new JScrollPane(materialTable));
    }

    /**
     * Beállítja a "geneticCodeTable" táblázat kezdőértékét. 
     */
    private void initializeGeneticCodeTable() {
        geneticCodeData = new GeneticCodeData();
        geneticCodeData.addGeneticCode(ChoreaVirusGene.getInstance());
        geneticCodeData.addGeneticCode(MemoryLossVirusGene.getInstance());
        geneticCodeData.addGeneticCode(ParalyzingVirusGene.getInstance());
        geneticCodeData.addGeneticCode(VaccineGene.getInstance());

        geneticCodeTable = new JTable(geneticCodeData);
        geneticCodeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        geneticCodeTable.setDefaultEditor(Object.class, null);
        add(new JScrollPane(geneticCodeTable));
    }

    /** 
     * Beállítja az "equipmentTable" táblázat kezdőértékét.
    */
    private void initializeEquipmentTable() {
        equipmentData = new CollectibleData<>("Equipment");

        equipmentTable = new JTable(equipmentData);
        equipmentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        equipmentTable.setDefaultEditor(Object.class, null);
        add(new JScrollPane(equipmentTable));
    }

    /** 
     * Beállítja az "agentTable" táblázat kezdőértékét.
    */
    private void initializeAgentTable() {
        agentData = new CollectibleData<>("Agents");

        agentTable = new JTable(agentData);
        agentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        agentTable.setDefaultEditor(Object.class, null);
        add(new JScrollPane(agentTable));
    }

    /** 
     * Beállítja az "effectTable" táblázat kezdőértékét.
    */
    private void initializeEffectTable() {
        effectData = new CollectibleData<>("Effects");

        effectTable = new JTable(effectData);
        effectTable.setRowSelectionAllowed(false);
        effectTable.setDefaultEditor(Object.class, null);
        add(new JScrollPane(effectTable));
    }

    /**
     * Beállítja a "materialTable" táblázat "aminoacid" értékét.
     * @param value az aminoacid új értéke
     */
    public void setAminoAcidValue(Integer value) {
        materialTable.setValueAt(value.toString(), 0, 1);
    }

    /**
     * Beállítja a "materialTable" táblázat "nucleotide" értékét.
     * @param value a nukleotid új értéke
     */
    public void setNucleotideValue(Integer value) {
        materialTable.setValueAt(value.toString(), 1, 1);
    }

    /**
     * Beállítja a "geneticCodeTable" táblázatbana a genetikai kód összegyűjtöttségét a kapott értékre.
     * @param gc a genetikai kód
     * @param collected az összegyűjtöttség értéke
     */
    public void setGeneticCodeCollected(GeneticCode gc, boolean collected) {
        geneticCodeData.setGeneticCodeCollection(gc, collected);
    }

    /**
     * Visszaadja az éppen kiválasztott genetikai kódot, null-t, ha nincs egy sem kiválasztva.
     * @return kiválasztott genetikai kód/null
     */
    public GeneticCode getSelectedGeneticCode() {
        int i = geneticCodeTable.getSelectedRow();
        if (i == -1) return null;
        return geneticCodeData.getGeneticCode(i);
    }

    /**
     * Hozzáadja a kapott felszerelést az "equipmentTable" táblázathoz. 
     * @param e a kapott felszerelés
     */
    public void addEquipment(Equipment e) {
        equipmentData.addCollectible(e);
    }

    /**
     * Visszaadja az éppen kiválasztott felszerelés id-jét, vagy "-1"-et, ha nincs egy sem kiválasztva.
     * @return kiválasztott felszerelés id-je/-1
     */
    public int getSelectedEquipmenntID() {
        int i = equipmentTable.getSelectedRow();
        if (i == -1) return i;
        else return equipmentData.getCollectible(i).getId();
    }

    /**
     * Kiüríti az "equipmentTable" táblázatot.
     */
    public void clearEquipment() {
        equipmentData.clearData();
    }

    /**
     * Hozzáadja a kapott ágenst az "agentTable" táblázathoz. 
     * @param a a kapott ágens
     */
    public void addAgent(Agent a) {
        agentData.addCollectible(a);
    }

    /**
     * Visszaadja az éppen kiválasztott ágens id-jét, vagy "-1"-et, ha nincs egy sem kiválasztva.
     * @return kiválasztott ágens id-je/-1
     */
    public int getSelectedAgentID() {
        int i = agentTable.getSelectedRow();
        if (i == -1) return i;
        else return agentData.getCollectible(i).getId();
    }

    /**
     * Kiüríti az "agentTable" táblázatot.
     */
    public void clearAgents() {
        agentData.clearData();
    }

    /**
     * Hozzáadja a kapott hatást az "effectTable" táblázathoz. 
     * @param e a kapott hatás
     */
    public void addEffect(Effect e) {
        effectData.addCollectible(e);
    }

    /**
     * Kiüríti az "effectTable" táblázatot.
     */
    public void clearEffects() {
        effectData.clearData();
    } 
}
