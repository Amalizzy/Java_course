package pages;

import components.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private HeaderComponent headerComponent;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.headerComponent = new HeaderComponent(driver);
    }

    protected void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

   public HeaderComponent getheader(){

        return headerComponent;
   }
}
