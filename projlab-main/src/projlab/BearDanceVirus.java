package projlab;

/**
 * Egyfajta ágens.
 * A medvetánc-vírust reprezentáló osztály. 
 * Egy másik Virologist-re lehet kenni +useOnBy(on: Virologist, by: Virologist): void függvénnyel. 
 * A használat után nem törlődik.
 */
public class BearDanceVirus extends Agent {

    /**
     * Létrehoz egy BearDanceEffect objektumot, majd meghívja az ‘on’ Virologist 
     * addEffectBy(e: Effect, v: Virologist) függvényét a létrejött BearDanceEffect-et 
     * és a ‘by’ Virologist-ot paraméterként átadva.
     */
    @Override
    public void useOnBy(Virologist on, Virologist by) {
        Skeleton.printMethodCall(toString(), "useOnBy(Virologist on, Virologist by)", true, null);
        BearDanceEffect bde = new BearDanceEffect();
        on.addEffectBy(bde, by);
        Skeleton.printMethodCall(toString(), "useOnBy(Virologist on, Virologist by)", false, null);
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "BearDanceVirus"
     */
    @Override
    public String toString() {
        return "BearDanceVirus";
    }
}
