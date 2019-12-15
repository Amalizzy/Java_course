package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import pages.ProductDetailsPage;

public class ProductComponent extends BaseComponent {

    private WebElement productListItemWebElement;

    private static String SOLD_OUT_PRODUCTS = ".//span[contains(.,'Sold out')][1]";

    public ProductComponent(WebDriver driver, WebElement webElement) {
        super(driver);
        this.productListItemWebElement = webElement;
    }

    public ProductDetailsPage clickOnProduct(){

        productListItemWebElement.click();
        return new ProductDetailsPage(driver);
    }

    public boolean isSoldOut(){

        return productListItemWebElement.findElements(By.xpath(SOLD_OUT_PRODUCTS)).size() >0;
    }
}
