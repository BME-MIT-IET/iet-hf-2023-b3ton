package projlab.tests;

import projlab.*;

/**
 * TESZT:A virológus vitustánc vírust ken a másik virológusra, viszont ezt visszadobja
 * a kesztyűje segítségével a kenőre. Létrehoz két virológust, egy ChoreaVirus-t,
 * két SackEquipment-et és egy GlovesEquipment-et.
 * Hozzáadja mindhárom felszerelést az egyik virológushoz, majd erre a virológusra megpróbál
 * vítustánc vírust kenni.
 */
public class UseChoreaVirusWhenReflectedByGlovesTest extends Test {

    public UseChoreaVirusWhenReflectedByGlovesTest() {
        super("UseChoreaVirusWhenReflectedByGloves");
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
        SackEquipment e2 = new SackEquipment();
        v2.addEquipment(e2);
        GlovesEquipment e3 = new GlovesEquipment();
        v2.addEquipment(e3);
        /**
         * Ezt írja le a use case-hez tartozó szekvenciadiagram
         */
        c.useOnBy(v2, v1);
    }
    
}
