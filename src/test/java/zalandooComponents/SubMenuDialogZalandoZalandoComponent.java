package zalandooComponents;

import ZalandoPages.ProductsZalandoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubMenuDialogZalandoZalandoComponent extends BaseZalandoComponent {

    private static By HOVER_BOOTS_SUB_MENU_ITEM = By.xpath("/html//div[@id='z-navicat-header-root']//div[@class='z-navicat-header_subCategoryContainer']/z-grid/z-grid-item[2]/z-grid/z-grid-item[1]/a[@href='/womens-shoes-boots/']/span[.='Boots']");

    public SubMenuDialogZalandoZalandoComponent(WebDriver driver) {
        super(driver);
    }

    public ProductsZalandoPage clickOnItem(){

        click(HOVER_BOOTS_SUB_MENU_ITEM);
        return new ProductsZalandoPage(driver);
    }


}
