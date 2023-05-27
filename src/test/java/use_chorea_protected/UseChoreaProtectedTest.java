package use_chorea_protected;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/UseChoreaWhenProtected.feature"},
        glue = {"use_chorea_protected"}
)
public class UseChoreaProtectedTest {
}
