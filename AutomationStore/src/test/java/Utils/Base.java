package Utils;
import Property.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class Base {

    public WebDriver driver;

    PropertyReader pr=new PropertyReader();
    private static final Logger log =  LogManager.getLogger(Base.class);


    public WebDriver WebDriverManager() throws IOException {
        pr.Load(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        if(driver==null) {
            if(pr.GetValue("browser").equalsIgnoreCase("chrome")) {
                ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File(System.getProperty("user.dir") + "//src//test//java//Driver//chromedriverlatest")).build();
                service.start();
                driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
                log.info("setting driver");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
                options.addArguments("--no-sandbox"); // Bypass OS security model
            }
            if(pr.GetValue("browser").equalsIgnoreCase("firefox")){
                //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//test//java//Driver//geckodriver");
                driver = new FirefoxDriver();
                log.info("setting firefox driver");
            }
            driver.manage().window().maximize();
            driver.navigate().to(pr.GetValue("url"));
        }
        return driver;
    }
}
