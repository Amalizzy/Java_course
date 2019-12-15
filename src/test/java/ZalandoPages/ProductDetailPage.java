package ZalandoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import zalandooComponents.MyBagDialogComponent;
import zalandooComponents.SizeDialogComponent;

public class ProductDetailPage extends AbstractPage {

    private static By COLOR_TITLE = By.xpath("//span[contains(@class, 'detail title-4')]");
    private static By PRICE = By.xpath("//div[contains(@class, 'h-product-price')]/div");
    private static By BUTTON_SIZE = By.xpath("//button[@type='button']/span[contains(.,'Choose your size')]");
    private static By ADD_TO_BAG =By.xpath("//span[contains(.,'Add to bag')]");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public String getColorTitle(){

        return driver.findElement(COLOR_TITLE).getText();
    }

    public double getPrice(){

        String price = driver.findElement(PRICE).getText();
        String priceWithoutSign = price.substring(1);
        int vatIndex = priceWithoutSign.indexOf("VAT");
        String priceVithoutVat = priceWithoutSign.substring(0,vatIndex);
        return  Double.parseDouble(priceVithoutVat);
    }

    public SizeDialogComponent clickOnSize(){

        click(BUTTON_SIZE);
        return new SizeDialogComponent(driver);
    }

    public MyBagDialogComponent clickOnAddToBag(){

        click(ADD_TO_BAG);
        return new MyBagDialogComponent(driver);
    }

}
