package Assainments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium13Oct {
    WebDriver driver=new ChromeDriver();


    @Test
    public void getTitle(){

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");

    }
    @Test
    public void verifyCurrentURL(){
       Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/");

    }
    @Test

    public void verifyText(){

       driver.getPageSource().contains("CURA Healthcare Service");
    }

}
