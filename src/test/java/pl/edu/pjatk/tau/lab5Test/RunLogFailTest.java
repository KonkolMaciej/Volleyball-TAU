package pl.edu.pjatk.tau.lab5Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by maciek on 03.12.17.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber"},
        features = "src/test/java/pl/edu/pjatk/tau/lab5Test/resources/cucumber/LoginFail.feature"
)

public class RunLogFailTest {
}
