package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class UvodUListu {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://cms.demo.katalon.com/");

       List<WebElement>navLinks = driver.
                findElements(By.xpath("//*[@id='primary-menu']/ul/li/a"));
//        for (int i = 0; i < navLinks.size(); i++) {
//            String txt = navLinks.get(i).getText();
//            System.out.println(txt);
//
//        }

//  I način:     List<WebElement>imgs = driver
//                .findElements(By.xpath("//li[contains(@class, 'product')]/div/a/img"));
//        // i taj xpath nam vrati listu
//        // prođem kroz listu
//        for (int i = 0; i < imgs.size(); i++) {
//// u okviru ove petlje pristupim svakoj slici
//           //     imgs.get(i).getAttribute("src");// i od svake sl.hoću da pročitam putanju
//            // i koji atribut te sl.treba da se pročita
//            // ako odštampam imam sve atribute u prikazu
//
//            System.out.println(imgs.get(i).getAttribute("src"));
//        }

//  II način:     List<WebElement>products = driver
//                .findElements(By.xpath("//li[contains(@class, 'product')]"));
//
//        for (int i = 0; i < products.size(); i++) {
//            WebElement img = products.get(i).findElement(By.xpath("//img"));
//            System.out.println(img.getAttribute("src"));

// III način:      List<WebElement>products = driver
//              .findElements(By.className("product"));

//        for (int i = 0; i < products.size(); i++) {
//            WebElement img = products.get(i).findElement(By.tagName("img"));
//            System.out.println(img.getAttribute("src"));
//        }

           WebElement headerLink = driver
                   .findElement(By.xpath("//header[@id='masthead']/div/p/a"));

             System.out.println(headerLink.getAttribute("href"));

        Thread.sleep(5000);
        driver.quit();
    }
}