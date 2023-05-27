package use_chorea;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/UseChorea.feature"},
        glue = {"use_chorea"}
)
public class UseChoreaTest {
}
