package zalandooComponents;

import ZalandoPages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyBagDialogComponent extends BaseComponent {

    private static By MY_BAG_ITEM = By.xpath("//div[@class='z-button__content']");

    public MyBagDialogComponent(WebDriver driver) {
        super(driver);
    }

    public CartPage clickOnAddToBagDialog() {

        pause(2000);
        click(MY_BAG_ITEM);
        return new CartPage(driver);
    }
}
