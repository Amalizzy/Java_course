package zalandooComponents;

import ZalandoPages.CartZalandoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderZalandoComponent extends BaseZalandoComponent {


    private static By WOMAN_MENU_ITEM = By.xpath("//a/span[contains(.,'Women')]");
    private static By CART_MENU_ITEM = By.xpath("//a[@href='/cart/']");

    public HeaderZalandoComponent(WebDriver driver) {
        super(driver);
    }

    public SubmenuComponent clickOnWomanMenuItem() {

        click(WOMAN_MENU_ITEM);
        return new SubmenuComponent(driver);
    }

    public CartZalandoPage clickOnCart(){

        click(CART_MENU_ITEM);
        return new CartZalandoPage(driver);
    }

}
