import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BeymenPOM {
    public BeymenPOM(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@class='default-input o-header__search--input']")
    public WebElement searchBox;

    @FindBy(css = "button#onetrust-accept-btn-handler")
    public WebElement cookies_Loc;

    @FindBy(id = "addBasket")
    public WebElement basket;

    @FindBy(xpath = "(//*[@class='o-header__userInfo--text'])[3]")
    public WebElement basketGo;

    @FindBy(id = "quantitySelect0-key-0")
    public WebElement selectAdet;

    @FindBy(id = "removeCartItemBtn0-key-0")
    public WebElement deleteButton;

    @FindBy(xpath = "(//strong[@class='m-empty__messageTitle'])[1]")
    public WebElement getMessage;







    @FindBy(css = "#priceNew")
    public WebElement productPrice;

    @FindBy(xpath = "//*[contains(@class, 'm-variation__item')]")
    public List<WebElement> sizeOfBody;

    @FindBy(css = "#addBasket")
    public WebElement addBasketButton;

    @FindBy(xpath = "//*[@class='m-notification__button btn']")
    public WebElement goToBasketButton;

    @FindBy(css = ".m-productPrice__salePrice")
    public WebElement basketPrice;

    @FindBy(xpath = "//*[@class='a-selectControl -small']")
    public WebElement quantityDropDown;





}
