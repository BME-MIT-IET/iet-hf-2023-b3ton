package projlab;

/**
 * Interfész a hatódővel rendelkező dolgok számára.
 * Képes az interfészt megvalósító objektumok hatóidejét csökkenteni, és jelezni, ha a hatóidejük lejárt.
 */
public interface Timed {
    /**
     * Az idő telése.
     * Adott időközönként csökkenti a Timed interfészt megvalósító objektum hatóidejét.
     * @return true, ha a hatóidő lejárt, egyébként false.
     */
    public boolean timePasses();
}
