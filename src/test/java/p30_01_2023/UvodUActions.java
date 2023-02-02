package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UvodUActions {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://tus.io/demo.html");
        WebElement httpTraffic = driver
                .findElement(By.xpath("//*[contains(text(), 'HTTP Traffic')]"));
//        Actions actions = new Actions(driver);
//        actions.scrollToElement(httpTraffic);
//        actions.perform();

        new Actions(driver)
                .scrollToElement(httpTraffic)
                .perform();


        Thread.sleep(5000);
        driver.quit();
    }
}