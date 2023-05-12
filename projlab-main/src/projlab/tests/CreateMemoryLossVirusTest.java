package projlab.tests;

import projlab.*;

/**
 * TESZT: A Virologist létrehoz egy MemoryLossVirus ágenst.
 * Létrehoz egy Virologist-et és hozzáadja a MemoryLossVirusGene-t. Ezután
 * átadja a Virologist-nak a szükséges aminosavat és nuclotidot, és meghívja az
 * ágens létrehozó függvényét.
 */
public class CreateMemoryLossVirusTest extends Test {

    public CreateMemoryLossVirusTest() {
        super("CreateMemoryLossVirus");
    }

    @Override
    public void execute() {
        /**
         * Ezt írja le a use case-hez tartozó kommunkációs diagram
         */
        Virologist v = new Virologist();
        MemoryLossVirusGene mvg = MemoryLossVirusGene.getInstance(); // a kommunikációs diagramon konstrukor hívás volt, a singleton megoldásban ez a getInstance() függvényhívással helyettíthető.
        v.addGeneticCode(mvg);

        // VÁLTOZTATÁS: A Virologist-nak átadjuk a szükséges alapanyagokat
        v.addAminoAcid(2);
        v.addNucleotide(2);

        /**
         * Ezt írja le a use case-hez tartozó szekvenciadiagram
         */
        v.createAgent(mvg);
    }
}
