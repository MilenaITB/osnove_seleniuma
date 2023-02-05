package d_02_02_2023;
///1.Zadatak


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;


//Kreirati BootstrapTableTests klasu koja ima:
public class BootstrapTableTests {


    //Podaci:
//Base url: https://s.bootsnipp.com
//First Name: ime polaznika
//Last Name: prezime polaznika
//Middle Name: srednje ime polanzika

    private String baseUrl = "https://s.bootsnipp.com";
    private WebDriver driver;
    private WebDriverWait wait;
    private String firstName = "Ljubica";
    private String lastName = "Ljubenovic";
    private String middleName = "Dusan";

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.manage().window().maximize();
    }

    //Koraci:
//Ucitati stranu /iframe/K5yrx
    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl + "/iframe/K5yrx");
    }

    //Test #1: Edit Row
    @Test(priority = 1)
    public void editRow() throws InterruptedException {
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Page title is incorect");
        Thread.sleep(1000);

//Klik na Edit dugme prvog reda
        driver.findElement(By.xpath("//*[@id='d1']/td[5]/button")).click();
        Thread.sleep(1000);

//Sacekati da dijalog za Editovanje bude vidljiv

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//*[@id='edit']//*[@class='modal-content']")));
        Thread.sleep(1000);
//Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear.
        driver.findElement(By.id("fn")).clear();
        driver.findElement(By.id("ln")).clear();
        driver.findElement(By.id("mn")).clear();
        Thread.sleep(1000);
//Popuniti formu podacima.
        driver.findElement(By.id("fn")).sendKeys(firstName);
        driver.findElement(By.id("ln")).sendKeys(lastName);
        driver.findElement(By.id("mn")).sendKeys(middleName);
        Thread.sleep(1000);

//Klik na Update dugme
        driver.findElement(By.className("modal-content"))
                .findElement(By.xpath("//*[@id='up']")).click();
        Thread.sleep(1000);

//Sacekati da dijalog za Editovanje postane nevidljiv
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-content")));


//Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
        Assert.assertEquals(driver.findElement(By.id("f1")).getText(), firstName,
                "First name is incorrect");


//Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
        Assert.assertEquals(driver.findElement(By.id("l1")).getText(), lastName,
                "Last name is incorrect");

//Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
        Assert.assertEquals(driver.findElement(By.id("m1")).getText(), middleName,
                "Middle name is incorrect");

//Za sve validacije ispisati odgovarajuce poruke u slucaju greske

    }

    //Test #2: Delete Row
    @Test(priority = 2)
    public void deleteRow() throws InterruptedException {
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
    Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
            "Page title is incorrect");
        Thread.sleep(1000);
//Klik na Delete dugme prvog reda
    driver.findElement(By.xpath("//*[@id='d1']/td[6]/button")).click();
        Thread.sleep(1000);
//Sacekati da dijalog za brisanje bude vidljiv
    wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.xpath("//*[@id='delete']//*[@class='modal-content']")));
        Thread.sleep(1000);
//Klik na Delete dugme iz dijaloga
    driver.findElement(By.className("modal-content"))
            .findElement(By.xpath("//*[@id='del']")).click();
        Thread.sleep(1000);
//Sacekati da dijalog za Editovanje postane nevidljiv
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("row")));
        Thread.sleep(1000);

 //Verifikovati da je broj redova u tabeli za jedan manji
        int numberOfRows = driver.findElements
                (By.xpath("//*[@class='row']//tbody/tr")).size();
        List<WebElement> rows = driver.findElements
                (By.xpath("//*[@class='row']//tbody/tr"));
        for (int i = 0; i < rows.size(); i++) {
            if(!rows.get(i).isDisplayed()){
                rows.remove(i);
                Thread.sleep(1000);
            }
        }

//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
        Assert.assertEquals
                (rows.size(), numberOfRows -1,
                        "Number of rows should be less by one");
        Thread.sleep(1000);
    }

//Test #3: Take a Screenshot
    @Test(priority = 3)
    public void takeAScreenshot() throws IOException, InterruptedException {
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
      Assert.assertEquals(driver.getTitle(),
              "Table with Edit and Update Data - Bootsnipp.com",
              "Page title is incorrect");
        Thread.sleep(1000);
 //Kreirati screenshot stranice.
//Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg.
// Na putanji: screenshots/slike.png
        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f.toPath(), new File("screenshots/screenshot_bootstrap_1.png").toPath());

// ne mogu 2x da pustim taj test jer takav naziv fajla već postoji.
// morala bi ponovo da napravim sa drugim imenom "screenshot_bootstrap_1.png"

    }

    @AfterMethod
    public void afterMethod () {
    }

    @AfterClass
    public void afterClass () throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
    }
}








