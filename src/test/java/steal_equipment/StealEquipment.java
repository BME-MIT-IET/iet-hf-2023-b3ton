package steal_equipment;

import projlab.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;

public class StealEquipment {
    Virologist virologist1;
    Virologist virologist2;
    GlovesEquipment glovesEquipment;
    TimedChoreaEffect choreaEffect;
    TimedParalyzingEffect paralyzingEffect;
    boolean isEquipmentStolen;

    @Given("^a Virologist exists$")
    public void createVirologist1() {
        virologist1 = new Virologist();
    }

    @Given("^another Virologist exists$")
    public void createVirologist2() {
        virologist2 = new Virologist();
    }

    @Given("^a pair of Gloves$")
    public void createGloves() {
        glovesEquipment = new GlovesEquipment();
    }

    @Given("^the second Virologist has the Gloves$")
    public void addGlovesToVirologist1() {
        virologist2.addEquipment(glovesEquipment);
    }

    @Given("^a TimedChoreaEffect exists with a duration of (\\d+)$")
    public void createChoreaEffect(int duration) {
        choreaEffect = new TimedChoreaEffect(duration);
    }

    @Given("^a TimedParalyzingEffect exists with a duration of (\\d+)$")
    public void createParalyzingEffect(int duration) {
        paralyzingEffect = new TimedParalyzingEffect(duration);
    }

    @Given("^the second Virologist is affected by the TimedChoreaEffect and TimedParalyzingEffect$")
    public void addEffectsToVirologist2() {
        virologist2.addEffectBy(choreaEffect, null);
        virologist2.addEffectBy(paralyzingEffect, null);
    }

    @When("^the first Virologist attempts to steal equipment from the second Virologist$")
    public void stealEquipment() {
        virologist1.stealFrom(virologist2);
        var virologist1Equipments = virologist1.getEquipments();
        var virologist2Equipments = virologist2.getEquipments();
        isEquipmentStolen = virologist1Equipments.containsValue(glovesEquipment) && virologist2Equipments.isEmpty();
    }

    @Then("^the first Virologist successfully steals the equipment$")
    public void checkEquipmentStolen() {
        // Add assertion to validate that the equipment was successfully stolen
        // You can use the 'isEquipmentStolen' flag to check the expected outcome
        assertTrue(isEquipmentStolen);
    }
}
