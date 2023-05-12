package projlab;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

/**
 * Az aktális mező szomszédjait megjelenítő panel osztály.
 */
public class NeighborFieldsPanel extends JPanel {
    /**
     *  A mezőn lévő tábla nézet.
     */
    private JTable neigborFieldsTable;

    /**
     * A táblázat adattároló része.
     */
    private NeighborFieldsData neigborFieldsData;

    /**
     * A NeighborFieldPanel adattárolási egysége.
     */
    private class NeighborFieldsData extends AbstractTableModel {

        /**
         * A szomszédos mezők listában.
         */
        private List<Field> neighborFields = new ArrayList<>();

        /**
         * Visszaadja a kapott indexű mezőt a sorban.
         * @param index a kapott index
         * @return az adott indexen lévő mező
         */
        public Field getNeigborField(int index) {
            return neighborFields.get(index);
        }

        /**
         * Egy mező hozzáadása a listához.
         * @param collectible a mező
         */
        public void addNeighborField(Field neighborField) {
            neighborFields.add(neighborField);
            fireTableDataChanged();
        }

        /**
         * A mezőket tároló lista üressé tétele.
         */
        public void clearNeighborFields() {
            neighborFields.clear();
            fireTableDataChanged();
        }

        /**
         * Beállítja az oszlopok nevét.
         */
        @Override
        public String getColumnName(int column) {
            if (column == 0) {
                return "NeighborFields";
            }
            return null;
        }

        /**
         * Visszaadja a sorok számát.
         */
        @Override
        public int getRowCount() {
            return neighborFields.size();
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
                return neighborFields.get(rowIndex).toString();
            }
            return null;
        }
        
    }

    /**
     * Létrehozza a panelt az adott beállításokkal.
     */
    public NeighborFieldsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        neigborFieldsData = new NeighborFieldsData();

        neigborFieldsTable = new JTable(neigborFieldsData);
        neigborFieldsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        neigborFieldsTable.setDefaultEditor(Object.class, null);
        add(new JScrollPane(neigborFieldsTable));
    }

    /**
     * Hozzáadja a kapott mezőt a "neighborFieldTable" táblázathoz. 
     * @param f a kapott mező
     */
    public void addNeighborField(Field f) {
        neigborFieldsData.addNeighborField(f);
    }

    /**
     * Visszaadja az éppen kiválasztott mező id-jét, vagy "-1"-et, ha nincs egy sem kiválasztva.
     * @return kiválasztott mező id-je/-1
     */
    public int getSelectedNeighborFieldID() {
        int i = neigborFieldsTable.getSelectedRow();
        if (i == -1) return i;
        else return neigborFieldsData.getNeigborField(i).getId();
    }

    /**
     * Kiüríti az "neighborFieldsTable" táblázatot.
     */
    public void clearNeighborFields() {
        neigborFieldsData.clearNeighborFields();
    }
}
