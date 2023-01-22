import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.time.temporal.ChronoUnit;


abstract public class Base {

    /**
     * Main Params
     */
    public void setup() {
        Configuration.timeout = 12000;
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = Duration.of(15, ChronoUnit.SECONDS).toMillis();
    }

    /*
    Get BrowserType from testng.xml
     */
    @Parameters({"BrowserType"})
    @BeforeTest
    public void init(String BrowserType) throws Exception {
        if (BrowserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            Configuration.browser = "firefox";
        }
        else if(BrowserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            Configuration.browser = "chrome";
        }
        /*
        in case no browser were chosen throw exception
         */
        else {
            throw new Exception("Browser N/A");
        }
        setup();
    }

    @AfterTest
    public void termination(){
        Selenide.closeWebDriver();
    }
}
