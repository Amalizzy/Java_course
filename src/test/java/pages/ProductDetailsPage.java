package pages;

import components.AddToCartDialogComponent;
import components.HeaderComponent;
import components.MainMenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends AbstractPage{

    private static String BUTTON_ADD_TO_CARD ="//button[@type='submit']/span[contains(.,'Add to cart')]";
    private static String H1_PRODUCT_TITLE_XPATH ="//h1[@class='product-title']";
    private static String DIV_PRICE_XPATH ="(//div[@class='price--main'])[1]//span[contains(@class, 'money')]";

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public AddToCartDialogComponent clickOnAddToCard(){

        driver.findElement(By.xpath(BUTTON_ADD_TO_CARD)).click();
        return new AddToCartDialogComponent(driver);
    }

    public boolean cartButtonDoesNotExist(){

        return driver.findElements(By.xpath(BUTTON_ADD_TO_CARD)).size()==0;
    }

    public String getProductTitle(){

        return driver.findElement(By.xpath(H1_PRODUCT_TITLE_XPATH)).getText();
    }

    public double getPrice(){

        String price = driver.findElement(By.xpath(DIV_PRICE_XPATH)).getText();
        String priceWithoutSign = price.substring(1);
        return  Double.parseDouble(priceWithoutSign);
    }

}
