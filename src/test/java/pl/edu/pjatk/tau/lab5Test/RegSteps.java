package pl.edu.pjatk.tau.lab5Test;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
public class RegSteps {
    public static WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private CreateAccountPage createAcc;





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
        driver.manage().window().setSize(new Dimension(1400,1000));
//        System.setProperty("webdriver.chrome.driver", "/home/maciek/projekty/seleniumJava/chromedriver");
//        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        createAcc = new CreateAccountPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }


    @Given("^there is url to page and click to register page$")
    public void there_is_url_to_page_and_click_to_register_page() throws Throwable {
        driver.get("http://automationpractice.com/index.php");
        homePage.goToLoginPage();
        loginPage.setEmailAddress(homePage.randomString(8)+"@wp.pl");
        loginPage.goToCreateAccountPage();

    }
    @When("^I  filled \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void i_filled(String pass, String name, String surname, String city, String street) throws Throwable {
        createAcc.Password(pass);
        createAcc.CheckGender("M");
        createAcc.SetName(name);
        createAcc.SetSurname(surname);
        createAcc.SetDateOfBirth(25, 10, "1994");
        createAcc.SetStreet(street);
        createAcc.SetCountry("United States");
        createAcc.SetCity(city);
        createAcc.SetState("Alabama");
        createAcc.SetMobilePhone("505050505");
        createAcc.SetZipCode("00000");
        createAcc.submitAccountClick();


    }

    @Then("^account should be registered$")
    public void account_should_be_registered() throws Throwable {
        Assert.assertTrue(driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a")).isDisplayed()); //sign out button
        driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a")).click();
    }

}
