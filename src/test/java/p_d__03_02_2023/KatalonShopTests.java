package p_d__03_02_2023;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class KatalonShopTests {
//    Kreirati KatalonShopTests klasu:
//    baseUrl: https://cms.demo.katalon.com
//    Test #1:  Adding product with quantity to the cart
//            Prioritet = 10
//    Koraci:
//    Ucitati stranicu /product/flying-ninja/
//    Unesite kolicinu 3
//    Klik na Add to cart dugme
//    Verifikovati da poruka sadrzi tekst “Flying Ninja”.
//    Klik na Cart link iz navigacije
//    Verifikovati da u url-u stoji /cart ruta
//    Verifikovati da je broj proizvoda u korpi jednako 1
//
//    Test #2:  Removing product from cart
//    Prioritet = 20
//    Koraci:
//    Klik na Cart link iz navigacije
//    Verifikovati da u url-u stoji /cart ruta
//    Verifikovati da je broj proizvoda u korpi jednako 1
//    Klik na remove dugme iz prvog reda
//    Verifikovati da je broj proizvoda u korpi jedako 0

//	Test #3:  Verify error is displayed when username is missing
//	Prioritet = 30
//	Koraci:
//Kliknite na my account link
//Klik na login dugme
//Verifikovati da je prikazana poruka Error: Username is required.

    private String baseUrl = "https://cms.demo.katalon.com";
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseUrl + "/product/flying-ninja/");
    }

    @Test(priority = 10)
    public void addingProductsWithQuantityToTheCart() throws InterruptedException {

        driver.findElement(By.xpath("//*[@class='quantity']/input")).clear();
        driver.findElement(By.xpath("//*[@class='quantity']/input"))
                .sendKeys("3");
        driver.findElement(By.name("add-to-cart")).click();

        WebElement message = driver.findElement(By.className("woocommerce-message"));

        Assert.assertTrue(message.getText().contains("Flying Ninja"),
                "Message doesn't contain right message");

        driver.findElement(By.className("woocommerce-message"))
                .findElement(By.tagName("a")).click();

        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl+ "/cart/", "Url is not right");

        int cartElements = driver.findElements(By.xpath("//*[@class='entry-content']/div/form")).size();
        Assert.assertEquals(cartElements,1,"There are no products in the cart");

        Thread.sleep(1000);
    }



    @Test(priority = 20)
    public void RemovingProductFromCart() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id='primary-menu']//li/a")).click();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl+ "/cart/", "Url is not right");
        Thread.sleep(1000);
        int cartElements = driver.findElements(By.xpath("//*[@class='entry-content']/div/form")).size();
        Assert.assertEquals(cartElements,1,"There are no products in the cart");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='product-remove']/a")).click();

        Thread.sleep(3000);

        cartElements = driver.findElements(By.xpath("//*[@class='entry-content']/div/form")).size();
        Assert.assertEquals(cartElements,0,"There are no products in the cart");
        Thread.sleep(1000);
    }

    @Test(priority = 30)
    public void verifyErrorIsDisplayedWhenUsernameIsMissing() throws InterruptedException {
        //Click on my account link
        driver.findElement(By.xpath("//*[@id='primary-menu']//li[3]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("login")).click();
        Thread.sleep(1000);
        String errorMessage = driver.findElement(By
                        .xpath("//*[@class='woocommerce-error']/li"))
                .getText();

        Assert.assertEquals(errorMessage, "Error: Username is required.",
                "Error message is wrong");

    }

            // DOVDE SMO RADILI NA ČASU....OSTALI TESTOVI SU URAĐENI ZA DOMAĆI 03.02.2023.



 //Test #4:  Verify error is displayed when password is missing
        //	Prioritet = 40
        //	Koraci:
        //Kliknite na my account link
        //Unesite username customer
        //Klik na login dugme
        //Verifikovati da je prikazana poruka ERROR: The password field is empty.

        @Test(priority = 40)
        @Description("Test #4:  Verify error is displayed when password is missing")
        public void verifyErrorIsDisplayedWhenPasswordIsMissing() throws InterruptedException {

            driver.findElement(By.xpath("//*[@class='page_item page-item-10']/a")).click();
            driver.findElement(By.id("username")).sendKeys("customer");
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            Thread.sleep(1000);

            Assert.assertTrue(driver.findElement(By.xpath
                            ("//*[@class='woocommerce-error']/li"))
                    .getText().contains("ERROR: The password field is empty."));
        }


        //Test #5:  Verify error is displayed when password is wrong
        //	Prioritet = 50
        //	Koraci:
        //Kliknite na my account link
        //Unesite username customer
        //Unesite nevalidan pass invalidpassword
        //Klik na login dugme
        //Verifikovati da je prikazana poruka
        // ERROR: The password you entered for the username customer is incorrect. Lost your password?

        @Test(priority = 50)
        public void verifyErrorIsDisplayedWhenPasswordIsWrong() throws InterruptedException {

            driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li[3]/a")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#username")).sendKeys("customer");
            driver.findElement(By.cssSelector("#password")).sendKeys("invalidpassword");
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(".woocommerce-form-login__submit")).click();
            Thread.sleep(1000);

            Assert.assertTrue(driver.findElement
                            (By.xpath("//*[@class='woocommerce-error']/li"))
                    .getText()
                    .contains("ERROR: The password you entered for the username customer is incorrect. "
                            + "Lost your password?"));
            Thread.sleep(1000);
        }


    //Test #6:  Verify error is displayed when user does not exist
        //	Prioritet = 60
        //	Koraci:
        //Kliknite na my account link
        //Unesite username invaliduser
        //Unesite nevalidan pass (ex: pass1234)
        //Klik na login dugme
        //Verifikovati da je prikazana poruka ERROR: Invalid username. Lost your password?

    @Test(priority = 60)
        public void verifyErrorIsDisplayedWhenUserDoesNotExist() throws InterruptedException {

        driver.findElement(By.xpath("//*[@class='page_item page-item-10']/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("username")).sendKeys("invaliduser");
        driver.findElement(By.id("password")).sendKeys("pass1234");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='woocommerce-error']/li"))
                .getText().contains("ERROR: Invalid username. Lost your password?"));
    }

        //Test #7:  Verify successful login
        //	Prioritet = 70
        //	Koraci:
        //Kliknite na my account link
        //Unesite username customer
        //Unesite validan pass crz7mrb.KNG3yxv1fbn
        //Klik na login dugme
        //Verifikovati na stranici pise Hello Katalon Parlitul_Changed
        //	Dopunite pageve za sve sto je potrebno za ove testove,
    //	ako je potrebno kreirajte i nove pageve

    @Test(priority = 70)
    @Description("//Test #7:  Verify successful login")
    public void verifySuccessfuLogin() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li[3]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.id("password")).sendKeys("crz7mrb.KNG3yxv1fbn");
        driver.findElement(By.cssSelector(".woocommerce-form-login__submit")).click();
        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='post-10']//p[1]"))
                .getText().contains("Hello Katalon Parlitul_Changed"));
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}