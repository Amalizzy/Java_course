package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class AbstractBaseTest {

    protected WebDriver driver;

    public static String NAVIGATE_TO_TELEGRAMME_HOME_PAGE = "https://telegramme.co.uk/";

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("driver/chromedriver.exe").getPath());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-translate");
        options.addArguments("--lang=en-us");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.navigate().to(NAVIGATE_TO_TELEGRAMME_HOME_PAGE);
    }

    @AfterClass
    public void tearDown() {

//        driver.close();
//        driver.quit();
    }

    protected void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
