package p26_01_2023;
//5. Zadatak
// (dok ne stignemo do ovog zadatka izguglajte kako da selektujete vrednost u select elementu)
//
//Napisati program koji ucitava stranicu https://www.ebay.com/ i bira kategoriju “Crafts”
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        WebElement selectEl = driver.findElement(By.id("gh-cat"));

        Select select = new Select(selectEl);
//        select.selectByVisibleText("Baby");
//        select.selectByIndex(3);
        select.selectByValue("2984");


        Thread.sleep(5000);
        driver.quit();
    }
}