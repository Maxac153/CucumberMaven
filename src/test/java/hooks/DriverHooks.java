package hooks;

import io.cucumber.java.After;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverHooks {
    public ChromeDriver driver;

    @Before
    public void setUpDriverBeforeScenario(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        Configuration.browserCapabilities = options;
        driver = new ChromeDriver(options);
    }

    @After
    public void etUpDriverBeforeScenario(){
        driver.close();
        driver.quit();
    }
}
