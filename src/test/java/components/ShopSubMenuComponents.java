package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

public class ShopSubMenuComponents extends BaseComponent {

    public ShopSubMenuComponents(WebDriver driver) {
        super(driver);
    }

    public ProductsPage clickOnProductType(String productType){
        driver.findElement(By.xpath("//ul[contains(@class, 'navmenu-depth-3')]//li[contains(@class, 'navmenu-id-christmas')]/a[contains(.,' " + productType + "')]")).click();
        return new ProductsPage(driver);
    }
}
