import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"./src/main/resources/"},
        glue = {"steps"},
        plugin ={"until.AllureReporter",}
)
public class CucumberRunner {
}