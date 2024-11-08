package Practice;

import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Practice002  {
    ChromeOptions chromeOptions=new ChromeOptions();

    WebDriver driver;
    @Test
    public void openBrowser() throws InterruptedException {
        chromeOptions.addArguments("--start-maximized");

        driver=new ChromeDriver(chromeOptions);

        driver.get("https://app.vwo.com/#/login");
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement Firstname=driver.findElement(By.xpath("//input[@id='login-username']"));
        //WebDriverWait wait = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(driver.findElement(By.xpath("//input[@id='shub42']"))));
        Firstname.sendKeys("Deepti@sdf.com");
        WebElement Password=driver.findElement(By.xpath("//input[@type='password']"));
        Password.sendKeys("qweer");
        WebElement rememberme=driver.findElement(By.xpath("//label[@for='checkbox-remember']//span[@class='checkbox-radio-button ng-scope']//*[name()='svg']"));
        rememberme.click();


        WebElement Button=driver.findElement(By.xpath("//button[@id='js-login-btn']"));
//
        Button.click();
//  check error Message
        Thread.sleep(3000);
        WebElement s= driver.findElement(By.className("notification-box-description"));
                //driver.findElement(By.xpath("//div[@id='js-notification-box-msg']"));
        Assert.assertEquals(s.getText(),"Your email, password, IP address or location did not match");
        //driver.close();
    }

}
