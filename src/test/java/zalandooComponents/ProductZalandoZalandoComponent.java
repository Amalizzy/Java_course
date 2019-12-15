package zalandooComponents;

import ZalandoPages.ProductZalandoDetailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductZalandoZalandoComponent extends BaseZalandoComponent {

    private WebElement productListItemWebElement;

    private static By PRODUCTS_WITH_DISCOUNT = By.xpath("//div[@class='cat_flags-2L2Mk']");
    private static By PRODUCTS_WITH_PRICE_RANGE = By.xpath("//div[@class='cat_flags-2L2Mk']");
    private static By PROMOTIONAL_PRICE = By.xpath(".//div[contains(@class, 'cat_promotionalPrice')]/span[not(contains(.,'From'))]");
    private static By REGULAR_PRICE = By.xpath(".//div[contains(@class, 'cat_originalPrice')]/span");


    public ProductZalandoZalandoComponent(WebDriver driver, WebElement webElement) {
        super(driver);
        this.productListItemWebElement = webElement;
    }

    public ProductZalandoDetailPage clickOnProduct(){

        productListItemWebElement.click();
        return new ProductZalandoDetailPage(driver);
    }


    public boolean isPriceWithDiscount(){

        return productListItemWebElement.findElements(PRODUCTS_WITH_DISCOUNT).size() >0;
    }

    public boolean isProduct(){

        return productListItemWebElement.findElements(REGULAR_PRICE).size() > 0;
    }

    public double getPrice(){

            String price = "";
           List<WebElement> promotionalPrices =productListItemWebElement.findElements(PROMOTIONAL_PRICE);

           if(promotionalPrices.size() > 0){

               price = promotionalPrices.get(0).getText();
           }else{
               price = productListItemWebElement.findElement(REGULAR_PRICE).getText();
           }

           return Double.parseDouble(price.substring(1));

    }



}
