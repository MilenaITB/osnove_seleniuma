package p27_01_2023;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
//  3.Zadatak
//Napisati program koji ucitava stranicu
// https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=
//Klik na Type drawdown
//Klik na Public iz drowdowna
//Proverava da li je Clear dugme u desnom uglu prikazano
//Kilk na Clear filter u desnom uglu

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://github.com/orgs/embedly/repositories");

        WebElement type = driver.findElement(By.id("type-options"));
        type.click();
        Thread.sleep(2000);
        type.findElements(By.className("SelectMenu-item")).get(1).click();

        if(new Helper().elementExist(driver, By.className("issues-reset-query"))) {
            System.out.println("Element postoji");
        } else {
            System.out.println("Element ne postoji");
        }

        driver.findElement(By.className("issues-reset-query")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}