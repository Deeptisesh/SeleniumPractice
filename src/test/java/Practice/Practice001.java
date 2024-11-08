package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Practice001 {
    ChromeOptions chromeOptions=new ChromeOptions();

    WebDriver driver;
    @Test
    public void openBrowser(){
        chromeOptions.addArguments("--start-maximized");

        driver=new ChromeDriver(chromeOptions);

        driver.get("https://selectorshub.com/xpath-practice-page/");
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement Firstname=driver.findElement(By.xpath("(//input[@id='shub42'])[1]"));
        //WebDriverWait wait = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(driver.findElement(By.xpath("//input[@id='shub42']"))));
        Firstname.sendKeys("Deepti");
    }

    @Test(enabled = false)
    public void insertTextBoxes(){
        driver.findElement(By.xpath("//input[@id='shub42']")).sendKeys("Deepti");
//        driver.findElement(By.name("Password")).sendKeys("Deepti");
//        driver.findElement(By.xpath("//input[@name='company' and @fdprocessedid='u0yphk']")).sendKeys("abc");
//

    }
}
