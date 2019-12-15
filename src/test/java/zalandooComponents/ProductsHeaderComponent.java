package zalandooComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsHeaderComponent extends BaseComponent {

    private static By PRICE_MENU_ITEM = By.xpath("//button[contains(.,'Price')]");

    public ProductsHeaderComponent(WebDriver driver) {
        super(driver);
    }

    public PriceFilterDialogForProductsComponent clickOnPrice() {

        click(PRICE_MENU_ITEM);
        return new PriceFilterDialogForProductsComponent(driver);
    }
}
