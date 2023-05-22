package projlab;

import java.util.Set;

/**
 * A Field és leszármazottjai megjelenítéséért felelős.
 */
public class FieldView implements View{

    /**
     * A Field, amit a draw() függvénnyel ki fog rajzolni.
     */
    private Field field;
    /**
     * Singleton objektum, ha már létezik, akkor visszaadunk rá egy referenciát.
     */
    private static FieldView instance = null;

    /**
     * Lekérdezi a Field értékeit és beállítja azokat a Canvas-on
     */
    @Override
    public void draw() {
        Set<Field> neighbors = field.getNeighbors();
        Set<Virologist> virologists = field.getVirologists();
        Canvas canvas = Canvas.getInstance();

        canvas.clearNeighborFields();
        canvas.clearVirologists();

        for (Field f : neighbors) {
            canvas.addNeighborField(f);
        }

        for (Virologist v : virologists) {
            canvas.addVirologist(v.getId());
        }

        canvas.setCurrentField(field.toString());
    }

    /**
     * Visszaadja a játékban szereplő FieldView objektumot (mivel singleton osztály).
     * @return FieldView
     */
    public static FieldView getInstance() {
        if (instance == null) {
            instance = new FieldView();
        }

        return instance;
    }
    
    /**
     * Beállítja azt a Field-et, amit a draw() metódussal ki fog rajzolni.
     * @param f - beállítandó Field
     */
    public void setField(Field f) {
        field = f;
    }
}
