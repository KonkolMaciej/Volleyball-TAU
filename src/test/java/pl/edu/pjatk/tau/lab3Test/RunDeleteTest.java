package pl.edu.pjatk.tau.lab3Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by maciek on 15.11.17.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber"},
        features = "src/test/java/pl/edu/pjatk/tau/lab3Test/resources/cucumber/Delete.feature"
)

public class RunDeleteTest {

}
