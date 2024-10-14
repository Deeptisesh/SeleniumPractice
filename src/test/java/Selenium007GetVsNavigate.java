import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium007GetVsNavigate {

    ChromeDriver driver=new ChromeDriver();

    @Test
    public void testGet(){

        driver.get("https://app.eraser.io/workspace/FQDKGYeDSRxo9SxZX6Wt");

    }

    @Test
    public void testNavigate(){
        driver.navigate().to("https://app.eraser.io/workspace/FQDKGYeDSRxo9SxZX6Wt");
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();

    }
}
