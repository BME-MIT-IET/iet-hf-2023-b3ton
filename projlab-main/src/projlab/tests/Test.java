package projlab.tests;

/**
 * Abszrakt osztály a skeleton teszteknek.
 * Van egy lekérdezhető neve, és le tud futni.
 */
public abstract class Test {
    private final String name;

    /**
     * Egyparaméteres konstruktor.
     * Létrehoz egy tesztet a megadott névvel
     * @param name megadott név
     */
    public Test(String name) {
        this.name = name;
    }

    /**
     * A teszt nevének visszaadása.
     * @return a teszt neve
     */
    public String getName()
    {
        return name;
    }

    /**
     * A teszt futtatása.
     * Absztrak függvény, a leszármazottaknak kell megvalósítaniuk.
     */
    public abstract void execute();
}
