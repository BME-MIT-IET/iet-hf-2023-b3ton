package projlab;

/**
 * Aminosavakból és nukleotidokból hozza létre egy Virologist az akciója keretén belül.
 * Van egy GeneticCodeja, amiből kiolvasható, hogy mennyi aminosav és nukleotid szükséges
 * az előállításukhoz, a Virologist csak akkor tudja létrehozni, ha rendelkezik elegendő
 * mennyiségű nyersanyaggal. Több típusa van, lehet vakcina, vagy különböző féle vírus.
 * A Virologist  saját magára, vagy más Virologistra felhasználhatja, elbomlásáig
 * valamiféle hatással van a Virologistra, akire felhasználták.
 */
public abstract class Agent implements Timed {
    protected static int decomposeTime = 5;
    protected int timeLeft = decomposeTime;
    protected final int id;

    protected Agent(){
        id = Controller.getNewId();
    }
    /**
     * Idő telése.
     * Minden hívásra csökkenti a hátralévő időt.
     * @return true, ha a hatódiő lejárt, egyébként false.
     */
    @Override
    public boolean timePasses() {
        --timeLeft;
        return timeLeft <= 0;
    }

    /**
     * A Virologist osztály useAgentOn(v: Virologist, a: Agent) függvénye hívja meg.
     * Létrehoz az osztálynak megfelelő Effect-et, majd meghívja az ‘on’ Virologist
     * addEffectBy(e: Effect, v: Virologist) függvényét a létrejött Effect-et és a ‘by’
     * Virologist-ot paraméterként átadva. Absztrakt függvény, az Effect létrehozás
     * az egyes leszármazottakban van implementálva.
     * @param on Virologist, amire kenjük az ágenst
     * @param by Virologist, aki keni az ágenst
     */
    public abstract void useOnBy(Virologist on, Virologist by);

    /**
     * Visszaadja az ágens azonosítóját
     * @return az ágens azonosítója
     */
    public int getId(){
        return id;
    }
}