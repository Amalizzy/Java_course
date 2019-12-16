package zalandooComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubmenuComponent extends BaseComponent {

    private static By SHOES_SUB_MENU_ITEM = By.xpath("//nav[@class='z-navicat-header_categoryContainer']//a[@href='/womens-shoes/']");

    public SubmenuComponent(WebDriver driver) {
        super(driver);
    }

    public SubMenuDialogComponent clickOnShoesSubMenuItem() {

        click(SHOES_SUB_MENU_ITEM);
        return new SubMenuDialogComponent(driver);
    }
}

