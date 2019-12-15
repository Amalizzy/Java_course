package zalandoTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class AbstractsTest {

    private static final String BROWSER = System.getProperty("browser", "chrome");

    protected WebDriver driver;

    public static String NAVIGATE_TO_ZALANDO_HOME_PAGE = "https://www.zalando.co.uk/women-home/";

    @BeforeTest
    public void setUp() {

//        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("driver/chromedriver.exe").getPath());
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-translate");
//        options.addArguments("--lang=en-us");
//        driver = new ChromeDriver(options);
//
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//
//        driver.manage().window().maximize();
        driver = getDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to(NAVIGATE_TO_ZALANDO_HOME_PAGE);
    }

    @AfterTest
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

    private static WebDriver getChrome() {
        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("driver/chromedriver.exe").getPath());
        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1280, 1024));
        return driver;
    }

    private static WebDriver getFirefox() {
        System.setProperty("webdriver.gecko.driver", ClassLoader.getSystemResource("driver/geckodriver.exe").getPath());

        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        options.setCapability("marionette", true);
//        options.setHeadless(true);
        options.setLogLevel(FirefoxDriverLogLevel.INFO);

        WebDriver driver=new FirefoxDriver(options);
        return driver;
    }

    public static WebDriver getDriver() {
        if (BROWSER.equalsIgnoreCase("chrome")) {
            return getChrome();
        } else if (BROWSER.equalsIgnoreCase("firefox")) {
            return getFirefox();
        } else {
            throw new RuntimeException("There is now browser: " + BROWSER);
        }
    }
}
