package pl.edu.pjatk.tau.lab5Test;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import pl.edu.pjatk.tau.lab4Test.pages.CreateAccountPage;
import pl.edu.pjatk.tau.lab4Test.pages.HomePage;
import pl.edu.pjatk.tau.lab4Test.pages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by maciek on 03.12.17.
 */
public class LogFailSteps {
    private static WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private CreateAccountPage createAccount;

        @Before
        public void setUp() {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setJavascriptEnabled(true);
            caps.setCapability("takesScreenshot", true);
            caps.setCapability(
                    PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                    "src/test/java/pl/edu/pjatk/tau/lab5Test/phantomjs"
            );
            driver = new PhantomJSDriver(caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().setSize(new Dimension(1400,1000));
            homePage = new HomePage(driver);
            loginPage = new LoginPage(driver);
        }

        @Given("^there is url to page$")
        public void there_is_url_to_page() throws Throwable {
                driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

            }


        @When("^i use name \"([^\"]*)\" and  password \"([^\"]*)\" in form$")
        public void i_use_name_and_password_in_form(String name, String password) throws Throwable {
            loginPage.SetEmail(name);
            loginPage.SetPassword(password);
            loginPage.LoginButtonClick();
        }

        @Then("^we click login button and we shouldn't login to page$")
        public void we_click_login_button_and_we_shouldn_t_login_to_page() throws Throwable {
            Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]")).isDisplayed());
        }
    @AfterClass
    public static void cleanp() {
        driver.quit();
    }
    }


