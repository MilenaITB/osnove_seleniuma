package v_26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Maksimizirati prozor
        driver.manage().window().maximize();

        //Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(1000);

        //Prijavite se na sistem
        //Username: Admin
        driver.findElement(By.name("username")).sendKeys("Admin");
        Thread.sleep(1000);

//Password: admin123
        driver.findElement(By.name("password")).sendKeys("admin123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

//Cekanje od 5s
        Thread.sleep(5000);

        //U input za pretragu iz navigacije unesite tekst Me
        driver.findElement
                (By.xpath("//input[@placeholder='Search']")).sendKeys("Me");


//Kliknite na prvi rezultat pretrage (to ce biti Time)
        driver.findElement(By.className("oxd-main-menu-item")).click();
        //Cekanje od 1s
        Thread.sleep(1000);

        //Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
        driver.findElement(By.className("oxd-userdropdown")).click();
        Thread.sleep(1000);

//Klinkite na logout
        driver.findElement(By.xpath("//a[@href='/web/index.php/auth/logout']")).click();
        //Cekanje od 5s
        Thread.sleep(5000);

        //Zatvorite pretrazivac
        driver.quit();
    }
}