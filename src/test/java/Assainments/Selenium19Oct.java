package Assainments;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium19Oct {

    WebDriver driver=new ChromeDriver();

    @Test
    @Description("Verify that- Your Account Has Been Created!")
    public void Registration(){
        //Open url
        driver.get(" https://awesomeqa.com/ui/index.php?route=account/register");

        driver.manage().window().maximize();

        //Fill in registration form
        driver.findElement(By.id("input-firstname")).sendKeys("Deepti");
        driver.findElement(By.id("input-lastname")).sendKeys("Seshu");
        driver.findElement(By.name("email")).sendKeys("abc@abc.com");
        driver.findElement(By.id("input-telephone")).sendKeys("1234556777");
        driver.findElement(By.id("input-password")).sendKeys("000000");
        driver.findElement(By.id("input-confirm")).sendKeys("000000");
        driver.findElement(By.name("newsletter")).click();
        driver.findElement(By.name("agree")).click();

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Check if Email id already exist warning is displaying
        WebElement alert=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        Assert.assertEquals(alert.getText(),("Warning: E-Mail Address is already registered!"));

// Implicit wait
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(30));


        //System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Register Account']")));

        // Click on Account tab
        driver.findElement(By.xpath("//a[normalize-space()='Account']")).click();





        driver.quit();
    }

}
