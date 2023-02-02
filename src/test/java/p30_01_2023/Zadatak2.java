package p30_01_2023;
//2. Zadatak
//Napisati program koji ucitava stranicu
// https://youtube.com
// i u search baru unosi tekste Breskvica
// i ceka da se pojavi vise od 3 rezultata iz padajuceg menija i zatim klikce na prvi.

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://youtube.com");

//        //*[@id='search']
        driver
                .findElement(By.xpath("//input[@id='search']"))
                .sendKeys("Breskvica");

        driver
                .findElement(By.xpath("//input[@id='search']"))
                .sendKeys(Keys.SPACE);


        wait.until(
                ExpectedConditions
                        .numberOfElementsToBeMoreThan(
                                By.xpath("//li[@role='presentation']"), 3));
// i ceka da se pojavi vise od 3 rezultata iz padajuceg menija i zatim klikce na prvi.

        driver.findElement(By.xpath("//li[@role='presentation'][last()]")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}