package Project001;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium009 {

    @Test
    public void basicGetPractice(){
        ChromeDriver driver=new ChromeDriver();

        driver.get("https://www.flipkart.com");
         driver.quit();
    }
}
