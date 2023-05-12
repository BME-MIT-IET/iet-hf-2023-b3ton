package projlab.tests;

import projlab.*;

/**
 * TESZT: A virológus vitustánc vírust ken a másik virológusra, viszont ezt kivédi a vakcina hatása.
 * Létrehoz két virológust, egy ChoreaVirus-t, egy SackEquipment-et és egy TimedProtectingEffect-et.
 * Hozzáadja az egyik felszerelést és az effectet az egyik virológushoz, majd erre a
 * virológusra megpróbál vítustánc vírust kenni.
 */
public class UseChoreaVirusWhenProtectedByVaccineTest extends Test {

    public UseChoreaVirusWhenProtectedByVaccineTest() {
        super("UseChoreaVirusWhenProtectedByVaccine");
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
        TimedProtectingEffect e2 = new TimedProtectingEffect(10);
        v2.addEffectBy(e2, null);

        /**
         * Ezt írja le a use case-hez tartozó szekvenciadiagram
         */
        c.useOnBy(v2, v1);
    }

    
}
