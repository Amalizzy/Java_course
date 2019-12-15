package pages;

import components.ProductComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends AbstractPage {

    private static String ONE_PRODUCT_ITEM_XPATH = "//figure[@class='productitem--image']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<ProductComponent> getProducts() {
        List<WebElement> productListItems = driver.findElements(By.xpath(ONE_PRODUCT_ITEM_XPATH));
        return productListItems.stream()
                .map(item -> new ProductComponent(driver, item))
                .collect(Collectors.toList());
    }

    public List<ProductComponent> getPriceWithDoscount(){

        return getProducts().stream()
                .filter(item -> item.isSoldOut())
                .collect(Collectors.toList());
    }
}
