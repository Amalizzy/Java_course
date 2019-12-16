package zalandooComponents;

import ZalandoPages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubMenuDialogComponent extends BaseComponent {


    public SubMenuDialogComponent(WebDriver driver) {
        super(driver);
    }

    public ProductsPage clickOnItem(String item){

        click(By.xpath("//div[@class='z-navicat-header_subCategoryContainer']//span[text()='" + item + "']"));
        return new ProductsPage(driver);
    }

}
