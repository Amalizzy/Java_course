package zalandooComponents;

import ZalandoPages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent extends BaseComponent {


    private static By WOMAN_MENU_ITEM = By.xpath("//a/span[contains(.,'Women')]");
    private static By CART_MENU_ITEM = By.xpath("//a[@href='/cart/']");

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public SubmenuComponent clickOnWomanMenuItem() {

        click(WOMAN_MENU_ITEM);
        return new SubmenuComponent(driver);
    }

    public CartPage clickOnCart(){

        click(CART_MENU_ITEM);
        return new CartPage(driver);
    }

}
