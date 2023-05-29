package steal_equipment;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/StealEquipment.feature"},
        glue = {"steal_equipment"}
)
public class StealEquipmentTest {
}
