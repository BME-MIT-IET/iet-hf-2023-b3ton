package projlab;

/**
 * Egyfajta Agent: amelyik Virologistra felhasználják, arra érvényesül a TimedParalyzingEffect.
 * A bénítóvírust reprezentáló osztály. Egy másik Virologist-re lehet kenni +useOnBy(on: Virologist, by: Virologist): void függvénnyel. 
 * Alapesetben a Virologist useAgentOn(v: Virologist, a: Agent) függvény hívja meg, ami ezután törli a Virologist ágensei közül.
 */
public class ParalyzingVirus extends Agent {

    /**
     * Létrehoz egy TimedParalyzingVirus objektumot, majd meghívja az ‘on’
     * Virologist addEffectBy(e: Effect, v: Virologist) függvényét a létrejött
     * TimedParalyzingEffect-et és a ‘by’ Virologist-ot paraméterként átadva.
     * @param on Virologist, amire kenjük az ágenst
     * @param by Virologist, aki keni az ágenst
     */
    @Override
    public void useOnBy(Virologist on, Virologist by) {
        Skeleton.printMethodCall(toString(), "useOnBy(Virologist on, Virologist by)", true, null);
        TimedParalyzingEffect tpe = new TimedParalyzingEffect(timeLeft);
        on.addEffectBy(tpe, by);
        Skeleton.printMethodCall(toString(), "useOnBy(Virologist on, Virologist by)", false, null);
    }
    
    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "ParalyzingVirus"
     */
    @Override
    public String toString() {
        return "ParalyzingVirus(" + timeLeft + ")";
    }
}