package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartComponents  extends BaseComponent{

    private WebElement cartWebElement;

    private static String TEXT_NAME_PRODUCT_XPAT =".//h2[@class='cart-item--content-title']/a";
    private static String PRICE_PRODUCT_XPATH = ".//div[@class='cart-item--content-price']//span[@class='money']";

    public CartComponents(WebDriver driver, WebElement webElement) {
        super(driver);
        this.cartWebElement = webElement;
    }

    public String getDescription(){

        return cartWebElement.findElement(By.xpath(TEXT_NAME_PRODUCT_XPAT)).getText();
    }

    public double getPrice(){

        String price = cartWebElement.findElement(By.xpath(PRICE_PRODUCT_XPATH)).getText();
        String priceWithoutSign = price.substring(1);
        return  Double.parseDouble(priceWithoutSign);
    }
}
