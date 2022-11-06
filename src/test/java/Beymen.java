import com.sun.org.apache.bcel.internal.classfile.Utility;
import io.reactivex.rxjava3.exceptions.Exceptions;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.*;
import org.testng.annotations.Test;
import utilities.GenelWebdriver;

import javax.swing.text.Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Beymen extends GenelWebdriver {
    @Test
    void beymen() throws IOException {

        BeymenPOM elements = new BeymenPOM(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.beymen.com/", "Karşılaştırma Sonucu : ");
        System.out.println("homePage = " + driver.getCurrentUrl());
        elements.cookies_Loc.click();
        wait.until(ExpectedConditions.visibilityOf(elements.searchBox));

        String path = "src/test/java/resource/searchBox.xlsx";
        FileInputStream dosyaOkumaBaglantisi = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(dosyaOkumaBaglantisi);
        Sheet worksheet = workbook.getSheet("beymen");
        Row line = worksheet.getRow(1);
        Cell cell = line.getCell(1);
        elements.searchBox.sendKeys(cell.getStringCellValue());
        Actions actions = new Actions(driver);
        actions.moveToElement(elements.searchBox).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
        Cell cell2 = line.getCell(2);
        elements.searchBox.sendKeys(cell2.getStringCellValue());
        actions.sendKeys(Keys.ENTER).perform();
        List<WebElement> product = driver.findElements(By.cssSelector("div[class='m-productImageList']"));
        int min = 0;
        int max = product.size();
        int a = (int) (Math.random() * (max - min + 1) + min);
        product.get(a).click();
        textFile();
        textFile2();

        randomSelect(By.xpath("//span[@class='m-variation__item']"));
        elements.basket.click();
        elements.basketGo.click();
        Select adetMenu=new Select(elements.selectAdet);
        adetMenu.selectByIndex(1);
        //Assert.assertEquals();
        wait.until(ExpectedConditions.visibilityOf(elements.deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(elements.getMessage));
        Assert.assertEquals(elements.getMessage.getText().toLowerCase(), "sepetinizde ürün bulunmamaktadır", "Karşılaştırma Sonucu : ");


        KalanOncekileriKapat();


    }


}


