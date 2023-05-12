package projlab.tests;

import projlab.*;

/**
 * TESZT: A Virologist létrehoz egy Vaccine ágenst.
 * Létrehoz egy Virologist-et és hozzáadja a VaccineGene-t. Ezután átadja a
 * Virologist-nak a szükséges aminosavat és nuclotidot, és meghívja az ágens
 * létrehozó függvényét.
 */
public class CreateVaccineTest extends Test {

    public CreateVaccineTest() {
        super("CreateVaccine");
    }

    @Override
    public void execute() {
        /**
         * Ezt írja le a use case-hez tartozó kommunkációs diagram
         */
        Virologist v = new Virologist();
        VaccineGene vg = new VaccineGene();
        v.addGeneticCode(vg);

        // VÁLTOZTATÁS: A Virologist-nak átadjuk a szükséges alapanyagokat
        v.addAminoAcid(3);
        v.addNucleotide(2);

        /**
         * Ezt írja le a use case-hez tartozó szekvenciadiagram
         */
        v.createAgent(vg);
    }
}
