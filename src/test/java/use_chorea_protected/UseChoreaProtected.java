package use_chorea_protected;
import projlab.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
public class UseChoreaProtected {

    private Virologist virologist1;
    private Virologist virologist2;
    private ChoreaVirus choreaVirus;
    private SackEquipment sackEquipment;
    private TimedProtectingEffect protectingEffect;

    @Given("there are two Virologists")
    public void createVirologists() {
        virologist1 = new Virologist();
        virologist2 = new Virologist();
    }

    @Given("there is a ChoreaVirus")
    public void createChoreaVirus() {
        choreaVirus = new ChoreaVirus();
    }

    @Given("there is a SackEquipment")
    public void createSackEquipment() {
        sackEquipment = new SackEquipment();
    }

    @Given("there is a TimedProtectingEffect with a duration of 10")
    public void createTimedProtectingEffect() {
        protectingEffect = new TimedProtectingEffect(10);
    }

    @Given("the SackEquipment is added to one of the Virologists")
    public void addSackEquipmentToVirologist() {
        virologist2.addEquipment(sackEquipment);
    }

    @Given("the TimedProtectingEffect is added to the other Virologist")
    public void addTimedProtectingEffectToVirologist() {
        virologist2.addEffectBy(protectingEffect, null);
    }

    @When("the ChoreaVirus is used on the Virologist protected by vaccine")
    public void useChoreaVirusOnProtectedVirologist() {
        choreaVirus.useOnBy(virologist2, virologist1);
    }

    @Then("the ChoreaVirus should have no effect on the Virologist")
    public void verifyChoreaVirusEffectOnVirologist() {
        ArrayList<Effect> effects = virologist2.getEffects();
        assertEquals(1, effects.size());
    }
}