package zalandooComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseZalandoComponent {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseZalandoComponent(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    protected void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void click(By by ){

        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected void clickOutOfScreen(By by){

        WebElement element = driver.findElement(by);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }
}
