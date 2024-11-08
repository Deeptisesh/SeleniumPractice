package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicWebTable {

    @Test
    public void print_DynamicWebTable(){

        WebDriver driver= new ChromeDriver();

        driver.get("https://awesomeqa.com/webtable1.html");
        driver.manage().window().maximize();

        //Xpath is-//table[@summary='Sample Table']/tbody/tr/th[contains(text(),'Burj Khalifa')]

        WebElement table= driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));

        List<WebElement> rows= table.findElements(By.xpath("tr"));

        for(WebElement row:rows){


            List<WebElement> cols=row.findElements(By.tagName("td"));
            //fowllowng sibbling ,preseaing sibbling ,child parent


            for(WebElement col:cols){



                System.out.println(col.getText());

            }
        }


        driver.quit();
    }
}
