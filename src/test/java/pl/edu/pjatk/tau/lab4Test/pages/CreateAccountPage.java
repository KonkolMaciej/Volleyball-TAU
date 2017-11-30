package pl.edu.pjatk.tau.lab4Test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {
    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void submitAccountClick () {
        driver.findElement(By.id("submitAccount")).click();

    }
    public boolean CheckErrorsValidFields(){
        if(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div")).isDisplayed())
            return true;
        else
            return false;

    }
    public void CheckGender(String gender){
        if(gender == "M") {
            driver.findElement(By.id("id_gender1")).click();
        }
        else
            driver.findElement(By.id("id_gender2")).click();
    }
    public void SetName(String name) {
        driver.findElement(By.id("customer_firstname")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys(name);

    }
    public void SetSurname(String surname) {
        driver.findElement(By.id("customer_lastname")).click();
        driver.findElement(By.id("customer_lastname")).sendKeys(surname);
    }
    public void Password(String password) {
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys(password);
    }
    public void SetDateOfBirth(int date, int month, String year) {
        new Select(driver.findElement(By.id("days"))).selectByIndex(date);
        new Select(driver.findElement(By.id("months"))).selectByIndex(month);
        new Select(driver.findElement(By.id("years"))).selectByValue(year);

    }
    public void SetStreet(String street) {
        driver.findElement(By.id("address1")).click();
        driver.findElement(By.id("address1")).sendKeys(street);
    }
    public void SetCity(String city) {
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys(city);
    }
    public void SetState(String state) {
        new Select(driver.findElement(By.id("id_state"))).selectByVisibleText(state);
    }
    public void SetZipCode(String zip) {
        driver.findElement(By.id("postcode")).click();
        driver.findElement(By.id("postcode")).sendKeys(zip);
    }
    public void SetCountry(String country) {
        new Select(driver.findElement(By.id("id_country"))).selectByVisibleText(country);
    }
    public void SetMobilePhone(String number) {
        driver.findElement(By.id("phone_mobile")).click();
        driver.findElement(By.id("phone_mobile")).sendKeys(number);
    }

}
