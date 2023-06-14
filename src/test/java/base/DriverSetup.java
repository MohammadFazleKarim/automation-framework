package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverSetup {

    protected static WebDriver driver;
    public static Actions action;
    public static FileInputStream fileInputStream;
    public static Properties configProperties;
    public static DesiredCapabilities caps = new DesiredCapabilities();

	public static void initDriver() throws IOException {
        String projectPath = System.getProperty("user.dir");
        fileInputStream = new FileInputStream(projectPath + "/src/test/resources/properties/Configuration.properties");
        configProperties = new Properties();
        configProperties.load(fileInputStream);

    	try {
            if (configProperties.getProperty("browser").contains("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--test-type");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-gpu");
                options.addArguments("--disable-crash-reporter");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-in-process-stack-traces");
                options.addArguments("--disable-logging");
                System.setProperty("webdriver.chrome.silentOutput", "true");
                options.addArguments("--remote-allow-origins=*");
                caps.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver(options);
            }
            else if (configProperties.getProperty("browser").contains("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("-private");
                options.addArguments("--remote-allow-origins=*");
                caps.setCapability("moz:firefoxOptions", options);
                driver = new FirefoxDriver(options);
            }
            else if (configProperties.getProperty("browser").contains("edge")) {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                options.setCapability("InPrivate", true);
                options.addArguments("--remote-allow-origins=*");
                driver = new EdgeDriver(options);
            }
            else if (configProperties.getProperty("browser").contains("ie")) {
                WebDriverManager.iedriver().setup();
                InternetExplorerOptions options = new InternetExplorerOptions().setPageLoadStrategy(PageLoadStrategy.NONE);
                caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
                caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
                driver = new InternetExplorerDriver(options);
            }
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	}
        catch(Exception e) {
    		System.out.println("Exception while launching browser");
    	}
    }
    
    
    public static void quitDriver() {
//    	driver.close();
//    	driver.quit();
    }
}
