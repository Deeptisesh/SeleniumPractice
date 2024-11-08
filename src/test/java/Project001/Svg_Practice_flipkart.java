package Project001;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Svg_Practice_flipkart {
    WebDriver driver=new ChromeDriver();

    @BeforeTest
    public  void Setup(){


        driver.manage().window().maximize();

        driver.get("https://www.flipkart.com/");
//        WebElement popupclose=driver.findElement(By.xpath("//div/span[@role='button']"));
//        if(popupclose.isDisplayed()) {
//            popupclose.click();
//        }

    }


    @Description("Verify and click on SVG elements in Flipkart")
    @Test
    public void test_flipkart_Search() throws InterruptedException {
        //input "Mobiles" in search bx
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("mobiles");

            // Click on search icon in searchbox using SVG
        List<WebElement> svgelements= driver.findElements(By.xpath("//*[name()='svg']"));

        for(WebElement svgelement:svgelements){
            System.out.println(svgelement.getText());
            if(svgelement.getText().contains("Search Icon")){
                svgelement.click();
                return;
            }
        }


    }
    @Description("Verify and click on a mobile in Flipkart")
    @Test(dependsOnMethods = "test_flipkart_Search")
    public void test_select_Mobile_JSExecuter() throws InterruptedException {
        //Scrolldown

        JavascriptExecutor js=(JavascriptExecutor) driver;
        System.out.println("Java Script executer ");
        //WebElement selectMobile=driver.findElement(By.xpath("//div[contains(text(),'Motorola g45 5G (Brilliant Green, 128 GB)')]"));
        WebElement selectMobile=driver.findElement(By.xpath("//div[contains(@data-id,'MOB')]//img[contains(@alt,'Motorola g45 5G (Brilliant Green, 128 GB)')]"));
        //js.executeScript("window.scrollBy(0,500)");

        js.executeScript("aurgument[0].click()",selectMobile);
        System.out.println("Scrolled down");

        Thread.sleep(3000);

         }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
