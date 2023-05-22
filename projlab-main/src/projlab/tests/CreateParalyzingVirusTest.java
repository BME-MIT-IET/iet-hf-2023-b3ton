package projlab.tests;

import projlab.*;

/**
 * TESZT: A Virologist létrehoz egy ParalyzingVirus ágenst.
 * Létrehoz egy Virologist-et és hozzáadja a ParalyzingVirusGene-t. Ezután
 * átadja a Virologist-nak a szükséges aminosavat és nuclotidot, és meghívja az
 * ágens létrehozó függvényét.
 */
public class CreateParalyzingVirusTest extends Test {

    public CreateParalyzingVirusTest() {
        super("CreateParalyzingVirus");
    }

    @Override
    public void execute() {
        /**
         * Ezt írja le a use case-hez tartozó kommunkációs diagram
         */
        Virologist v = new Virologist();
        ParalyzingVirusGene pvg = ParalyzingVirusGene.getInstance(); // a kommunikációs diagramon konstrukor hívás volt, a singleton megoldásban ez a getInstance() függvényhívással helyettíthető.
        v.addGeneticCode(pvg);

        // VÁLTOZTATÁS: A Virologist-nak átadjuk a szükséges alapanyagokat
        v.addAminoAcid(2);
        v.addNucleotide(3);

        /**
         * Ezt írja le a use case-hez tartozó szekvenciadiagram
         */
        v.createAgent(pvg);
    }
}
