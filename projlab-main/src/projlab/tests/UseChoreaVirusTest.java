package projlab.tests;

import projlab.*;

/**
 * TESZT: A virológus vitustánc vírust ken a másik virológusra.
 * Létrehoz két virológust, egy ChoreaVirus-t és egy SackEquipment-et.
 * Hozzáadja a felszerelést és az egyik virológushoz, majd erre a
 * virológusra megpróbál a másik vítustánc vírust kenni.
 */
public class UseChoreaVirusTest extends Test {

    public UseChoreaVirusTest() {
        super("UseChoreaVirus");
    }

    @Override
    public void execute() {
        /**
         * Ezt írja le a use case-hez tartozó kommunkációs diagram
         */
        Virologist v1 = new Virologist();
        Virologist v2 = new Virologist();
        ChoreaVirus c = new ChoreaVirus();
        SackEquipment e = new SackEquipment();
        v2.addEquipment(e);

        /**
         * Ezt írja le a use case-hez tartozó szekvenciadiagram
         */
        c.useOnBy(v2, v1);
    }
}
