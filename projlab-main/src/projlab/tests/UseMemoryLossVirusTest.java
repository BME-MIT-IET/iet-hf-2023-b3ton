package projlab.tests;

import projlab.*;

/**
 * TESZT: A virológus felejtővírust ken a másik virológusra.
 * Létrehoz két virológust, egy MemoryLossVirus-t és egy SackEquipment-et.
 * Hozzáadja a felszerelést és az egyik virológushoz, majd erre a
 * virológusra megpróbál a másik felejtővírust kenni.
 */
public class UseMemoryLossVirusTest extends Test {

    public UseMemoryLossVirusTest() {
        super("UseMemoryLossVirus");
    }

    @Override
    public void execute() {
        /**
         * Ezt írja le a use case-hez tartozó kommunkációs diagram
         */
        Virologist v1 = new Virologist();
        Virologist v2 = new Virologist();
        MemoryLossVirus m = new MemoryLossVirus();
        SackEquipment e = new SackEquipment();
        v2.addEquipment(e);

        /**
         * Ezt írja le a use case-hez tartozó szekvenciadiagram
         */
        m.useOnBy(v2, v1);
    }
}
