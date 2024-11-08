package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class OrangeHRM {

    WebDriver driver=new ChromeDriver();


    @Test
    public void Login() throws InterruptedException {

        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();

        Thread.sleep(3000);
        //  element = WebDriverWait(driver, 10).until(
        //        EC.presence_of_element_located((By.ID, "myDynamicElement"))

//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedCondition.presence)
         driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
         driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Hacker@4321");
         driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
@Test

    public void homePage() throws InterruptedException {

        Thread.sleep(3000);

        WebElement table=driver.findElement(By.xpath("//div[@class='orangehrm-container']"));

        List<WebElement> rows=table.findElements(By.xpath("//div[@role='row']"));
        for (WebElement row:rows){
            WebElement cell=row.findElement(By.xpath("//div[@role='cell']"));
            System.out.println("in cell loop");

            WebElement status=cell.findElement(By.xpath("//div[@role='cell'][6]"));
            String status_message= status.getText();
            System.out.println(status_message);

            if(status_message.equals("Terminated")){
                cell.findElement(By.xpath("//i[@class='oxd-icon bi-trash']")).click();
            }
        }


}
}
