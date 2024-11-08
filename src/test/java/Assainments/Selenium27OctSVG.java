package Assainments;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium27OctSVG {

    WebDriver driver;

    @BeforeTest
    public void setUp(){

        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        driver =new ChromeDriver(chromeOptions);


    }

    @Test
    public void test_State_tripura() throws InterruptedException {

        driver.get("https://www.amcharts.com/svg-maps/?map=india");

//        WebElement tripura=driver.findElement(By.xpath("//*[name()='svg' and normalize-space(@aria-label='Tripura')]"));
//
//        JavascriptExecutor js=(JavascriptExecutor)driver;
//       js.executeScript("arguments[0].scrollIntoView(true);",tripura);
//
//
//        tripura.click();

        List<WebElement> states=driver.findElements(By.xpath("//*[local-name()='svg']/*[local-name()='g'][7]/*[local-name()='g']/*[local-name()='g']/*[local-name()='path']"));

        for(WebElement state:states){
            String statename= state.getAttribute("aria-label");

            System.out.println(statename);

            if (statename != null && statename.contains("Tripura")) {
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("arguments[0].scrollIntoView();",state);

                state.click();
            }
        }

        Thread.sleep(5000);

    }


    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
