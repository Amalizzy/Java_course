package zalandooComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PriceFilterDialogForProductsComponent extends BaseComponent {

    private static By CHECKBOX_SPECIAL_OFFER = By.xpath("//span[contains(.,'Only special offers')]");
    private static By BUTTON_SAVE = By.xpath("//div[@class='cat_pane-xETbh']//button[contains(.,'Save')]");
    private static By PRICE_RANGE_MINIMUM = By.xpath("//input[@aria-label='add the minimum price']");
    private static By PRICE_RANGE_MAXIMUM = By.xpath("//input[@aria-label='add the maximum price']");

    public PriceFilterDialogForProductsComponent(WebDriver driver) {
        super(driver);
    }

    public void selectOnlySpecialOffers(){

        click(CHECKBOX_SPECIAL_OFFER);
        clickOutOfScreen(BUTTON_SAVE);
    }

    public void setPriceRange(String lowestPrice, String higestPrice){

        driver.findElement(PRICE_RANGE_MINIMUM).sendKeys(Keys.CONTROL + "a");
        driver.findElement(PRICE_RANGE_MINIMUM).sendKeys(lowestPrice);
        pause(2000);
        driver.findElement(PRICE_RANGE_MAXIMUM).sendKeys(Keys.CONTROL + "a");
        driver.findElement(PRICE_RANGE_MAXIMUM).sendKeys(higestPrice);

        clickOutOfScreen(BUTTON_SAVE);
    }






}
