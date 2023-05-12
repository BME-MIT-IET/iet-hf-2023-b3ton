package projlab.tests;

import projlab.*;

/**
 * TESZT: Egy Virologist lopni próbál egy másik bénult virológustól.
 * Létrehoz két virológust és két TimedEffect-et. Ezek közül az egyik bénultságot okoz.
 * Hozzáadja az egyik virológushoz az effekteket, majd meghívja a lopás függvényét.
 */
public class StealEquipmentFromParalyzedVirologistTest extends Test {

    public StealEquipmentFromParalyzedVirologistTest() {
        super("StealEquipmentFromParalyzedVirologist");
    }

    @Override
    public void execute() {
       /**
        * Ezt írja le a use case-hez tartozó kommunkációs diagram
        */
        Virologist v1 = new Virologist();
        Virologist v2 = new Virologist();
        TimedChoreaEffect e1 = new TimedChoreaEffect(10);
        TimedParalyzingEffect e2 = new TimedParalyzingEffect(10);
        v2.addEffectBy(e1, null);
        v2.addEffectBy(e2, null);

        /**
         * Ezt írja le a use case-hez tartozó szekvenciadiagram
         */
        v1.stealFrom(v2);
    }
    
}
