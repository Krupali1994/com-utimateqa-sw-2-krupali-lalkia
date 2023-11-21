package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/ ";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find the signIn link and click on it
        WebElement signinLink = driver.findElement(By.linkText("Sign In"));
        signinLink.click();
        String expectedText = "Welcome Back!";
        //Find the actual text element and get the text from element
        WebElement actualTextElement = driver.findElement(By.xpath("//h2"));
        String actualText = actualTextElement.getText();
        //verify expected and actual text
        Assert.assertEquals("Not redirected to signin page", expectedText, actualText);

    }

    @Test
    public void verifyTheErrorMessage() {
        //Find the signIn link and click on it
        WebElement signinLink = driver.findElement(By.linkText("Sign In"));
        signinLink.click();
        //Find the email field and type the email address to email field
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("krupali123@gmail.com");
        //Find the password field and type the password to password field
        driver.findElement(By.name("user[password]")).sendKeys("krupali123");
        //Find the login btn element and click
        driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]")).click();

        String expectedErrorMessage = "Invalid email or password.";
        //Find the errorMessage element and get the text
        String actualErrorMessage = driver.findElement(By.xpath("//div[@id='notice']")).getText();
        Assert.assertEquals("Invalid email or password.", expectedErrorMessage, actualErrorMessage);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
