package pl.edu.pjatk.tau.lab4Test.testcases;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import pl.edu.pjatk.tau.lab4Test.pages.CreateAccountPage;
import pl.edu.pjatk.tau.lab4Test.pages.HomePage;
import pl.edu.pjatk.tau.lab4Test.pages.LoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by maciek on 19.11.17.
 */
public class SeleniumTest {
    private static WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private CreateAccountPage createAccount;


    WebElement element;


    // 0123-456-789
    @BeforeClass
    public static void driverSetup() {
      //  System.setProperty("webdriver.chrome.driver", "/Users/kuba/Dev/chromedriver/chromedriver");
//        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "/home/maciek/projekty/seleniumJava/geckodriver");
//        driver = new FirefoxDriver();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability("takesScreenshot", true);
        caps.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                "/home/maciek/projekty/seleniumJava/phantomjs"
        );
        driver = new PhantomJSDriver(caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Before
    public void before() {
        driver.manage().window().setSize(new Dimension(1400,1000));
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        createAccount = new CreateAccountPage(driver);

    }
    @Test
    public void verifyElement() {
       driver.get("http://automationpractice.com/index.php");
        assertTrue(driver.findElement(By.cssSelector("#homeslider > li:nth-child(3) > div")).isEnabled());
        assertTrue(driver.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")).isDisplayed());
    }
    @Test
    public void ActionTask(){
        HomePage homePage = new HomePage(driver);

        homePage.bestSellersClick();
        homePage.IsElementPresent("Printed Chiffon Dress");
        assertEquals(7,homePage.getProducts().size());
        assertEquals(7,homePage.getProductsisDisplayed().size());
    }
    @Test
    public void PointThree() throws IOException {
        driver.get("http://automationpractice.com/index.php");

        homePage.goToDressesLocation();
        assertEquals(3, homePage.getDresses().size());

    }

    @Test
    public void LoginPageAndValidUrl(){
        driver.get("http://automationpractice.com/index.php");
        homePage.goToLoginPage();
        assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account",driver.getCurrentUrl());
    }

    @Test
    public void LoginPageFieldRegisterAccount(){
        driver.get("http://automationpractice.com/index.php");
        homePage.goToLoginPage();
        loginPage.setEmailAddress(homePage.randomString(6)+"@wp.pl");
        loginPage.goToCreateAccountPage();
        createAccount.submitAccountClick();
        assertTrue(createAccount.CheckErrorsValidFields());
    }

    @Test
    public void RegisterAccount(){
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        loginPage.setEmailAddress(homePage.randomString(6)+"@wp.pl");
        loginPage.goToCreateAccountPage();
        createAccount.CheckGender("M");
        createAccount.SetName("Jan");
        createAccount.SetSurname("Kowalski");
        createAccount.Password("password123");
        createAccount.SetDateOfBirth(25, 10, "1994");
        createAccount.SetStreet("fajna 22");
        createAccount.SetCountry("United States");
        createAccount.SetCity("Gdynia");
        createAccount.SetState("Alabama");
        createAccount.SetMobilePhone("505050505");
        createAccount.SetZipCode("00000");
        createAccount.submitAccountClick();
        driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a")).isDisplayed();//sign out button
        driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a")).click();
    }

    @Test
    public void LoginToAccount(){
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        loginPage.SetEmail("emailEsadasdleAs@wp.pl");
        loginPage.SetPassword("pasdsadword123");
        loginPage.LoginButtonClick();
        //valid
        loginPage.SetEmail("emailExampleAs@wp.pl");
        loginPage.SetPassword("password123");
        loginPage.LoginButtonClick();

        driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a")).click(); //sign out button


    }
    @AfterClass
    public static void cleanp() {
       driver.quit();
   }
}
