package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CardPage;

public class AddToCartDialogComponent extends BaseComponent {

    public static String BUTTON_ADD_TO_CARD_XPATH = "(//footer[@class='atc-banner--cart-footer']/a[contains(.,'View cart')])[1]";

    public AddToCartDialogComponent(WebDriver driver) {
        super(driver);
    }

    public CardPage clickOnWievCart(){

        pause(2000);

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_ADD_TO_CARD_XPATH))).click();
        driver.findElement(By.xpath(BUTTON_ADD_TO_CARD_XPATH)).click();

        return new CardPage(driver);
    }
}
