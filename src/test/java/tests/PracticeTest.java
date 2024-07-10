package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeTest extends BaseTest {
    private final static By LINK = By.xpath("//a[@href='/challenging_dom']");
    private final static By PAGE = By.xpath("//div[@class='example']");

    @Test
    public void locatorTest() {
        WebElement locator = driver.findElement(LINK);
        locator.click();
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE));
        String titleName = title.getText();
        System.out.println(titleName);
        Assert.assertTrue(titleName.contains("Challenging DOM"), "Title not visible");
    }

    @Test
    public void interactionTest() {
        WebElement locator = driver.findElement(By.xpath("//a[@href='/login']"));
        locator.click();

        WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
        String loginCheck = login.getText();
        Assert.assertTrue(loginCheck.contains("Login Page"), "Not in Login Page");

        WebElement keys = driver.findElement(By.id("username"));
        keys.sendKeys("tomsmith");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("SuperSecretPassword!");

        WebElement clicker = driver.findElement(By.className("radius"));
        clicker.click();

        WebElement clicker2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("secondary")));
        clicker2.click();

        WebElement logout = driver.findElement(By.id("flash"));
        Assert.assertTrue(logout.isDisplayed());
    }

    @Test
    public void navigationTest() {
        WebElement locator = driver.findElement(By.xpath("//a[@href='/key_presses']"));
        locator.click();

        WebElement pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        String header = pageHeader.getText();
        Assert.assertTrue(header.contains("Key Presses"));
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        Assert.assertTrue(header.contains("Key Presses"));
        driver.quit();

    }
   /** public void javascriptTest(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement title = driver.findElement(By.id(#title));
        js.executeScript("arguments[0].scrollIntoView",title);
    } **/


}
