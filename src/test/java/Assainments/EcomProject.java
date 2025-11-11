package Assainments;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class EcomProject {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        //Opening URL
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/ui/index.php?route=common/home");

    }
    @Description("Verify the Title of the Page")
    @Test
    public void getTitle(){

        // Get Title

        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Your Store");

    }
    @Description("Verify the slideshow Functionality")
    @Test
    public void slideshowFunctionality(){
        List<WebElement> slides=driver.findElements(By.xpath("//div[@class='swiper-wrapper']//div//a//img"));

        for(WebElement slide:slides){

            System.out.println(slide.getAttribute("alt"));

            // not getting all alt
        }

    }

    // To Scroll to get element into view
    public void scrollToElement(String elementLocator) throws InterruptedException {
        WebElement element = driver.findElement(By.id(elementLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);

    }

    @Description("Verify the if MacBook is clickable")
    @Test
    public void clickOnMacBook() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='row']//div[@class='caption']//a[contains(text(),'MacBook')]")).click();

        //Verify the Title of page is MacBook
        Assert.assertEquals(driver.getTitle(),"MacBook");

        //Update the Quantity textbox to 2
        WebElement quantity=driver.findElement(By.id("input-quantity"));
        quantity.clear();
        quantity.sendKeys("2");
        // Click on add to cart
        driver.findElement(By.id("button-cart")).click();
        Thread.sleep(3000);

        // Click on Logo to go back to Home page
        driver.findElement(By.id("logo")).click();
        Thread.sleep(3000);
    }
    @Description("Verify the if MacBook is clickable")
    @Test
    public void clickOnAppleCinema() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='row']//div[@class='caption']//a[contains(text(),'Apple Cinema 30')]")).click();

        //Verify the Title of page is MacBook
        Assert.assertEquals(driver.getTitle(), "Apple Cinema 30");

        // Verify the Price of the item is correct
        WebElement price=driver.findElement(By.xpath("//div[@id='content']//div[@class='row']//div[@class='col-sm-4']//ul[2]//li[2]"));
        System.out.println(price.getText());

        Assert.assertEquals(price.getText(),"$110.00");

        //Click on Medium Radio Button
        List<WebElement> radioButtons=  driver.findElements(By.xpath("//div[@id='content']//div[@class='row']//div[@class='col-sm-4']//div[@id='product']//div[@class='radio']"));

        for(WebElement radio:radioButtons){

            System.out.println(radio.getText());
            if(radio.getText().contains("Medi")){
                System.out.println("Entering if loop");

               // not clicking on medium radiobutton
                    radio.click();
                    Thread.sleep(3000);


                //radio.isSelected()
            }
        }


    }

        @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
