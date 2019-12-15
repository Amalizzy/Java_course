package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseComponent {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseComponent(WebDriver driver){

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
}
