import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium006 {

    ChromeDriver driver=new ChromeDriver();

    @Test
    public void testclose(){
        // Closes only the current tab or window
    driver.get("https://google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://app.eraser.io/workspace/FQDKGYeDSRxo9SxZX6Wt");
    driver.close();

    }
    @Test
    public void testquit(){
        //Closes all session and windows
        driver.get("https://google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://app.eraser.io/workspace/FQDKGYeDSRxo9SxZX6Wt");
        driver.quit();


    }
}
