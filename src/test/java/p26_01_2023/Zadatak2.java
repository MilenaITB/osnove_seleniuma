package p26_01_2023;
//
//2.Zadatak
//        Napisti program koji:
//        Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//        Hvata sve elemente prve kolone i stampa tekst svakog elementa.
//        Kako da od nekog elementa procitamo tekst imate na sledecem linku
//        Ceka 1s
//        Hvata sve elemente prvog reda i stampa tekst svakog elementa
//        Ceka 5s
//        Zatvara pretrazivac
//        Stampa treba da bude kao u primeru:
//        John
//        Mary
//        July
//
//        John	Doe	john@example.com

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://s.bootsnipp.com/iframe/z80en");

//        List<WebElement> column =
//                driver.findElements(By.xpath(
//                        "//*[@id='lorem']/table/tbody/tr/td[1]"));
//
//        for (int i = 0; i < column.size(); i++) {
//            System.out.println(column.get(i).getText());
//        }

//        for (int i = 1; i < 4; i++) {
//            String txt = driver.findElement(
//                    By.xpath("//*[@id='lorem']/table/tbody/tr["+i+"]/td[1]"))
//                    .getText();
//            System.out.println(txt);
//        }

        WebElement table = driver.findElement(By.xpath("//*[@id='lorem']/table"));

        List<WebElement> column =
                table.findElements(By.xpath("//tbody/tr/td[1]"));

        for (int i = 0; i < column.size(); i++) {
            System.out.println(column.get(i).getText());
        }

        List<WebElement> row = table.findElements(By.xpath("//tbody/tr[1]/td"));

        for (int i = 0; i < row.size(); i++) {
            System.out.print(row.get(i).getText() + "\t");
        }


        Thread.sleep(5000);
        driver.quit();
    }
}