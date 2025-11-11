package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicWebTable1 {

    @Test
    public void print_DynamicWebTable(){

        //Need to strucure detais for each td

        WebDriver driver= new ChromeDriver();

        driver.get("https://awesomeqa.com/webtable1.html");
        driver.manage().window().maximize();

        //Xpath is-//table[@summary='Sample Table']/tbody/tr/th[contains(text(),'Burj Khalifa')]

        WebElement table= driver.findElement(By.xpath("//table[@summary='Sample Table']//tbody"));

        List<WebElement> rows= table.findElements(By.xpath("tr"));

        for(WebElement row:rows){
            WebElement first=row.findElement(By.xpath("//td//preceding-sibling::th"));
            System.out.println(first.getText());


            List<WebElement> cols=row.findElements(By.tagName("td"));
            //following sibling ,preceding sibling,forward sibling ,child, parent




            for(WebElement col:cols){

            System.out.println(col.getText());

            }
        }


        driver.quit();
    }
}
