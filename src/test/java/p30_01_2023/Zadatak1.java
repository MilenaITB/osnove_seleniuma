package p30_01_2023;
//1.Zadatak
//Napisati program koji ucitava stranicu https://s.bootsnipp.com/iframe/klDWV
// i ceka da se ucita progress bar na 100%
// a zatim ispisuje tekst u konzoli “Stranica ucitana”

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://s.bootsnipp.com/iframe/klDWV");

        wait.until(ExpectedConditions.textToBe(By.id("precent"), "100%"));

// 2.način:  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader-wrap")));
//3.način: wait.until(ExpectedConditions.attributeContains(By.className("glow"), "style", "width: 100%"));
        Thread.sleep(5000);
        driver.quit();
    }
}