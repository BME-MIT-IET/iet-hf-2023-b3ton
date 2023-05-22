package projlab.tests;

import projlab.*;

/**
 * TESZT: Equipment felvétele, amikor még van szabad hely.
 */
public class PickUpEquipmentWhenNotFullTest extends Test {

    public PickUpEquipmentWhenNotFullTest(){
        super("PickUpEquipmentWhenNotFull");
    }

    @Override
    public void execute() {
        /**
         * Ezt írja le a use case-hez tartozó kommunkációs diagram
         */
        Virologist v = new Virologist();
        Shelter s = new Shelter();
        SackEquipment e = new SackEquipment();
        v.moveTo(s);

        // VÁLTOZTATÁS: A Shelter megkapja az Equipmentet
        s.addEquipment(e);

        /**
         * Ezt írja le a use case-hez tartozó szekvenciadiagram
         */

         v.collectFromField();
    }

    
}