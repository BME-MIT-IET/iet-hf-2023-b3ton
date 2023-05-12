package projlab.tests;

import projlab.*;

/**
 * TESZT: A Virologist letapogat egy általa még nem ismert genetikai kódot.
 * Létrehoz egy Laboratory-t és ráteszi Virologist-et
 * és meghívja a begyűjtés függvényt a mezőn.
 */
public class ScanNewGeneticCodeTest extends Test {

    public ScanNewGeneticCodeTest() {
        super("ScanNewGeneticCode");
    }

    @Override
    public void execute() {
        /**
         * Ezt írja le a use case-hez tartozó kommunkációs diagram
         */
        Virologist v = new Virologist();
        VaccineGene gc = new VaccineGene();
        Laboratory l = new Laboratory();
        l.setGeneticCode(gc);
        v.moveTo(l);

        /**
         * Ezt írja le a use case-hez tartozó szekvenciadiagram
         */
        v.collectFromField();
    }

}
