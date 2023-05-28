package use_chorea;
import projlab.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
public class UseChorea {

    private Virologist virologist1;
    private Virologist virologist2;
    private ChoreaVirus choreaVirus;
    private SackEquipment sackEquipment;

    @Given("there are two virologists")
    public void thereAreTwoVirologists() {
        virologist1 = new Virologist();
        virologist2 = new Virologist();
    }

    @Given("there is a ChoreaVirus")
    public void thereIsAChoreaVirus() {
        choreaVirus = new ChoreaVirus();
    }

    @Given("there is a SackEquipment")
    public void thereIsASackEquipment() {
        sackEquipment = new SackEquipment();
    }

    @Given("the SackEquipment is added to one of the virologists")
    public void theSackEquipmentIsAddedToOneOfTheVirologists() {
        virologist2.addEquipment(sackEquipment);
    }

    @When("the ChoreaVirus is used on the other virologist by the first virologist")
    public void theChoreaVirusIsUsedOnTheOtherVirologistByTheFirstVirologist() {
        choreaVirus.useOnBy(virologist2, virologist1);
    }

    @Then("the other virologist should be infected with ChoreaVirus")
    public void theOtherVirologistShouldBeInfectedWithChoreaVirus() {
        ArrayList<Effect> effects = virologist2.getEffects();
        assertFalse(effects.isEmpty());
    }
}
