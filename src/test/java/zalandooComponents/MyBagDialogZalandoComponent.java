package zalandooComponents;

import ZalandoPages.CartZalandoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyBagDialogZalandoComponent extends BaseZalandoComponent {

    private static By MY_BAG_ITEM = By.xpath("//div[@class='z-button__content']");


    public MyBagDialogZalandoComponent(WebDriver driver) {
        super(driver);
    }


    public CartZalandoPage clickOnAddToBagDialog() {

        pause(2000);

        click(MY_BAG_ITEM);
        return new CartZalandoPage(driver);
    }
}
