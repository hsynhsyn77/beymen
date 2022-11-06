package utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import static utilities.GWD.threadBrowserName;

public class GenelWebdriver {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void startingOperations() throws IOException {
        System.out.println("========= Test start =========");

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.beymen.com/");


    }

    @AfterClass
    public void BitisIslemleri() {
        System.out.println("========Test Ended =========");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }

    public static void KalanOncekileriKapat() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver /T");
        } catch (Exception ignored) {

        }
    }

    public static void textFile() {
        File f = new File("savetxt.txt");

        WebElement e = driver.findElement(By.xpath("//span[@class='o-productDetail__description']"));

        String s1 = e.getText();

        try {
            FileUtils.writeStringToFile(f, s1, Charset.defaultCharset());


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void randomSelect(By locator) {

        Random rand = new Random();
        findToAll(locator).get(rand.nextInt(findToAll(locator).size())).click();
    }

    public List<WebElement> findToAll(By locator) {

        return driver.findElements(locator);
    }

    public static void textFile2() {
        File f1 = new File("txt2.txt");

        WebElement e1 = driver.findElement(By.cssSelector("div[class='m-price__list']"));
        String s = e1.getText();
        try {

            FileUtils.writeStringToFile(f1, s, Charset.defaultCharset());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
















