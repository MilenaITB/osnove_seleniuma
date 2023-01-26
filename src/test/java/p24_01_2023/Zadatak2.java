package p24_01_2023;
//2.Zadatak
//        Napisati program koji:
//        Maksimizuje prozor
//        Ucitava stranicu https://demoqa.com/login
//        Za username unosi itbootcamp.
//        Xpath za trazivnje ovog elementa treba da bude preko id atributa.
//        Za lozinku unosi ITBootcamp2021!
//        Xpath za trazenje ovog elementa treba da bude preko placeholder atributa.
//        Klikce na dugme Login.
//        Xpath ovog elementa treba da bude
//        tako da se prvo dohvati form element i da se od njega spusti do dugmeta
//        Ceka 5sekundi
//        Klikce na dugme Log out.
//        Xpath ovog elementa treba da bude po tekstu elementa.
//        Koristan link
//        Zatvara pretrazivac

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //    1.   Maksimizuje prozor
        driver.manage().window().maximize();


//  2.      Ucitava stranicu https://demoqa.com/login
        driver.navigate().to("https://demoqa.com/login");


//      3-1.= LEPŠE REŠENJE:  driver.findElement(By.id("userName"))
//                .sendKeys();

        //  3.      Za username unosi itbootcamp.
//        Xpath za trazivnje ovog elementa treba da bude preko id atributa.
        driver.findElement(By.xpath("//*[@id='userName']"))
                .sendKeys("itbootcamp");


//  4.        Za lozinku unosi ITBootcamp2021!
//        Xpath za trazenje ovog elementa treba da bude preko placeholder atributa.
        driver.findElement(By.xpath("//*[@placeholder='Password']"))
                .sendKeys("ITBootcamp2021!");

//  5.Dohvatim i ....Klikce na dugme Login.
        //        Xpath ovog elementa treba da bude
//        tako da se prvo dohvati form element i da se od njega spusti do dugmeta

        driver.findElement(By.xpath("//form[@id='userForm']/div[4]/div[1]/button"))
                .click();
//  5-1.      driver.findElement(By.xpath("//*[@id='userForm']//*[@id='login']"))
//                        .click();

//  5.2.     dohvati mi el.po  "userForm",
//      pa u okviru ovog el.mi nastavi dalje traženje   .findElement-gde tražim(By.id("login"))

//      driver.findElement(By.id("userForm"))
//                        .findElement(By.id("login")).....i to mi vrati dugme na koje samo
//                                .click();......kliknem

//    tu fali, dodati....Ceka 1 sekundu
                Thread.sleep(1000);

        //  7.      Klikce na dugme Log out.
//        Xpath ovog elementa treba da bude po tekstu elementa. Koristan link
        driver.findElement(By.xpath("//*[contains(text(), 'Log out')]"))
                .click();

        //   8.     Ceka 5sekundi
        Thread.sleep(5000);

        //  9.      Zatvara pretrazivac
        driver.quit();
    }
}