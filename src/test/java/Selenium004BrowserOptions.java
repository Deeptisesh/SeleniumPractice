import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium004BrowserOptions {

    public static void main(String[] args) {

        // EdgeOptions -> It will help you set the browser
        // options to browsers
        // window - size
        // headless mode - there is not UI -> advantage - Fast Execution
        // full UI mode - default - UI browser
        // incognito mode - switch
        // start Max
        // add extensions - browsers
        // 100 + others , https , http
        // localstorage, download ?

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("--window-size=800,600");
        chromeOptions.addArguments("--Incognito");




        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://google.com");
        driver.quit();



    }
}
