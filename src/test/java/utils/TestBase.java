package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {
        // Read from global.properties file
        FileInputStream fis = new FileInputStream("src/test/resources/global.properties");
        Properties prop = new Properties();
        prop.load(fis);

        // Environment variables (take precedence)
        String baseUrl = System.getenv("BASE_URL");
        String browserEnv = System.getenv("BROWSER");

        // CLI properties (fallback)
        if (baseUrl == null || baseUrl.isEmpty()) {
            baseUrl = prop.getProperty("linkUrl");
        }
        if (browserEnv == null || browserEnv.isEmpty()) {
            browserEnv = System.getProperty("browser", prop.getProperty("browser"));
        }

        if (driver == null) {
            if (browserEnv == null) {
                throw new IllegalStateException("Browser not specified. Set BROWSER env var or use -Dbrowser flag");
            }
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            switch (browserEnv.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalStateException("Unsupported browser: " + browserEnv);
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            driver.get(baseUrl);
        }
        return driver;
    }
}
