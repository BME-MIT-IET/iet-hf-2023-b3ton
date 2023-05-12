package projlab;

/**
 * Egyfajta Agent: amelyik Virologistra felhasználják, arra érvényesül a TimedMemoryLossEffect.
 * A felejtővírust  reprezentáló osztály. Egy másik Virologist-re lehet kenni +useOnBy(on: Virologist, by: Virologist): void függvénnyel.
 *  Alapesetben a Virologist useAgentOn(v: Virologist, a: Agent) függvény hívja meg, ami ezután törli a Virologist ágensei közül.
 */
public class MemoryLossVirus extends Agent {
    /**
     * Létrehoz egy TimedMemoryLossEffect objektumot, majd meghívja a paraméterként kapott
     * (on) Virologist addEffectBy(e: Effect, v: Virologist) függvényét
     * (a létrehozott objektummal és a ‘by’ kapott Virologist-tal), és amennyiben
     * az igazzal tér vissza (azaz a hatást sikerült rátenni), meghívja az ‘on’
     * Virologist forgetGeneticCodes() függvényét.
     * @param on Virologist, amire kenjük az ágenst
     * @param by Virologist, aki keni az ágenst
     */
    @Override
    public void useOnBy(Virologist on, Virologist by) {
        Skeleton.printMethodCall(toString(), "useOnBy(Virologist on, Virologist by)", true, null);
        TimedMemoryLossEffect tmle = new TimedMemoryLossEffect(timeLeft);
        boolean added = on.addEffectBy(tmle, by);
        if (added) {
            on.forgetGeneticCodes();
        }
        Skeleton.printMethodCall(toString(), "useOnBy(Virologist on, Virologist by)", false, null);
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "MemoryLossVirus"
     */
    @Override
    public String toString() {
        return "MemoryLossVirus(" + timeLeft + ")";
    }
}