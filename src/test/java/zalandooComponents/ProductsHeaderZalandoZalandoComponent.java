package zalandooComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsHeaderZalandoZalandoComponent extends BaseZalandoComponent {

    private static By PRICE_MENU_ITEM = By.xpath("//button[contains(.,'Price')]");

    public ProductsHeaderZalandoZalandoComponent(WebDriver driver) {
        super(driver);
    }

    public PriceFilterDialogForProductsZalandoComponent clickOnPrice() {

        click(PRICE_MENU_ITEM);
        return new PriceFilterDialogForProductsZalandoComponent(driver);
    }
}
