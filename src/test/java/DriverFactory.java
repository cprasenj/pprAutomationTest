import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final String CHROME  = "chrome";

    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver driver;

    @BeforeSuite
    public void Setup() {
        String browser = CHROME;
        driver = new FirefoxDriver();
    }

    @AfterSuite
    public void TearDown() {
            driver.close();
            driver.quit();
    }
}