package ActionsPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.testng.annotations.Test;

public class ActionsPracticeonSpiceJet {
    WebDriver driver=new ChromeDriver();


    @Test
    public void SearchFlight(){

        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();

        


    }
}
