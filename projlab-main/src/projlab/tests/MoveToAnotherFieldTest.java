package projlab.tests;

import projlab.*;

/**
 * TESZT: A Virologist átlép egy másik Field-re.
 * Létrehoz két szomszédos Field-et, ráteszi a Virologist-et az egyikre és
 * meghívja a lépés függvényét a másik Field-re.
 */
public class MoveToAnotherFieldTest extends Test {

    public MoveToAnotherFieldTest() {
        super("MoveToAnotherField");
    }

    @Override
    public void execute() {
        /**
         * Ezt írja le a use case-hez tartozó kommunkációs diagram
         */
        Virologist v = new Virologist();
        Field f1 = new Field();
        Field f2 = new Field();
        f1.setNeighbor(f2);
        f2.setNeighbor(f1);
        f1.stepIn(v);

        /**
         * Ezt írja le a use case-hez tartozó szekvenciadiagram
         */
        v.moveTo(f2);
    }
}
