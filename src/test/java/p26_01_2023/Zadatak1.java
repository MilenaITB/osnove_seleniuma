package p26_01_2023;

// 1.Zadatak
//Napisti proram koji :
//Ucitava stranicu https://s.bootsnipp.com/iframe/oV91g
//Hvatamo sve page-eve iz paginacije tabele
//Zatim petljom prolazimo kroz paginaciju tako sto kliknemo na svaki broj
//Izmedju iteracija napravite pauzu od 1s
//Zatvorite pretrazivac

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://s.bootsnipp.com/iframe/oV91g");

//
//    I prljav-način:

//    List<WebElement> links = driver.findElements(By.xpath("//ul[@id='myPager']/li/a"));

// izbaciću 0 el. i poslednji => ostaju nam 3 koji nam završavaju posao
//        for (int i = 1; i < links.size() - 1; i++) {
//            links.get(i).click();
//            Thread.sleep(1000);
//        }

// NAJBOLJI NAČIN    //*[contains(@class, 'page_link')]
        List<WebElement> links =
                driver.findElements(By.className("page_link"));

        for (int i = 0; i < links.size(); i++) {
            links.get(i).click();
            Thread.sleep(1000);
        }

        Thread.sleep(5000);
        driver.quit();
    }
}