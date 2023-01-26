package p24_01_2023;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;

//3.Zadatak
//Napisati program koji ima:
// Kako od stranice procitati naslov imate na ovom linku


public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Niz stranica (niz stringova) koje treba da ucita. Niz je:
//https://google.com/
//https://youtube.com/
//https://www.ebay.com/
// https://www.kupujemprodajem.com/

        ArrayList<String> links = new ArrayList<>();
// u listi dodajem sve tražene linkove
        links.add("https://google.com/");
        links.add("https://youtube.com/");
        links.add("https://www.ebay.com/");
        links.add(" https://www.kupujemprodajem.com/");


//Program petljom prolazi kroz niz stranica i

        for (int i = 0; i < links.size(); i++) {
            // svaku stranicu ucitava preko get ili navigate
            driver.get(links.get(i));
            // i od svake stranice na ekranu ispisuje naslov stranice.
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            System.out.println();
        }


//U prevodu u konzoli treba da se ispisu:
//Google
//YouTube
//Electronics, Cars, Fashion, Collectibles & More | eBay
//KupujemProdajem

        Thread.sleep(5000);
        //Zatvara pretrazivac
        driver.quit();
    }
}