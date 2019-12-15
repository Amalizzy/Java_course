package zalandoTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class AbstractsTest {

    protected WebDriver driver;

    public static String NAVIGATE_TO_ZALANDO_HOME_PAGE = "https://www.zalando.co.uk/women-home/";

    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("driver/chromedriver.exe").getPath());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-translate");
        options.addArguments("--lang=en-us");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.navigate().to(NAVIGATE_TO_ZALANDO_HOME_PAGE);
    }

    @AfterTest
    public void tearDown() {

        driver.close();
        driver.quit();
    }

    protected void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
