package pl.edu.pjatk.tau.lab3Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by maciek on 13.11.17.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber"},
        features = "src/test/java/pl/edu/pjatk/tau/lab3Test/resources/cucumber/CreateAndDelete.feature"
)

public class RunCreateAndDeleteTest {

}
