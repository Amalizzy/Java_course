package zalandooComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartComponent extends BaseComponent {

    private WebElement cartWebElement;

    private static By COLOR_PRODUCT = By.xpath("//div[contains(@class, 'article__details')]/span[3]");
    private static By PRICE_PRODUCT = By.xpath("//div[@class='z-coast-base__article-price__wrapper']//span[contains(@class, 'z-coast-base__price-current')]");
    private static By SIZE_PRODUCT = By.xpath("//div[contains(@class, 'article__details')]/span[4]");

    public CartComponent(WebDriver driver, WebElement webElement) {
        super(driver);
        this.cartWebElement = webElement;
    }

    public String getColor(){

        return cartWebElement.findElement(COLOR_PRODUCT).getText();
    }

    public double getPrice(){

        String price = cartWebElement.findElement(PRICE_PRODUCT).getText();
        String priceWithoutSign = price.substring(1);
        return  Double.parseDouble(priceWithoutSign);
    }

    public String getSize(){

        return cartWebElement.findElement(SIZE_PRODUCT).getText();
    }
}
