package p24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UvodUSelenium {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");  //1.linija

        WebDriver driver = new ChromeDriver();    // 2.linija
        // OBJEKAT driver je glavni baja u mom programu.
        // Sva komunikacija sa našom stranicom MORA da ide kroz drive objekat

        driver.manage().window().maximize();  // 3. linija
        // maximizuj mi stranicu i onda nastavi dalje korake,
        // u max.rezoluciji i tek onda mi učitaj google stranicu

//         I.  metoda koja radi učitavanje stranice

        driver.get("https://google.com/");  // 4.linija-I
        // GET metoda koja mi učitava stranicu
        // drive ima metodu   .get kojoj prosledim URL u punom formatu koji treba da se otvori

 //   II. METODA koja radi učitavanje stranice. 4.linija-II
        driver.navigate().back();
        driver.navigate().forward();
//      koristim kad se šetam po stranicama jer ima više funkcionalnosti
//      uglavnom koristim GET metodu
//      MOGU da se MIX obe metode

        driver.navigate().to("https://google.com/");


        WebElement in = driver.findElement(
                By.xpath("//input[@name='q']"));

        long startTime = System.currentTimeMillis();
//        driver.findElement(By.xpath("//img[@class='lnXdpd']"));
//        driver.findElement(
//                By.xpath("//input[@name='q']"));
        in.sendKeys("I");
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Trazenje " + duration + "ms");


        String imgAttr = driver.findElement(By.xpath("//img[@class='lnXdpd']"))
                .getAttribute("src");

        System.out.println(imgAttr);


//     naredba za čekanje i mogu da je stavim bilo gde u programu i na kom god hoću koraku
//     da bi lakše ispratila šta se dešava
        Thread.sleep(5000);

//        driver.findElement(By.xpath("//input[@name='q']"))
//                .sendKeys("IT Bootcamp");
//
//        driver.findElement(By.xpath("//input[@name='q']"))
//                .sendKeys(Keys.ENTER);
//
//        Thread.sleep(1000);

//        WebElement firstLink =
//                driver.findElement(
//                        By.xpath("//a[@href='https://itbootcamp.rs/']"));
//        firstLink.click();

//        driver.findElement(By.xpath("//a[@href='https://itbootcamp.rs/']"))
//
//
//        driver.findElement(By.xpath("//a[@href='https://itbootcamp.rs/']"))
//                        .click();




        Thread.sleep(5000);

        driver.quit();    // nakon svakog TEST-a radim quit. da počistim sve.
        // radim isključivo na kraju TEST-a
    }
}