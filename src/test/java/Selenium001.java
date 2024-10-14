import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.annotations.Test;

public class Selenium001 {

    // All the Selenium code will be converted into a API request and go to Browser driver and browser driver gives commands to browsers

    @Test
    public void Seleniumtest1(){
        ChromiumDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
    }
}
