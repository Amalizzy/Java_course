package ZalandoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import zalandooComponents.CartComponent;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends AbstractPage {

    private static By LI_CART_ITEM_XPATH = By.xpath("(//div/div[contains(@class, 'z-coast-base__tile')])[1]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<CartComponent> getCartItems() {
        List<WebElement> productListCartWebElement = driver.findElements(LI_CART_ITEM_XPATH);
        return productListCartWebElement.stream()
                .map(item -> new CartComponent(driver, item))
                .collect(Collectors.toList());
    }

}
