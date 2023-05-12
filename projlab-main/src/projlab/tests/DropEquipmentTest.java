package projlab.tests;

import projlab.*;

/**
 * TESZT: Equipment eldobása.
 */
public class DropEquipmentTest extends Test{

    public DropEquipmentTest(){
        super("DropEquipment");
    }

    @Override
    public void execute() {
        /**
         * Ezt írja le a use case-hez tartozó kommunkációs diagram
         */
        Virologist v = new Virologist();
        SackEquipment e = new SackEquipment();
        v.addEquipment(e);

        /**
         * Ezt írja le a use case-hez tartozó szekvenciadiagram
         */
        
         v.dropEquipment(e);

    }
    
}
