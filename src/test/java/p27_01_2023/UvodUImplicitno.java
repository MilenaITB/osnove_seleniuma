package p27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UvodUImplicitno {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("file:///C:/Users/Lenovo/Desktop/Zadatak4.html");
//      - - - - - - - - - - -
        driver.findElement(By.id("id-0"));
//        lkdslkds
        driver.findElement(By.id("id-0"));
//        sdlsdkl
        driver.findElement(By.id("id-0"));
        driver.findElement(By.id("id-0"));
//        dsdlk
        driver.findElement(By.id("id-0"));
        driver.findElement(By.id("id-0"));
//      1s -> 2div
//      3s -> 4div
        driver.findElements(By.id("id-0"));

        System.out.println("NADJEN");

        Thread.sleep(5000);
        driver.quit();
    }
}