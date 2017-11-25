package pl.edu.pjatk.tau.lab4Test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by maciek on 21.11.17.
 */
public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginPage(){
        driver.findElement(By.id("SubmitCreate")).click();
    }

    public void setEmailAddress(String email) {
        driver.findElement(By.id("email_create")).sendKeys(email);
    }

    public void goToCreateAccountPage() {
        driver.findElement(By.id("SubmitCreate")).click();
    }
    public void SetEmail(String email){
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);

    }
    public void SetPassword(String password){
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(password);

    }
    public void LoginButtonClick() {
        driver.findElement(By.id("SubmitLogin")).click();

    }
    public boolean FindErrorMsg(){
        if(driver.findElement(By.partialLinkText("Authentication failed.")).isDisplayed())
            return true;
        else
            return false;
    }
}
