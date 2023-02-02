package p30_01_2023;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
////        4.Zadatak
//        Napisati program koji:
//        Ucitava stranicu
//        https://mdbootstrap.com/docs/standard/components/toasts/
//        Vrsi klik na Basic example link iz desne navigacije
//        Ceka da url sadrzi #section-basic-example


public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/");

        driver.findElement(By.linkText("Basic example")).click();

        wait.until(ExpectedConditions.urlContains("#section-basic-example"));


        Thread.sleep(5000);
        driver.quit();
    }
}