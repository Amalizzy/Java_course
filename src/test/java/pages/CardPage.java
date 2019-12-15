package pages;

import components.CartComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CardPage extends AbstractPage {

    private static String LI_CART_ITEM_XPATH ="//li[@class='cart-item']";

    public CardPage(WebDriver driver) {
        super(driver);
    }

    public List<CartComponents> getCartItems() {
        List<WebElement> productListCartWebElement = driver.findElements(By.xpath(LI_CART_ITEM_XPATH));
        return productListCartWebElement.stream()
                .map(item -> new CartComponents(driver, item))
                .collect(Collectors.toList());
    }
}
