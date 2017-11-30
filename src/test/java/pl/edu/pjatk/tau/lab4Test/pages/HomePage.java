package pl.edu.pjatk.tau.lab4Test.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maciek on 19.11.17.
 */

public class HomePage {
    private  WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void bestSellersClick(){
        driver.findElement(By.className("blockbestsellers")).click();
    }
    public boolean IsElementPresent(String LinkText){
        driver.findElement(By.partialLinkText(LinkText)).getText();
        try
        {
            driver.findElement(By.partialLinkText(LinkText));
            return true;
        }
        catch (NoSuchElementException exception)
        {
            return false;
        }
    }
    public List<WebElement> getProducts() {
        return driver.findElement(By.cssSelector("#blockbestsellers")).findElements(By.tagName("li"));
    }
    public List<WebElement> getProductsisDisplayed() {
        List<WebElement> listisDisplayed = new ArrayList<>();
        List<WebElement> list = new ArrayList<>();
        list.addAll(driver.findElement(By.cssSelector("#blockbestsellers")).findElements(By.tagName("li")));
            for (int i=0 ; i < list.size() ; i++ ) {
                if(driver.findElement(By.cssSelector("#blockbestsellers")).findElement(By.tagName("li")).isDisplayed())
                    listisDisplayed.add(driver.findElement(By.cssSelector("#blockbestsellers")).findElement(By.tagName("li")));
            }
            return listisDisplayed;
        }

    public void goToDressesLocation() throws IOException {
        WebElement Dresses =
                driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"));
        Actions action = new Actions(driver);
        action.moveToElement(Dresses).build().perform();

        if (driver instanceof TakesScreenshot) {
            new Actions(driver).moveToElement(Dresses).build().perform();
            WebElement element = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > ul")));
            File f = ((TakesScreenshot) driver).
                    getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(f,
                    new File("build/homePage1.png"));

        }

    }


    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public String randomString(int len){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }


    public List<WebElement> getDresses() {
        return driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > ul")).findElements(By.tagName("li"));
    }

    public void goToLoginPage(){
        driver.findElement(By.className("login")).click();
    }
}
