package ZalandoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import zalandooComponents.ProductComponent;
import zalandooComponents.ProductsHeaderComponent;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends AbstractPage {

    private ProductsHeaderComponent productsHeader;

    private static By ONE_PRODUCT_ITEM = By.xpath("//div[@class='cat_cardWrap-2UHT7']");

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.productsHeader = new ProductsHeaderComponent(driver);
    }

    public ProductsHeaderComponent getProductsHeader(){

        return productsHeader;
    }

    public List<ProductComponent> getProducts() {

        pause(2000);
        List<WebElement> productListItems = driver.findElements(ONE_PRODUCT_ITEM);
        return productListItems.stream()
                .map(item -> new ProductComponent(driver, item))
                .collect(Collectors.toList());
    }

    public List<ProductComponent> getProductsWithDiscount(){

        return getProducts().stream()
                .filter(item -> item.isPriceWithDiscount())
                .collect(Collectors.toList());
    }

    public List<ProductComponent> getProductsWithPriceRange(){

        return getProducts().stream()
                .filter(item -> item.isPriceWithDiscount())
                .collect(Collectors.toList());
    }

}
