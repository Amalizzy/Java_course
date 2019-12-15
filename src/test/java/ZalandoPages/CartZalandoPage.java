package ZalandoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import zalandooComponents.CartZalandoZalandoComponent;

import java.util.List;
import java.util.stream.Collectors;

public class CartZalandoPage extends AbstractPage {

    private static By LI_CART_ITEM_XPATH = By.xpath("(//div/div[contains(@class, 'z-coast-base__tile')])[1]");

    public CartZalandoPage(WebDriver driver) {
        super(driver);
    }

    public List<CartZalandoZalandoComponent> getCartItems() {
        List<WebElement> productListCartWebElement = driver.findElements(LI_CART_ITEM_XPATH);
        return productListCartWebElement.stream()
                .map(item -> new CartZalandoZalandoComponent(driver, item))
                .collect(Collectors.toList());
    }

}
