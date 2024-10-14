package Project001;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;


public class Seleniumproj001 {
    // Open the app.vwo.com
    // We want to verify the title by using the TestNG assertion.

    WebDriver driver=new ChromeDriver();
@Test
    public void verifyTitleOfVMO(){
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        driver.quit();
    }

}
