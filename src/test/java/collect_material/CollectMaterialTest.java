package collect_material;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/CollectMaterial.feature"},
        glue = {"collect_material"}
)
public class CollectMaterialTest {
}
