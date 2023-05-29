package scan_new_code;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/ScanNewCode.feature"},
        glue = {"scan_new_code"}
)
public class ScanNewCodeTest {
}
