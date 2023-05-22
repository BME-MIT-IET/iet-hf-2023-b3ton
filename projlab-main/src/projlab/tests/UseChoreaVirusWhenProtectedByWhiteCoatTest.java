package projlab.tests;

import projlab.*;

/**
 * TESZT: A virológus vitustánc vírust ken a másik virológusra, viszont ezt kivédi a védőköpeny.
 * Létrehoz két virológust, egy ChoreaVirus-t, egy SackEquipment-et és egy WhiteCoatEquipment-et.
 * Hozzáadja mindkét felszerelést az egyik virológushoz, majd erre a virológusra megpróbál
 * vítustánc vírust kenni.
 */
public class UseChoreaVirusWhenProtectedByWhiteCoatTest extends Test {

    public UseChoreaVirusWhenProtectedByWhiteCoatTest() {
        super("UseChoreaVirusWhenProtectedByWhiteCoat");
    }

    @Override
    public void execute() {
        /**
         * Ezt írja le a use case-hez tartozó kommunkációs diagram
         **/
        Virologist v1 = new Virologist();
        Virologist v2 = new Virologist();
        ChoreaVirus c = new ChoreaVirus();
        SackEquipment e = new SackEquipment();
        v2.addEquipment(e);
        WhiteCoatEquipment e2 = new WhiteCoatEquipment();
        v2.addEquipment(e2);
        /**
         * Ezt írja le a use case-hez tartozó szekvenciadiagram
         */
        c.useOnBy(v2, v1);
    }
    
}
