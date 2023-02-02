package p31_01_2023;

//Napisati program koji:
//Ucitava stranu
// https://blueimp.github.io/jQuery-File-Upload/
//Uploadujte sliku
//Ceka se da se pojavi slika u listi uploadovanih fajlova
//Koristite uslov da broj elemenata bude 1.
//Klik na Start dugme u okviru item-a koji se uploadovao
//Ceka se da se pojavi delete dugme pored itema
//Klik na delete dugme pored itema
//Ceka se da se element obrise
//Koristite da broj elemenata bude 0

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        driver.findElement(By.name("files[]"))
                .sendKeys(new File("test_data/download.png").getAbsolutePath());

        wait.until(ExpectedConditions
                .numberOfElementsToBe(By.className("template-upload"), 1));

        driver.findElement(By.className("template-upload"))
                .findElement(By.className("start"))
                .click();

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(@class, 'template-download')]//*[contains(@class, 'delete')]")));

        driver.findElement(
                        By.xpath("//*[contains(@class, 'template-download')]//*[contains(@class, 'delete')]"))
                .click();

        wait.until(ExpectedConditions
                .numberOfElementsToBe(By.className("template-download"), 0));



        Thread.sleep(5000);
        driver.quit();
    }
}