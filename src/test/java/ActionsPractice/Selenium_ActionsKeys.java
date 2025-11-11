package ActionsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Selenium_ActionsKeys {
    WebDriver driver=new ChromeDriver();

    @Test
    public void practiceCapitalsWithShitKeYDown(){
        driver.get("https://www.awesomeqa.com/practice.html");
        WebElement firstname=driver.findElement(By.xpath("//input[@name='firstname']"));
        // KeyBoard Events - Press Shiftkey, give the string, release shift key

        Actions actions=new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys(firstname,"My name is Deepti").keyUp(Keys.SHIFT).build().perform();
    }
}
