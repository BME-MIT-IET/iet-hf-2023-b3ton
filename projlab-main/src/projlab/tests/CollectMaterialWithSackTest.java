package projlab.tests;

import projlab.*;

/**
 * TESZT: Anyag gyűjtése zsákkal.
 */
public class CollectMaterialWithSackTest extends Test {

    public CollectMaterialWithSackTest(){
        super("CollectMaterialWithSack");
        
    }

    @Override
    public void execute() {
        /**
         * Ezt írja le a use case-hez tartozó kommunkációs diagram
         */
        Virologist v = new Virologist();
        Storage s = new Storage();
        TimedChoreaEffect e = new TimedChoreaEffect(10);
        SackEquipment e2 = new SackEquipment();
        v.moveTo(s);
        v.addEffectBy(e, null);
        v.addEquipment(e2);

        // VÁLTOZTATÁS: A Storage-nak átadjuk a bentlévő anyagokat
        s.setAminoAcid(10);
        s.setNucleotide(15);

        /**
         * Ezt írja le a use case-hez tartozó szekvenciadiagram
         */ 

         v.collectFromField();
    }
    
}
