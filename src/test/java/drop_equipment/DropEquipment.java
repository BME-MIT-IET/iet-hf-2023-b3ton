package drop_equipment;
import projlab.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.TreeMap;

import static org.junit.Assert.assertFalse;
public class DropEquipment {
    private Virologist virologist;
    private SackEquipment sackEquipment;
    private int equipmentId;

    @Given("a Virologist")
    public void createVirologist() {
        virologist = new Virologist();
    }

    @Given("a SackEquipment")
    public void createSackEquipment() {
        sackEquipment = new SackEquipment();
    }

    @When("the Virologist adds the SackEquipment")
    public void addEquipment() {
        virologist.addEquipment(sackEquipment);
        equipmentId = virologist.getEquipments().lastKey();
    }

    @When("the Virologist drops the SackEquipment")
    public void dropEquipment() {
        virologist.dropEquipment(sackEquipment);
    }

    @Then("the Virologist should no longer have the SackEquipment")
    public void verifyEquipmentDropped() {
        TreeMap<Integer, Equipment> equipments = virologist.getEquipments();
        assertFalse(equipments.containsKey(equipmentId));
    }
}

