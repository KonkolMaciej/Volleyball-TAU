package pl.edu.pjatk.tau.lab5Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by maciek on 03.12.17.
 */
public class BrowserFactory {
        static WebDriver driver;
        public static WebDriver startBrowser(String browserName,String url)
        {

            if(browserName.equalsIgnoreCase("firefox"))
            {
                System.setProperty("webdriver.gecko.driver", "/home/maciek/projekty/seleniumJava/geckodriver");
                driver = new FirefoxDriver();
            }
            else if(browserName.equalsIgnoreCase("phantom"))
            {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setJavascriptEnabled(true);
                caps.setCapability("takesScreenshot", true);
                caps.setCapability(
                        PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                        "/home/maciek/projekty/seleniumJava/phantomjs"
                );
                driver = new PhantomJSDriver(caps);
            }
            else if(browserName.equalsIgnoreCase("chrome")){
                driver = new ChromeDriver();
            }
            else if(browserName.equalsIgnoreCase("IE")){
                driver = new InternetExplorerDriver();
            }
            driver.manage().window().maximize();
            driver.get(url);
            return  driver;
        }
}
