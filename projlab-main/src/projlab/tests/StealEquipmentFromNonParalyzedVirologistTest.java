package projlab.tests;

import projlab.*;

/**
 * TESZT: Egy Virologist lopni próbál egy másik nem bénult virológustól.
 * Létrehoz két virológust és két TimedEffect-et. Ezek közül az egyik sem okoz bénultságot.
 * Hozzáadja az egyik virológushoz az effekteket, majd meghívja a lopás függvényét.
 */
public class StealEquipmentFromNonParalyzedVirologistTest extends Test {

    public StealEquipmentFromNonParalyzedVirologistTest() {
        super("StealEquipmentFromNonParalyzedVirologist");
    }

    @Override
    public void execute() {
        /**
         * Ezt írja le a use case-hez tartozó kommunkációs diagram
         */
        Virologist v1 = new Virologist();
        Virologist v2 = new Virologist();
        TimedChoreaEffect e1 = new TimedChoreaEffect(10);
        TimedMemoryLossEffect e2 = new TimedMemoryLossEffect(10);
        v2.addEffectBy(e1, null);
        v2.addEffectBy(e2, null);

        /**
         * Ezt írja le a use case-hez tartozó szekvenciadiagram
         */
        v1.stealFrom(v2);
    }
    
}
