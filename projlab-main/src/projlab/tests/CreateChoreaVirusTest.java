package projlab.tests;

import projlab.*;

/**
 * TESZT: A Virologist létrehoz egy ChoreaVirus ágenst.
 * Létrehoz egy Virologist-et és hozzáadja a ChoreaVirusGene-t. Ezután átadja a
 * Virologist-nak a szükséges aminosavat és nuclotidot, és meghívja az ágens
 * létrehozó függvényét.
 */
public class CreateChoreaVirusTest extends Test {

    public CreateChoreaVirusTest() {
        super("CreateChoreaVirus");
    }

    @Override
    public void execute() {
        /**
         * Ezt írja le a use case-hez tartozó kommunkációs diagram
         */
        Virologist v = new Virologist();
        ChoreaVirusGene cvg = ChoreaVirusGene.getInstance(); // a kommunikációs diagramon konstrukor hívás volt, a singleton megoldásban ez a getInstance() függvényhívással helyettíthető.
        v.addGeneticCode(cvg);

        // VÁLTOZTATÁS: A Virologist-nak átadjuk a szükséges alapanyagokat
        v.addAminoAcid(4);
        v.addNucleotide(1);

        /**
         * Ezt írja le a use case-hez tartozó szekvenciadiagram
         */
        v.createAgent(cvg);
    }
}
