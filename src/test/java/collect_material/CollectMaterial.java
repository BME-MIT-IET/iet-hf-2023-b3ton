package collect_material;
import projlab.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;

public class CollectMaterial {
    private Virologist virologist;
    private Storage storage;
    private Equipment equipment;
    private Effect effect;

    @Given("a Virologist")
    public void createVirologist() {
        virologist = new Virologist();
    }

    @Given("^a Storage$")
    public void createStorage() {
        storage = new Storage();
    }

    @Given("^a Timed Chorea Effect lasting for (\\d+) seconds$")
    public void createTimedChoreaEffect(int duration) {
        effect = new TimedChoreaEffect(duration);
    }

    @Given("^the Virologist is at the Storage$")
    public void virologistIsAtStorage() {
        virologist.moveTo(storage);
    }

    @Given("^the Virologist has the Timed Chorea Effect$")
    public void virologistHasTimedChoreaEffect() {
        virologist.addEffectBy(effect, null);
    }

    @Given("^the Virologist has the Gloves Equipment$")
    public void virologistHasGlovesEquipment() {
        virologist.addEquipment(equipment);
    }

    @Given("^the Virologist has the Sack Equipment$")
    public void virologistHasSackEquipment() {
        virologist.addEquipment(equipment);
    }

    @Given("^the Storage contains (\\d+) Amino Acids$")
    public void setAminoAcids(int aminoAcids) {
        storage.setAminoAcid(aminoAcids);
    }

    @Given("^the Storage contains (\\d+) Nucleotides$")
    public void setNucleotides(int nucleotides) {
        storage.setNucleotide(nucleotides);
    }

    @Given("^a pair of Gloves Equipment$")
    public void createGlovesEquipment() {
        equipment = new GlovesEquipment();
    }

    @Given("^a Sack Equipment$")
    public void createSackEquipment() {
        equipment = new SackEquipment();
    }

    @When("^the Virologist collects from the field$")
    public void virologistCollectsFromField() {
        virologist.collectFromField();
    }

    @Then("^the Virologist should collect (\\d+) Nucleotides$")
    public void verifyCollectedNucleotides(int expectedNucleotides) {
        assertEquals(expectedNucleotides, virologist.getNucleotide());
    }

    @Then("^the Virologist should successfully collect (\\d+) Nucleotides with the sack$")
    public void verifyCollectedNucleotidesWithSack(int expectedNucleotides) {
        assertEquals(expectedNucleotides, virologist.getNucleotide());
    }
}
