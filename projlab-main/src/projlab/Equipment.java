package projlab;

/**
 * Absztrakt Equipment osztály a felszereléseknek.
 * A Effect osztályból származik le.
 */
public abstract class Equipment extends Effect {
    protected final int id;

    protected Equipment(){
        id = Controller.getNewId();
    }
    /**
     *  visszaadja, hogy még használható-e az adott Equipment. Alapvetőleg true-val tér vissza, 
     * de néhány leszármazott felül tudja definiálni, ilyenkor false-szal tér vissza.
     * @return használható-e az adott Equipment
     */
    public boolean stillUsable() {
        return true;
    }

    /**
     * visszaadja, hogy a felszerelés halálos-e, azaz lehet-e ölésre használni (a Virologist osztály 
     * kill(v: Virologist) függvénye). Néhány leszármazottban felül van definiálva, itt mindig false-szal 
     * tér vissza.
     * @return  a felszerelés halálos-e
     */
    public boolean lethal() {
        return false;
    }

    public int getId(){
        return id;
    }
}
