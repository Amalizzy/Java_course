package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CardPage;

public class HeaderComponent extends BaseComponent {

    private static String HAMBURGER_MENU_XPATH ="//a[contains(@class, 'site-header-menu-button')]";
    private static String CARD_XPATH ="//div[contains(@class, 'site-header-cart-icon')]";

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public CardPage   clickOnCard(){

        driver.findElement(By.xpath(CARD_XPATH)).click();
        return new CardPage(driver);
    }

    public MainMenuComponent clickOnHamburgerMenu(){

        driver.findElement(By.xpath(HAMBURGER_MENU_XPATH)).click();
        return new MainMenuComponent(driver);
    }
}
