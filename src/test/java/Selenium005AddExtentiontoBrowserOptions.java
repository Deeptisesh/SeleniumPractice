import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium005AddExtentiontoBrowserOptions {

    public static void main(String[] args) {

        //AdBlocker Extension - Need to download CRX file of that Extension

        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addExtensions(new File("Path of CRX file downloaded"));



        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://google.com");
        driver.manage().window().maximize();
        driver.quit();



    }
}
