package pl.edu.pjatk.tau.lab5Test;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.edu.pjatk.tau.lab4Test.pages.CreateAccountPage;
import pl.edu.pjatk.tau.lab4Test.pages.HomePage;
import pl.edu.pjatk.tau.lab4Test.pages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by maciek on 03.12.17.
 */
public class LogSteps {
    private static WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private CreateAccountPage createAccount;


    //private BrowserFactory browserFactory;
   // WebDriver driver= BrowserFactory.startBrowser("firefox");

    @Before
    public void setUp() {

//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setJavascriptEnabled(true);
//        caps.setCapability("takesScreenshot", true);
//        caps.setCapability(
//                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
//                "/home/maciek/projekty/seleniumJava/phantomjs"
//        );
//        driver = new PhantomJSDriver(caps);
        System.setProperty("webdriver.chrome.driver", "/home/maciek/projekty/seleniumJava/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1400,1000));
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }



    @Given("^there is url to webservice$")
    public void there_is_url_to_webservice() throws Throwable {
            driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

    }

    @When("^i use login \"([^\"]*)\" and password \"([^\"]*)\" in form$")
    public void i_use_login_and_password_in_form(String name, String password) throws Throwable {
        loginPage.SetEmail(name);
        loginPage.SetPassword(password);
    }

    @Then("^we should login to page$")
    public void we_should_login_to_page() throws Throwable {
        loginPage.LoginButtonClick();

        driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a")).click(); //sign out button
    }
    @AfterClass
    public static void cleanp() {
        driver.quit();
    }
}
