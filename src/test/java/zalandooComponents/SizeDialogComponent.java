package zalandooComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SizeDialogComponent extends BaseComponent {

    public SizeDialogComponent(WebDriver driver) {
        super(driver);
    }

    public void  chooseSizeShoes(String size){

        click(By.xpath("//h5[contains(.,'" + size + "')]"));
    }


}
