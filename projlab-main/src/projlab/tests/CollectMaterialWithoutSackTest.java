package projlab.tests;
import projlab.*;

/**
 * TESZT: Anyag gyűjtése zsák nélkül.
 */
public class CollectMaterialWithoutSackTest extends Test{

    public CollectMaterialWithoutSackTest(){
        super("CollectMaterialWithoutSack");
    }

    @Override
    public void execute() {
        /**
         * Ezt írja le a use case-hez tartozó kommunkációs diagram
         */

        Virologist v = new Virologist();
        Storage s = new Storage();
        TimedChoreaEffect e = new TimedChoreaEffect(10);
        GlovesEquipment e2 = new GlovesEquipment();
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
