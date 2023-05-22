package projlab.tests;

import projlab.*;

/**
 * TESZT: Equipment felvétele, amikor már nincs szabad hely.
 */
public class PickUpEquipmentWhenFullTest extends Test {
    
    public PickUpEquipmentWhenFullTest(){
        super("PickUpEquipmentWhenFull");
    }

    @Override
    public void execute() {
        /**
         * Ezt írja le a use case-hez tartozó kommunkációs diagram
         */
        Virologist v = new Virologist();
        SackEquipment e0 = new SackEquipment();
        v.addEquipment(e0);
        GlovesEquipment e00 = new GlovesEquipment();
        v.addEquipment(e00);
        WhiteCoatEquipment e000 = new WhiteCoatEquipment();
        v.addEquipment(e000);
        Shelter s = new Shelter();
        SackEquipment e = new SackEquipment();
        v.moveTo(s);

        // VÁLTOZTATÁS: A Shelter megkapja a SackEquipmentet
        s.addEquipment(e);

        /**
         * Ezt írja le a use case-hez tartozó szekvenciadiagram
         */
        v.collectFromField();
    } 
    
}
