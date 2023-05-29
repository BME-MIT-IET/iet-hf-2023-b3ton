package scan_new_code;

import projlab.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

public class ScanNewCode {
    Virologist virologist;
    VaccineGene vaccineGene;
    Laboratory laboratory;
    boolean isInformationGained;

    @Given("^a Virologist exists$")
    public void createVirologist() {
        virologist = new Virologist();
    }

    @Given("^a VaccineGene exists$")
    public void createVaccineGene() {
        vaccineGene = new VaccineGene();
    }

    @Given("^a Laboratory exists$")
    public void createLaboratory() {
        laboratory = new Laboratory();
    }

    @Given("^the genetic code is set in the Laboratory$")
    public void setGeneticCodeInLaboratory() {
        laboratory.setGeneticCode(vaccineGene);
    }

    @When("^the Virologist moves to the Laboratory$")
    public void moveVirologistToLaboratory() {
        virologist.moveTo(laboratory);
    }

    @When("^the Virologist collects from the field$")
    public void collectFromField() {
        virologist.collectFromField();
    }

    @Then("^the Virologist gains information about the new genetic code$")
    public void checkInformationGained() {
        var geneticCodes = virologist.getGeneticCodes();
        isInformationGained = geneticCodes.contains(vaccineGene);
        // Add assertion to validate that the virologist has gained information about the new genetic code
        assertTrue(isInformationGained);
    }
}
