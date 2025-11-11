package Assainments;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Assainment_ecom {
//    Scenario:(Hard Coded)
//
//            1. With Selenium(Java) + TestNG, create a test suite for the following use case, as a Maven project. (Page object not required)
//
//            2. Share the project as a zip file. Add used IDE details.
//
//            3. Send a screenshot of the test execution status from the IDE.
//
//4. Send the execution report generated separately.
//
//            5. Visit https://www.saucedemo.com/
//
//            6. Grab and use the accepted username and password listed in the UI, without directly hardcoding the credentials
//
//7. Sort by Price (low to high)
//
//8. Add the second product from both columns, after sorting
//
//9. Verify if the right products were added to cart
//
//10. Continue to checkout
//
//11. Extract payment information and price (don’t miss validations)
//
//12. Complete order
//
//13. Logout


    WebDriver driver;
    String productName;

    @BeforeTest
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void loginWithValidCred(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
    @Test(enabled = false)
    public void loginWithLockedOutUser(){
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String ErrorMessage=driver.findElement(By.xpath("//div[@class='error-message-container error']//child::h3")).getText();
        System.out.println(ErrorMessage);

       // Assertions.assertThat(ErrorMessage).isEqualTo("Epic sadface: Username and password do not match any user in this service");
        Assertions.assertThat(ErrorMessage).isEqualTo("Epic sadface: Sorry, this user has been locked out.");
    }
    @Test()
    public void selectFilter() {
        loginWithValidCred();
        driver.findElement(By.className("select_container")).click();
        WebElement dropDownFilter=driver.findElement(By.className("product_sort_container"));
        Select dropDown=new Select(dropDownFilter);
        dropDown.selectByVisibleText("Price (low to high)");

    }
    @Test
    public void selectProduct() {

        selectFilter();
        List<WebElement> products=driver.findElements(By.id("inventory_container"));
        try {
            for (WebElement product:products){
               // System.out.println(product.getText());
                if(product.getText().contains("Sauce Labs Onesie")){
                    productName=product.getText();
                    System.out.println(productName);
                    WebElement addcart=product.findElement(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_description']//div[@class='pricebar']//button"));
                    String a=addcart.getText();
                     String Price1=product.findElement(By.xpath("//div[@class='pricebar']//div[@class='inventory_item_price']")).getText();
                    System.out.println(Price1);
                    if (a.contains("Add to cart")){
                        addcart.click();
                        driver.findElement(By.className("shopping_cart_link")).click();
                        //Thread.sleep(5000);
                        String Price2=driver.findElement(By.xpath("//div[@class='cart_item']//div[@class='cart_item_label']//div[@class='inventory_item_price']")).getText();
                        System.out.println(Price2);
                       Assertions.assertThat(Price2).isEqualTo(Price1);
                        System.out.println("Assertion done");
                        break;

                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public void checkout(){
        selectProduct();


    }



    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
