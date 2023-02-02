package p31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;

//1.Zadatak
// Napisati program koji:
//Krairajte folder za fajlove u okviru projekta pod nazivom test_data
//U folder skinite i postavite proizvoljnu sliku
//Ucitava stranu https://tus.io/demo.html
//Skrola do dela za upload fajla
//Aploadujte sliku
//Cekajte da se pojava dugme za download fajla


// MILAN sa časa:

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://tus.io/demo.html");

        new Actions(driver)
                .scrollToElement(driver.findElement(By.id("js-upload-container")))
                .perform();

        driver.findElement(By.id("js-file-input"))
                .sendKeys(new File("test_data/download.png").getAbsolutePath());


        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath
                        ("//*[@id='js-upload-container']/a[1]")));

        Thread.sleep(5000);
        driver.quit();
    }
}

//  moje rešenje:

//public class Zadatak1 {
//    public static void main(String[] args) throws InterruptedException {
//
//       String uploadImgPath = new File("test_data/download.png").getAbsolutePath();
//
//        System.setProperty("webdriver.chrome.driver",
//                "drivers/chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//
//
//        driver.get("https://tus.io/demo.html");


//        Actions actions = new Actions(driver);
//        actions.scrollToElement(driver.findElement(By.id("js-file-input")));
//        actions.perform();
//
//     Thread.sleep(5000);
//
//        driver.findElement(By.id("js-file-input"))
//                .sendKeys(uploadImgPath);
//
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.xpath(
//                        "//a[@class='button button-primary']")));
//        Thread.sleep(5000);
//        driver.quit();
//    }
//}