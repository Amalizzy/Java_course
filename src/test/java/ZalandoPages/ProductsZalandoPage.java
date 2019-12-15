package ZalandoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import zalandooComponents.ProductZalandoZalandoComponent;
import zalandooComponents.ProductsHeaderZalandoZalandoComponent;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsZalandoPage extends AbstractPage {

    private ProductsHeaderZalandoZalandoComponent productsHeader;

    private static By ONE_PRODUCT_ITEM = By.xpath("//div[@class='cat_cardWrap-2UHT7']");

    public ProductsZalandoPage(WebDriver driver) {
        super(driver);
        this.productsHeader = new ProductsHeaderZalandoZalandoComponent(driver);
    }

    public ProductsHeaderZalandoZalandoComponent getProductsHeader(){

        return productsHeader;
    }

    public List<ProductZalandoZalandoComponent> getProducts() {

        pause(2000);
        List<WebElement> productListItems = driver.findElements(ONE_PRODUCT_ITEM);
        return productListItems.stream()
                .map(item -> new ProductZalandoZalandoComponent(driver, item))
                .collect(Collectors.toList());
    }

    public List<ProductZalandoZalandoComponent> getProductsWithDiscount(){

        return getProducts().stream()
                .filter(item -> item.isPriceWithDiscount())
                .collect(Collectors.toList());
    }

    public List<ProductZalandoZalandoComponent> getProductsWithPriceRange(){

        return getProducts().stream()
                .filter(item -> item.isPriceWithDiscount())
                .collect(Collectors.toList());
    }

}
