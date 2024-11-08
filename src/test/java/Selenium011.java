import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium011 {

    @Test
    public void test_geturlandtitle(){

        WebDriver driver=new ChromeDriver();

        driver.get("https://katalon-demo-cura.herokuapp.com");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");

       if(driver.getPageSource().contains("CURA Healthcare Service")){

           System.out.println("page source contains CURA Healthcare Service");
       }else{
           System.out.println("page source does not contains CURA Healthcare Service");
       }


        driver.quit();

    }
}
