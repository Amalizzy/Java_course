package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainMenuComponent extends BaseComponent {

    private static String MENU_ITEM_CRISTMAS_XPATH ="//div[contains(@class, 'site-navigation-wrapper')]//ul[@class='navmenu navmenu-depth-1']//li[contains(@class, 'navmenu-id-shop')]/a[contains(.,'SHOP')]";
    private static String HOVER_SHOP_XPATH ="//li[contains(@class, 'navmenu-meganav-item-parent')]/a[contains(., 'SHOP')]/*[1]";
    private static String HAMBURGER_MENU_XPATH ="//a[contains(@class, 'site-header-menu-button')]";

    public MainMenuComponent(WebDriver driver) {
        super(driver);
    }

    public void clickOnMenuItem(){

        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.linkText(MENU_ITEM_CRISTMAS_XPATH));
        builder.moveToElement(element).build().perform();
    }

    public ShopSubMenuComponents hoverOnShopMenuItem(){

//        pause(2000);

        WebElement element =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(HOVER_SHOP_XPATH)));
        Actions actions = new Actions((driver));
        actions.moveToElement(element);
        actions.perform();

        return new ShopSubMenuComponents(driver);
    }


}
