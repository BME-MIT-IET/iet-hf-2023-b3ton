package moving;
import projlab.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;

public class MoveToAnotherField {
    private Virologist virologist;
    private Field field1;
    private Field field2;

    @Given("a Virologist")
    public void createVirologist() {
        virologist = new Virologist();
    }

    @Given("two neighboring Fields")
    public void createNeighboringFields() {
        field1 = new Field();
        field2 = new Field();
        field1.setNeighbor(field2);
        field2.setNeighbor(field1);
    }

    @When("the Virologist steps into the first Field")
    public void virologistStepsIntoFirstField() {
        field1.stepIn(virologist);
    }

    @When("the Virologist moves to the second Field")
    public void virologistMovesToSecondField() {
        virologist.moveTo(field2);
    }

    @Then("the Virologist should be on the second Field")
    public void virologistShouldBeOnSecondField() {
        assertEquals(field2, virologist.getCurrentField());
    }
}