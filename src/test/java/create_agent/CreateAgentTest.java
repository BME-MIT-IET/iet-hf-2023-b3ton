package create_agent;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/CreateAgent.feature"},
        glue = {"create_agent"}
)
public class CreateAgentTest {

}
