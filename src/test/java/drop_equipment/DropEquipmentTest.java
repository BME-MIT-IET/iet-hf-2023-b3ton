package drop_equipment;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/DropEquipment.feature"},
        glue = {"drop_equipment"}
)
public class DropEquipmentTest {
}
