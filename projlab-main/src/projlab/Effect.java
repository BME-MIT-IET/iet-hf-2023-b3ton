package projlab;

/**
 * Absztrakt Effect osztály a hatások reprezentálására.
 * Vissza tudja adni, hogy milyen hatásai vannak.
 */
public abstract class Effect implements Timed {
    /**
     * Ellenállás az ágenseknek.
     * Visszaadja, hogy a Virologist-ra, akin ez a hatás van, kenhetőek-e más
     * ágensek.
     * 
     * @return false, mert az absztrakt Effect-nek nincsen hatása
     */
    public boolean resist() {
        Skeleton.printMethodCall(toString(), "resist()", true, null);
        Boolean defaultResist = false;
        Skeleton.printMethodCall(toString(), "resist()", false, defaultResist.toString());
        return defaultResist;
    }

    /**
     * Bénultság hatás.
     * Visszaadja, hogy a Virologist, akin ez a hatás van, bénult-e.
     * 
     * @return false, mert az absztrakt Effect-nek nincsen hatása
     */
    public boolean paralyzed() {
        Skeleton.printMethodCall(toString(), "paralyzed()", true, null);
        Boolean defaultParalyzed = false;
        Skeleton.printMethodCall(toString(), "paralyzed()", false, defaultParalyzed.toString());
        return defaultParalyzed;
    }

    /**
     * Vítusánc hatás.
     * Visszaadja, hogy Virologist, akin ez a hatás van, vítustáncot jár-e.
     * 
     * @return false, mert az absztrakt Effect-nek nincsen hatása
     */
    public boolean hasChorea() {
        Skeleton.printMethodCall(toString(), "hasChorea()", true, null);
        Boolean defaultHasChorea = false;
        Skeleton.printMethodCall(toString(), "hasChorea()", false, defaultHasChorea.toString());
        return defaultHasChorea;
    }

    /**
     * Több anyagtárolási képesség.
     * Visszaadja, hogy Virologist, akin ez a hatás van, képes-e több anyagot
     * magánál tartani.
     * 
     * @return false, mert az absztrakt Effect-nek nincsen hatása
     */
    public double moreMaterial() {
        Skeleton.printMethodCall(toString(), "moreMaterial()", true, null);
        Double defaultMoreMaterial = 1.0;
        Skeleton.printMethodCall(toString(), "moreMaterial()", false, defaultMoreMaterial.toString());
        return defaultMoreMaterial;
    }

    /**
     * Visszaverés hatás
     * Visszaadja, hogy Virologist, akin ez a hatás van, vissza tudja-e verni az
     * ágenseket a küldőjére.
     * 
     * @return false, mert az absztrakt Effect-nek nincsen hatása
     */
    public boolean reflect() {
        Skeleton.printMethodCall(toString(), "reflect()", true, null);
        Boolean defaultReflect = false;
        Skeleton.printMethodCall(toString(), "reflect()", false, defaultReflect.toString());
        return defaultReflect;
    }

    /**
     * visszaadja, hogy a hatás viselője tombol-e, azaz elpusztítja-e az összes útjába kerülő Storage-ban az nyersanyagokat. 
     * Néhány leszármazottban felül van definiálva, itt mindig false-szal tér vissza.
     * @return tombolni kezd-e
     */
    public boolean rampage() {
        Skeleton.printMethodCall(toString(), "rampage()", true, null);
        Boolean defaultDestroy = false;
        Skeleton.printMethodCall(toString(), "rampage()", false, defaultDestroy.toString());
        return defaultDestroy;
    }

    /**
     * visszaadja egy Agent-et, amit a hatás viselője a többi Virologist-ra terjeszt. Néhány leszármazottban felül 
     * van definiálva, itt mindig null-t ad vissza (alapból a hatás nem terjed).
     * @return a vírus, amit terjeszt, null esetén semmit
     */
    public Agent spreads() {
        Skeleton.printMethodCall(toString(), "spreads()", true, null);
        Skeleton.printMethodCall(toString(), "spreads()", false, "null");
        return null;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "Effect"
     */
    @Override
    public String toString() {
        return "Effect";
    }

    /**
     * Idő telése. Amelyik Effectnél nem számít az idő, ott csak false-al tér vissza.
     * @return false, leszármazottakban, ha szükséges, felül lett definiálva.
     */
    @Override
    public boolean timePasses() {
        return false; 
    }
}
