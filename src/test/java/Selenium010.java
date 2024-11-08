import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Selenium010 {

    public static void main(String[] args) {
        //imp concepts of oops
        WebDriver driver=new ChromeDriver();//Dynamic Dispatch or upcasting or Runtime Polymorphism
        // WebDriver Can we used if we have to run tests in different Browsers


        //Search context Interface - contains findElement and find Elements Methods
        //WebDriver Interface -Contains 10+Methods
        //RemoteWebDriver Class - Contains 15 methods
        //Chromium Driver Class - Contains 25+Methods
            //EdgeDriver Class - Contains 45+Methods
            //ChromeDriver Class -

        SearchContext driver1=new EdgeDriver();//Dynamic Dispatch or upcasting or Runtime Polymorphism
        // this will only have 2 Methods so this is not preferred

        RemoteWebDriver driver2=new ChromeDriver();
        //can be used to run multiple Browsers and multiple Machines





    }
}
